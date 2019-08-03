#include <iostream>
#include<cstdlib>
#include<ctime>
using namespace std;

long long lcm_naive(int a, int b) {
  for (long l = 1; l <= (long long) a * b; ++l)
    if (l % a == 0 && l % b == 0)
      return l;

  return (long long) a * b;
}


long long check(long long x,long long y)
{
	long long gcdcalculate=1;
	if(y%x==0)
	return x;
	
	else
	{
		for(int i=2;i<=x/2;i++)
		{
			if(x%i==0 && y%i==0)
			{
				gcdcalculate=i;
			}
			
		}
	return gcdcalculate;
	}
	
}

long long lcm_fast(long long a,long long b)
{
	
	long long product ;
	
	product = a*b;
	
	if(a<1 || b<1)
	return 0;
	
	else if(a==1 && b!=1)
	return b;
	
	else if(a!=1 && b==1)
	return a;
	
	else if(a>b)
	return product/check(b,a);
	
	else
	return product/check(a,b);
	
}
int main() {
	
/*	int a, b;
	
	srand((unsigned)time(0));
	while(1)
	{
		a=rand()%1000000+1;
		b=rand()%1000000+1;
		
		cout<<a<<" "<<b<<endl;
		cout<<lcm_naive(a, b)<<" "<<lcm_fast(a,b)<<endl;
		
		if(lcm_naive(a, b)!=lcm_fast(a,b))
		{
			cout<<endl<<"wrong!"<<endl;
			break;
		}
	}*/
  int a, b;
  std::cin >> a >> b;
  std::cout << lcm_fast(a, b) << std::endl;
  return 0;
}
