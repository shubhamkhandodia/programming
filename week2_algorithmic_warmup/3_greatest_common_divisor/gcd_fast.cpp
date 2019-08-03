#include <iostream>
#include<cstdlib>
#include<ctime>
using namespace std;

int gcd_naive(int a, int b) {
  int current_gcd = 1;
  for (int d = 2; d <= a && d <= b; d++) {
    if (a % d == 0 && b % d == 0) {
      if (d > current_gcd) {
        current_gcd = d;
      }
    }
  }
  return current_gcd;
}

long long check(long long x,long long y)
{
	long long gcdcalculate=1;
	if(y%x==0)
	return x;
	
	else if(x==0)
	return y;
	
	else if(y==0)
	return x;
	
	
	else
	{
		return check(y%x,x);
	}
	
}

long long gcd_fast(long long a,long long b)
{
	
	if(a>b)
	return check(b,a);
	
	else
	return check(a,b);
	
}

int main() {
	
	int a, b;
	
/*	srand((unsigned)time(0));
	while(1)
	{
		a=1000000000 + rand() % (( 10000000000 + 1 ) - 1000000000);
		b=1000000000 + rand() % (( 10000000000 + 1 ) - 1000000000);
		
		cout<<a<<" "<<b<<endl;
		cout<<gcd_naive( a, b)<<" "<<gcd_fast(a,b);
		
		if(gcd_naive(a, b)!=gcd_fast(a,b))
		{
			cout<<endl<<"wrong!"<<endl;
			break;
		}
	}*/
 
  std::cin >> a >> b;
  std::cout << gcd_fast(a, b) << std::endl;
  return 0; 
}
