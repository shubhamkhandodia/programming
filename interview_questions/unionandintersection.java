/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class unionandintersection {
	public static void main (String[] args) {
		//code
		int size1,size2,choice;

		System.out.println("input the first array Size");

		Scanner scan = new Scanner(System.in);

		size1 = scan.nextInt();

		int[] input1 = new int[size1];

		System.out.println("input the first array Elements");

		for(int i=0;i<size1;i++)
		{
			input1[i] = scan.nextInt();
		}

		System.out.println("input the second array Size");

		size2 = scan.nextInt();

		int[] input2 = new int[size2];

		System.out.println("input the second array Elements");

		for(int i=0;i<size2;i++)
		{
			input2[i] = scan.nextInt();
		}
		
		System.out.println("Do you want to find intersection or union ? (1 for intersection and 2 for union)");

		choice = scan.nextInt();
		
		switch(choice)
		{
		    case 1:
		        {
		            HashSet<Integer> comparisonset = new HashSet<>();
		            HashSet<Integer> intersection = new HashSet<>();
		            
		            for(int i=0;i<size1;i++)
		            {
		            	comparisonset.add(input1[i]);
		            }

		            for(int i=0;i<size2;i++)
		            {
		            	if(comparisonset.contains(input2[i]))
		            	{
		            		intersection.add(input2[i]);
		            	}
		            }

		            System.out.println("Here's the intersection");

		            Iterator<Integer> it = intersection.iterator();

		            while(it.hasNext())
		            {
		            	System.out.print(it.next()+" ");
		            }

		            break;
		        }

		    case 2:
		        {
		             HashSet<Integer> union = new HashSet<>();

		             for(int i=0;i<size1;i++)
		             {
		             	union.add(input1[i]);
		             }

		             for(int i=0;i<size2;i++)
		             {
		             	union.add(input2[i]);
		             }

		             System.out.println("Here's the union");

		            Iterator<Integer> it = union.iterator();

		            while(it.hasNext())
		            {
		            	System.out.print(it.next()+" ");
		            }

		            break;
		        }

		        default :
		        	break;
		}
	}
	
}