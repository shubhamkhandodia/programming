#include <iostream>
#include<set>
#include<unordered_set>
#include<iterator>

using namespace std;

int main() 
{
  set<int> gquiz1;
  multiset<int> y;

    gquiz1.insert(40);
    gquiz1.insert(30); 
    gquiz1.insert(60); 
    gquiz1.insert(20); 
    gquiz1.insert(50); 
    gquiz1.insert(50); // only one 50 will be added to the set
    gquiz1.insert(10);

    //how to iterate through a set ?

    set<int>::iterator it ;

    for(it = gquiz1.begin();it!=gquiz1.end();it++)
    {
      cout<<*it<<"\n";
    }

    multiset<int>p;

    p.insert(40);
    p.insert(50);
    p.insert(50); //here both the 50s will be inserted
    p.insert(70);

    multiset<int>::iterator it1 = p.begin();

    while(it1 != p.end())
    {
      cout<<*it1<<"\n";
      it1++;
    }

    bool b = gquiz1.empty();
    cout<<"\n"<<b;

    gquiz1.clear();

    bool c = gquiz1.empty();
    cout<<"\n"<<c;
}