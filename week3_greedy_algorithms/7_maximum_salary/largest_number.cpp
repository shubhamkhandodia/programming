#include <algorithm>
#include <iostream>
#include <vector>
#include<list>
#include<string>
#include<sstream>

using namespace std;

using std::vector;
using std::string;

string largest_number(vector<string> a) 
{
	
	string result;
	
	vector<int>numbers;
	vector<int>splittednumbers;
	
	for(int i=0;i<a.size();i++)
	{
		numbers.push_back(atoi(a[i].c_str()));
	}
	
	for(int i=0;i<numbers.size();i++)
	{
		int value = numbers[i];
		while (value > 0) 
		{
 			int digit = value % 10;
 			splittednumbers.push_back(digit);
 			value /= 10;
		}
	}
	
	sort(splittednumbers.begin(),splittednumbers.end(),greater<int>());
	
	for(int i=0;i<splittednumbers.size();i++)
	{
		stringstream ss;
		ss << splittednumbers[i];
		result+=ss.str();
	}
	
  
  return result;
}

int main() {
  int n;
  std::cin >> n;
  vector<string> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  std::cout << largest_number(a);
  
}
