#include <iostream>
#include <vector>

using namespace std;

using std::cin;
using std::cout;
using std::vector;

int compute_min_refills(int dist, int tank, vector<int> stops) 
{
	int currentposition
}


int main() {
    int d = 0;
    cin >> d;
    int m = 0;
    cin >> m;
    int n = 0;
    cin >> n;

    vector<int> stops(n);
    for (size_t i = 0; i < n; ++i)
        cin >> stops.at(i);

    cout << compute_min_refills(d, m, stops)  << "\n";

    return 0;
}


