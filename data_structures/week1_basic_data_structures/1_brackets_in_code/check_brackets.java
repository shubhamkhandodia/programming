import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets{
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int position;

        boolean getout = false;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (position = 0; position < text.length(); ++position) 
        {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') 
            {

                Bracket b1 = new Bracket(next,position);

                opening_brackets_stack.push(b1);

            }



            if (next == ')' || next == ']' || next == '}') 
            {
                if(!opening_brackets_stack.empty())
                {
                  if(!opening_brackets_stack.peek().Match(next))
                  {
                    System.out.println(position+1);
                    getout = true;
                    break;
                  }

                  else
                  {
                    opening_brackets_stack.pop();
                  }
                }

                else
                {
                  System.out.println(position+1);
                  getout = true;
                  break;
                }   
            }
        }


        if(!getout)
            {
              if(opening_brackets_stack.empty())
              {
                  System.out.println("Success");
              }

              else
              System.out.println(opening_brackets_stack.peek().position + 1);
              
            }

    }
}