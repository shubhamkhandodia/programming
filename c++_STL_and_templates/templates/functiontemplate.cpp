#include <iostream>
using namespace std;
//why do we use templates
int greaterelement(int a,int b)
{
  if(a>b)
  return a;
  return b;
}

template<typename t,typename u>
t greaterelementpart2(t x,u y)
{
  if(x>y)
  return x;
  return y;
}

int main() 
{
  cout<<"the greater element is"<<endl;
  cout<<greaterelement(3,4)<<endl;
 // cout<<greaterelement(3.4, 3.41); this will show error because the arguments are not integers but now i will use a template so we can pass any data type

 cout<<greaterelementpart2(3.41, 3.414)<<endl;
 cout<<greaterelementpart2(3.14, 3); //if you want to compare two different types of data
}