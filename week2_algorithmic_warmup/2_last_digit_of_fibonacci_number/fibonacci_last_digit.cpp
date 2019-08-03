#include <iostream>
#include<cstdlib>
#include<ctime>
using namespace std;

int get_fibonacci_last_digit_naive(int n) {
    if (n <= 1)
        return n;

    int previous = 0;
    int current  = 1;

    for (int i = 0; i < n - 1; ++i) {
        int tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
    }

    return current % 10;
}


long long get_fibonacci_last_digit_fast(int n) 
{
    if (n <= 1)
        return n;

    else
    {
    	int a[n+1];
    	
    	a[0]=0;
    	a[1]=1;
    	a[2]=1;
    	
    	for(int i=3;i<=n;i++)
    	{
    		a[i]=a[i-1]+a[i-2];
    	}
    	
    	return a[n]%10;
    }
}

int main() {
	
    int n;
    
    /*srand((unsigned)time(0));
    
    while(true)
    {
    	n=rand()%10000+1;
    	
    	cout<<"last digit of "<<n<<"th number in the fibonacci series is"<<endl;
    	
    	cout<<get_fibonacci_last_digit_naive(n)<<" "<<get_fibonacci_last_digit_fast(n)<<endl;
    	
    	if(get_fibonacci_last_digit_naive(n)!= get_fibonacci_last_digit_fast(n))
    	{
    		cout<<endl<<"wrong!"<<endl;
    		break;
    	}
    }*/
    
    
    cin >> n;
    int c = get_fibonacci_last_digit_fast(n);
    std::cout << c << '\n';
    }
