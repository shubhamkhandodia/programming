#include <bits/stdc++.h>
#include<iostream> 
using namespace std; 

/* Function to sort an array using insertion sort*/
void insertionSort(int arr[], int n) 
{
	int i,j,key;
	
	for(int i=1;i<n;i++)
	{
		key = arr[i];
		j=i-1;
		
		while(j>=0 && arr[j]>key)
		{
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;
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
	cin>>n;
	
	int arr[n] ;
	
		cout<<"enter the elements "<<endl;
	
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}

	insertionSort(arr, n); 
	printArray(arr, n); 

	return 0; 
} 


