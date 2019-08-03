#include <iostream>
#include <vector>
using std::vector;
#include<cstdlib>
#include<ctime>

using namespace std;

long long fibonacci_partial_sum_naive(long long from, long long to) {
    long long sum = 0;

    long long current = 0;
    long long next  = 1;

    for (long long i = 0; i <= to; ++i) {
        if (i >= from) {
            sum += current;
        }

        long long new_current = next;
        next = next + current;
        current = new_current;
    }

    return sum %10;
}


long long fibonacci_partial_sum_fast(long long from,long long to)
{
	long long sum=0;

    	long long a[to+1];
    	
    	a[0]=0;
    	a[1]=1;
    	a[2]=1;
    	
    	for(long long i=3;i<=to;i++)
    	{
    		a[i]=a[i-1]+a[i-2];
    	}
    	
    	while(from<=to)
    	{
    		sum = sum+=a[from];
    		from++;
    	}
    	
    	return sum%10 ;
    	
}

int main() {
	
/*	long long from,to;
	
	srand((unsigned)time(0));
    
    while(true)
    {
    	from=rand()%10000+1;
    	to=rand()%10000+1;
    	
    	cout<<"last digit of sum till "<<to<<"th number in the fibonacci series is"<<endl;
    	
    	cout<<fibonacci_partial_sum_naive(from,to)<<" "<<fibonacci_partial_sum_fast(from,to)<<endl;
    	
    	if(fibonacci_partial_sum_naive(from,to)!= fibonacci_partial_sum_fast(from,to))
    	{
    		cout<<endl<<"wrong!"<<endl;
    		break;
    	}
    }*/
    long long from, to;
    std::cin >> from >> to;
    std::cout << fibonacci_partial_sum_naive(from, to) ;
    
    return 0;
}
