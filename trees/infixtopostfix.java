import java.util.*;
import java.io.*;
import java.lang.*; 

class Main 
{
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
	
	
	public static String infixToPostfix(String s) 
	{ 
		String b = new String(""); 
		
		Stack<Character> z = new Stack<Character>(); 
		
		for (int i = 0; i<s.length(); i++) 
		{ 
			char c = s.charAt(i); 
			
			if (Character.isLetterOrDigit(c)) 
				b += c;
			 
			else if (c == '(')
				z.push(c);
			
			else if (c == ')')
			{ 
				while (!z.isEmpty() && z.peek() != '(') 
					b += z.pop(); 
				
				if (!z.isEmpty() && z.peek() != '(') 
					return "Invalid Expression"; 				 
				else
					z.pop();
			} 
			else   //if the character is an operator pop all the characters at the top of the stack with greater than or equal precedence to the operator present
			{ 
				while (!z.isEmpty() && precedence(c) <= precedence(z.peek()))
        { 
					if(z.peek() == '(') 
						return "Invalid Expression"; 
					b += z.pop(); 
			  } 
				z.push(c); 
			} 
	
		} 
	
		while (!z.isEmpty())
    { 
			if(z.peek() == '(') 
				return "Invalid Expression"; 
			b += z.pop(); 
		} 
		return b;
	} 
	
	public static void main(String[] args) 
	{
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the infix expression :");
		String exp = scan.nextLine(); 
		System.out.println(infixToPostfix(exp)); 
	} 
} 
