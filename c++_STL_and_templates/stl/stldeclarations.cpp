#include <iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<stack>
#include<set>
#include<map>
#include<string>
#include<unordered_map>
#include<unordered_set>
#include<iterator>
#include<deque>

using namespace std;

int main() 
{
  //containers in stl
  
  //1: if order is important

  vector<int> x;
  deque<int> y2 ; //same as vector but we can easily add and delete elements from the front also
  queue <int> y;
  stack <int> z;
  priority_queue<int> a;

  //else if : duplicates are allowed or not

  //1. yes

  multiset <int, greater <int> > gquiz1; 

  // if mapping is needed with duplicates allowed

  multimap<int,string> d;

  //2/ no

  set<int> f;

  // if mapping is needed with duplicates allowed

  map<int,string> g;

  //iterators for each

  vector<int>::iterator i = x.begin();

  for(int j=0;j<5;i++)
  {
    int w1;
    cin>>w1;
    x.push_back(w1);
  }

  vector<int>:: iterator i2 = find(x.begin(),x.end(),22); //find the element 22 and iterator will stay there


  //now let's look at deque

  y2.push_front(23); //more functionality than a vector
}