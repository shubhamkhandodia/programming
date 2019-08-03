#include <iostream>
#include<cstdlib>
#include<ctime>

using namespace std;

int fibonacci_sum_naive(long long n) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;
    long long sum      = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current;
    }

    return sum % 10;
}

unsigned long long fibonacci_sum_fast(long long n)
{
	long long x=n+2;
	
	unsigned long long ans;
	
    if (n <= 1)
        return n;

    else
    {
    	unsigned long long a[x];
    	
    	a[0]=0;
    	a[1]=1;
    	
    	for(long long i=2;i<x;i++)
    	a[i]= (a[i-1])%10+(a[i-2])%10;
    	
    	ans = a[x-1]%10-1;
		
		return ans; 
    }
}

int main() {
	
	long long n;
	
	srand((unsigned)time(0));
    
    while(true)
    {
    	n=10000 + rand() % (( 100000 + 1 ) - 10000);
    	
    	cout<<"last digit of sum of "<<n<<" number in the fibonacci series is"<<endl;
    	
    	cout<<fibonacci_sum_naive(n)<<" "<<fibonacci_sum_fast(n)<<endl;
    	
    	if(fibonacci_sum_naive(n)!= fibonacci_sum_fast(n))
    	{
    		cout<<endl<<"wrong!"<<endl;
    		break;
    	}
    }
	
   /* long long n = 0;
    std::cin >> n;
    std::cout << fibonacci_sum_fast(n);*/
}
