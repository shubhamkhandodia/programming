#include<iostream>
using namespace std;


//sorts in ascending order

void bubblesort(int a[],int x)
{
	for(int i=0;i<x;i++)
	{
		for(int j=0;j<x;j++)
		{
			if(a[i]<=a[j])
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
}

int main()
{
	int n; //total number of elements
	
	cout<<"enter the total number of elements "<<endl;
	cin>>n;
	int array[n];
	
	cout<<"enter elements "<<endl;
	
	for(int i=0;i<n;i++)
	{
		cin>>array[i];
	}
	
	
	bubblesort(array,n);
	
	for(int i=0;i<n;i++)
	{
		cout<<array[i]<<" ";
	}
	
	return 0;
}

