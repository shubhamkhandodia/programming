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
	
	int i,j,lastindex,indexes[lastindex],filled=0;
	
	lastindex = distance(weights.begin(),weights.end());
	
	
	vector<double>valueperweight(lastindex);
	vector<double>valueperweightsorted(lastindex);	
	
	for(i=0;i<lastindex;i++)
	{
		valueperweight[i]=(double)values[i]/(double)weights[i];
		valueperweightsorted[i]=(double)values[i]/(double)weights[i];		
	}
	
	cout.precision(dbl::max_digits10);
	
	sort(valueperweightsorted.begin(),valueperweightsorted.end(),greater<double>());
	
	i=0;
	j=0;
	
	while(i<lastindex && j<lastindex)
	{
		vector<double>::iterator it = std::find(valueperweight.begin(), valueperweight.end(),valueperweightsorted[j]);
		
		indexes[i] = distance(valueperweight.begin(),it);
		
		j++;
		i++;
	}
	
	for (int i = 0; i < lastindex; i++) 
    { 
        // If adding Item won't overflow, add it completely 
        if (curWeight + weights[indexes[i]] <= capacity) 
        { 
            curWeight += weights[indexes[i]]; 
            value += values[indexes[i]];
        } 
  
        // If we can't add current Item, add fractional part of it 
        else
        { 
            int remain = capacity - curWeight; 
            value += values[indexes[i]] * ((double) remain / weights[indexes[i]]); 
            break; 
        }
    } 
	
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
