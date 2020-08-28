import java.util.*;
import java.lang.*;

class infix_to_postfix
{
	public static void main(String[] args)
	{
		String infix = "(A+((B+C)+(D+E)*F)/G)";

		String postfix = infixtopostfix(infix);

		System.out.println(postfix);
	}

	public static String infixtopostfix(String infix)
	{
		String mypostfix = "";

		Stack<Character> stack = new Stack<>();

		int i=0;

		while(i<infix.length())
		{
			if(Character.isLetter(infix.charAt(i)))
				mypostfix+=Character.toString(infix.charAt(i));

			else if(infix.charAt(i) == '(')
				stack.push(infix.charAt(i));

			else if(infix.charAt(i) == ')')
			{
				while(stack.peek()!='(' && !stack.isEmpty())
				{
					mypostfix+=Character.toString(stack.pop());
				}

				if(stack.peek()!='(' && !stack.isEmpty())
					return "invalid expression";
				else
					stack.pop();
			}

			else
			{
				while(!stack.isEmpty() && precedence(infix.charAt(i))<=precedence(stack.peek()))
				{
					if(stack.peek() == '(')
						return "Invaliid expression";
					mypostfix+=Character.toString(stack.pop());
				}

				stack.push(infix.charAt(i));
					
			}

			i++;
		}

		while(!stack.isEmpty())
		{
			if(stack.peek() == '(')
				return "Invalid expression";
			mypostfix+=stack.pop();
		}

		return mypostfix;
	}

	static int precedence(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 

}