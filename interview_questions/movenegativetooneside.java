import java.util.*;
import java.io.*;
import java.lang.*;

class movenegativetooneside
{
	public static void main(String[] args)
	{

		int size,left=0;

		System.out.println("input the array Size");

		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();

		int right = size-1;

		int[] input = new int[size];

		System.out.println("input the array Elements");

		for(int i=0;i<size;i++)
		{
			input[i] = scan.nextInt();
		}

		while(left<right)
		{
			if(input[left]<0)
			{
				if(input[right]<0)
					right--;
				else
				{
					left++;
				}
			}
			else if(input[left]>0)
			{
				if(input[right]<0)
				{
					int temp = input[left];
					input[left] = input[right];
					input[right] = temp;
				}
				right--;
			}
		}

		for(int i=0;i<size;i++)
		{
			System.out.print(input[i]+" ");
		}
	}
}