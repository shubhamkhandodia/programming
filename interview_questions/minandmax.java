import java.util.*;
import java.io.*;
import java.lang.*;

class minandmax
{

	public static class Pair
	{
		int min;
		int max;
	}

	public static void main(String[] args)
	{
		int size;

		System.out.println("input the array Size");

		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();

		int[] input = new int[size];

		System.out.println("input the array Elements");

		for(int i=0;i<size;i++)
		{
			input[i] = scan.nextInt();
		}

		Pair minmaxpair = maxandmin(input,0,input.length-1);

		System.out.println(minmaxpair.min+" "+minmaxpair.max);
	}


	public static Pair maxandmin(int[] arr,int low,int high)
	{
		Pair answer = new Pair();
		Pair answerleft = new Pair();
		Pair answerright = new Pair();

		if(low==high)
		{
			answer.min = arr[low];
			answer.max = arr[low];
			return answer;
		}

		if(high == low+1)
		{
			answer.min = Math.min(arr[low],arr[high]);
			answer.max = Math.max(arr[low],arr[high]);
			return answer;
		}
		int mid = low + (high-low)/2;
		answerleft = maxandmin(arr,low,mid);
		answerright = maxandmin(arr,mid+1,high);

		answer.min = Math.min(answerleft.min,answerright.min);
		answer.max = Math.max(answerleft.max,answerright.max);

		return answer;

	}
}