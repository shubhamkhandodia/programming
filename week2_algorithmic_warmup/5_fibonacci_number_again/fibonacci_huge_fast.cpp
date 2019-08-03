#include <iostream>
#include<cstdlib>
#include<ctime>

using namespace std;

long long get_fibonacci_huge_naive(long long n, long long m) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
    }

    return current % m;
}

long long get_fibonacci_huge_fast(long long n,long long m)
{
    if (n <= 1)
        return n;

    else
    {
    	long long a[n+1];
    	
    	a[0]=0;
    	a[1]=1;
    	a[2]=1;
    	
    	for(int i=3;i<=n;i++)
    	{
    		a[i]=a[i-1]+a[i-2];
    	}
    	
    	return a[n]%m;
    }
}

int main() {
	
	long long n,m;
	
/*	srand((unsigned)time(0));
    
    while(true)
    {
    	n=900 + rand() % (( 1100 + 1 ) - 900);
    	m=900 + rand() % (( 1100 + 1 ) - 900);
    	
    	cout<<"last digit of "<<n<<"th number in the fibonacci series is"<<endl;
    	
    	cout<<get_fibonacci_huge_naive(n,m)<<" "<<get_fibonacci_huge_fast(n,m)<<endl;
    	
    	if(get_fibonacci_huge_naive(n,m)!= get_fibonacci_huge_fast(n,m))
    	{
    		cout<<endl<<"wrong!"<<endl;
    		break;
    	}
    }*/
    std::cin >> n >> m;
    
    std::cout << "fast solution "<<get_fibonacci_huge_fast(n, m)<< '\n';
    cout<<"naive solution "<<get_fibonacci_huge_naive(n,m);
}
