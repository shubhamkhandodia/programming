#include <stdio.h>
#include<iostream>
using namespace std; 
  
// A recursive binary search function. It returns 
// location of x in given array arr[l..r] is present, 
// otherwise -1 
int binarySearch(int arr[], int l, int r, int x,int count) 
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2;
		 
  
        // If the element is present at the middle 
        // itself 
        if (arr[mid] == x)
		{
			count++;
			return mid;
		} 
             
  
        // If element is smaller than mid, then 
        // it can only be present in left subarray 
        else if (arr[mid] > x)
		{
			return binarySearch(arr, l, mid - 1, x,count++);
		} 
             
  
        // Else the element can only be present 
        // in right subarray
		else
		{
			return binarySearch(arr, mid + 1, r, x,count++);
		} 
         
    } 
  
    // We reach here when element is not 
    // present in array 
    return -1; 
} 
  
int main(void) 
{ 
	int count=0;
    int arr[] = { 2, 3, 4, 10, 40 }; 
    int n = sizeof(arr) / sizeof(arr[0]); 
    int x = 10; 
    int result = binarySearch(arr, 0, n - 1, x,count); 
    (result == -1) ? printf("Element is not present in array") 
                   : printf("Element is present at index %d", 
                            result);
							
	cout<<endl<<count; 
    return 0; 
} 
