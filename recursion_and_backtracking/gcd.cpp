#include<iostream>
#include<cstdlib>
#include<bitset>

using namespace std;

int recursive(int a,int b)
{
	if(a==1 || b==1)
		return 1;

	if(a>b)
	{
    
		if(a%b==0)
			return b;

		else
			return recursive(b,a%b);
	}

	else
	{
		if(b%a==0)
			return a;
		else
			return recursive(a,b%a);
	}
}

int main()
{
	int x,y ;
	cout<<"enter the numbers you want the gcd for :"<<endl;
	cin>>x>>y;

	cout<<"the gcd is : "<<recursive(x,y);
}