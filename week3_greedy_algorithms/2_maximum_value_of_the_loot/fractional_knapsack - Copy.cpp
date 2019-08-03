#include <iostream>
#include <vector>
#include<algorithm>
typedef std::numeric_limits< double > dbl;

using namespace std;

using std::vector;

int curWeight=0;

double get_optimal_value(int capacity, vector<int> weights, vector<int> values) 
{ 
	double value = 0.0; 
	
	return value;
	
}

int main() {
  int n;
  int capacity;
  std::cin >> n >> capacity;
  vector<int> values(n);
  vector<int> weights(n);
  for (int i = 0; i < n; i++) 
  {
    std::cin >> values[i] >> weights[i];
  }

  double optimal_value = get_optimal_value(capacity, weights, values);

  	cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(15);

  cout <<endl<< optimal_value << endl;
  return 0;
}
