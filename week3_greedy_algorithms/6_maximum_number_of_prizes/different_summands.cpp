#include <iostream>
#include<cstdlib>
#include<ctime>
#include <vector>

using std::vector;

vector<int> optimal_summands(int n) 
{
	
  int x=n;
  
  vector<int> summands;
  
  int i=1;

  while(n!=0)
  {
  	x=n-i;
  	if(x<i+1)
  	{
  		summands.push_back(n);
  		break;
  	}
  	else if(x==i+1)
  	{
  		summands.push_back(i);
  		summands.push_back(x);
  		break;
  	}
  	
  	summands.push_back(i);
  	n=x;
  	i++;
  }
  
  return summands;
}

int main() 
{
  int n;
  std::cin >> n;
  vector<int> summands = optimal_summands(n);
  std::cout << summands.size() << '\n';
  for (size_t i = 0; i < summands.size(); ++i) 
  {
    std::cout << summands[i] << ' ';
  }
}
