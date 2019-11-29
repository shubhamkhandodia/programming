#include<iostream>
using namespace std;


//merge sort
void mergesort(int a[],int n)
{
	if(n<=1)
	return;
	
	int mid = n/2;
	
	
	
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

	mergesort(arr, n); 
	printArray(arr, n);
	
	return 0;
}

