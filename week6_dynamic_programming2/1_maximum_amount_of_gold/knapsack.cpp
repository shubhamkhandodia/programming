#include <iostream>
#include <vector>
#include<algorithm>

using std::vector;
using namespace std;

int max(int a, int b) { return (a > b)? a : b; }

int optimal_weight(int W, const vector<int> &w) 
{
  if(W<=1)
  {
  	return W;
  	//return;
  }
  
  else
  {
  	
  	vector<int>correspondingweight;
  	correspondingweight = w;
  	sort(correspondingweight.begin(),correspondingweight.end());
  	
  	int rows = correspondingweight.size();  //size of the weight array
  	
  	vector< vector<int> >matrix(rows+1);
  	for (int i = 0 ; i <= rows ; i++)
		matrix[i].resize(W+1);
		
		
	for (int i = 0; i <= rows; i++) 
   { 
       for (int w = 0; w <= W; w++) 
       { 
           if (i==0 || w==0) 
               matrix[i][w] = 0; 
           else if (correspondingweight[i-1] <= w) 
                 matrix[i][w] = max(correspondingweight[i-1] + matrix[i-1][w-correspondingweight[i-1]],  matrix[i-1][w]); 
           else
                 matrix[i][w] = matrix[i-1][w]; 
       } 
   }
	
	return matrix[rows][W];
	
	/*for(int i=0;i<=rows;i++)
	{
		for(int j=0;j<=W;j++)
		{
			cout<<matrix[i][j]<<"      ";
		}
		cout<<endl;
	}*/
  	
  }
  
  
  
}

int main() {
  int n, W;
  cin>>W ;
  cin>>n;
  vector<int> w(n);
  for (int i = 0; i < n; i++) 
  {
    cin >> w[i];
  }
  cout << optimal_weight(W, w) << '\n';
  //optimal_weight(W, w);
}
