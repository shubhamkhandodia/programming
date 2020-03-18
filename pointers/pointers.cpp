#include <iostream>
using namespace std;
int main() 
{
  int x = 5,y = 7;
  cout<<x<<"\n"<<&x<<"\n"<<*&x<<endl;

  // &x = 7 (will give error because &x is a constant which stores address of x bur values can only be stored in a variable)

  //but if we want to store an address in some other variable how should we declare that variable?

  int *j,*k; //this is a variable which doesn't store normal integers but stores address of other integers

  j = &y;
  cout<<"Address of integer y\n"<<j;

  //now what about address of j?
  //it has a different value which we can store in another variable

  //k = &j;        but this will be wrong why ?
                  //because j is already a special variable to store an address so to store its address we need to use a variable with two ** for example

  int **p;

  p = &j;   //now this is ok

  cout<<"\nthis is the address of the variable j which is storing the address of y\n"<<p;

  //similarly to store the address of p

  int ***q;

  q = &p;

  //now if we want to access y using p then what ?

  
}