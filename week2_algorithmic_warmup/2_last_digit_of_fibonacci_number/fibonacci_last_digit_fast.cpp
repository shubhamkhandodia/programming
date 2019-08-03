#include <iostream>

unsigned long long get_fibonacci_last_digit_fast(int n) {
    if (n <= 1)
        return n;

    else
    {
    	unsigned long long a[n+1];
    	
    	a[0]=0;
    	a[1]=1;
    	a[2]=1;
    	
    	for(int i=3;i<=n;i++)
    	{
    		a[i]=(a[i-1])%10+(a[i-2])%10;
    	}
    	
    	return a[n]%10;
    }
}

int main() {
    int n;
    std::cin >> n;
    long long c = get_fibonacci_last_digit_fast(n);
    std::cout << c << '\n';
    }
