#include <iostream>
#include<cstdlib>
#include<ctime>
#include <stdint.h>

using namespace std;

int fibonacci_sum_squares_naive(long long n) 
{
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;
    long long sum      = 1;

    for (long long i = 0; i < n - 1; ++i) 
	{
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current * current;
    }

    return sum % 10;
}

 unsigned long long fibonacci_sum_squares_fast(long long n)
{
	unsigned long long sum=0;
	int j=0;
	
    if (n <= 1)
        return n;

    else
    {
    	long long a[n+1];
    	
    	a[0]=0;
    	a[1]=1;
    	a[2]=1;
    	
    	for(long long i=3;i<=n;i++)
    	{
    		a[i]=(a[i-1]+a[i-2]);
    	}
    	
    	while(j<= n)
    	{
    		sum = sum +(a[j]*a[j])%10;
    		j++;
    	}
    	
    	return sum%10;
    	
    }
}

int main() {
	
/*	long long n;
	
	srand((unsigned)time(0));
    
    while(true)
    {
    	n=rand()%10000+1;
    	
    	cout<<"last digit of sum of "<<n<<" number in the fibonacci series is"<<endl;
    	
    	cout<<fibonacci_sum_squares_naive(n)<<" "<<fibonacci_sum_squares_fast(n)<<endl;
    	
    	if(fibonacci_sum_squares_naive(n)!= fibonacci_sum_squares_fast(n))
    	{
    		cout<<endl<<"wrong!"<<endl;
    		break;
    	}
    }*/
    
    
    long long n = 0;
    std::cin >> n;
    std::cout << fibonacci_sum_squares_naive(n);
}
