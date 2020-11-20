import java.util.*;
import java.io.*;
import java.lang.*;

class minimizetheheights
{
	public static void main(String[] args)
	{
		int size,left=0,k;

		System.out.println("input the array Size");

		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();

		System.out.println("input k");

		int right = size-1;

		int[] input = new int[size];

		System.out.println("input the array Elements");

		for(int i=0;i<size;i++)
		{
			input[i] = scan.nextInt();
		}
	}
}