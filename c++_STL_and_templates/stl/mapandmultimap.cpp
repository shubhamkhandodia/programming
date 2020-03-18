#include <iostream>
#include<algorithm>
#include<map>
#include<iterator>
#include<string>

using namespace std;

int main() 
{
  map<int,string> t ;

  //automatically keeps them in ascending order of first element(key)

  t.insert(pair<int,string>(100,"stars"));
  t.insert(pair<int,string>(10,"cherry"));
  t.insert(pair<int,string>(143,"fade"));
  t.insert(pair<int,string>(17,"way"));
  t.insert(pair<int,string>(16,"maybe"));
  t.insert(pair<int,string>(18,"wreck"));
  t.insert(pair<int,string>(133,"one"));

  map<int,string>:: iterator it = t.begin();

  while(it != t.end())
  {
    cout<<it->first<<" "<<it->second<<endl;
    it++;
  }
  
  t.erase(t.begin(), t.find(17)); //ersases all items until 17 is found(item with 17 as key is not included)

  cout<<"after erasing items "<<endl;

  for(it = t.begin();it!=t.end();it++)
  {
    cout<<it->first<<" "<<it->second<<endl;
  }
}