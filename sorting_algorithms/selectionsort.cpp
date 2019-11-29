#include<iostream>
using namespace std;


//selection sort
void selectionsort(int a[],int n)
{
	int i,min,j;
	
	for(i=0;i<n;i++)
	{
		min= i;
		
		for(int j=i+1;j<n;j++)
		{
			if(a[j]<a[min])
			min = j;
		}
		
		int temp;
	
		temp=a[i];
		a[i]=a[min];
		a[min]=temp;
		
	}
	
}


void printArray(int arr[], int n) 
{ 
	int i; 
	for (i = 0; i < n; i++) 
		cout << arr[i] << " "; 
	cout << endl; 
}

int main()
{
	
	int n ;
	
	cout<<"enter the number of elements "<<endl;
	cin>>n; //length of array
	
	int arr[n] ;
	
	cout<<"enter the elements "<<endl;
	
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}

	selectionsort(arr, n); 
	printArray(arr, n);
	
	return 0;
}

