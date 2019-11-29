#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int min(int x,int y)
{
	if(x<y)
	return x;
	else
	return y;
}

int get_change(int amount) 
{
	
	vector<int>coins = {1,3,4};
	if(amount<=1)
	{
		return amount;
	}
	
	else
	{
	/*	int i,j;
		int coin = 3;
		int matrix[coin][m+2];
		
		for(i=0;i<coin;i++)
		{
			for(j=0;j<=m+1;j++)
			{
				matrix[i][j]=0;
			}
		}
		
		matrix[0][0]=0;
		matrix[1][0]=0;
		matrix[2][0]=0;
		matrix[0][m+1]=1;
		matrix[1][m+1]=3;
		matrix[2][m+1]=4;
		
		for(j=1;j<=m;j++)
		{
			matrix[0][j] = j;
		}
		
		for(int i=1;i<coin;i++)
		{
			for(int j=1;j<matrix[i][m+1];j++)
			{
				matrix[i][j]=matrix[i-1][j];
			}
			
			for(j=matrix[i][m+1];j<=m;j++)
			{
				int x;
				x=min(j,1+matrix[i][j-matrix[i][m+1]]);
				matrix[i][j] = x;
			}
		}
		
		return matrix[coin-1][m];
		*/
		
		int *dp = new int[amount+1];
	
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			dp[i] = -1;
			for (int j = 0; j < coins.size(); j++) {
				int index = i - coins[j];
				if (index < 0) continue;
				if (dp[index] >= 0) 
					dp[i] = dp[i] == -1 ? dp[index] + 1 : min(dp[index] + 1, dp[i]);
			}
		}
		
		return dp[amount];
	}
	
}

int main() {
  int money;		//total money
  cin >> money;
  cout << get_change(money) << '\n';
}
