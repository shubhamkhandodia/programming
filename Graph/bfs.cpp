#include <iostream>
#include<queue>
#include <list>

using namespace std;

struct graph
{
  int v;
  list<int> *adj;
  graph()
  {
    cout<<"enter the number of edges in the graph"<<endl;
    cin>>this->v;
    adj = new list<int>[v];
  }

  void addedge(int u,int v);
  void bfs(int source);
  
};

void graph::addedge(int u, int v)
{
  adj[u].push_back(v);
}

void graph::bfs(int source)
{
  bool *visited = new bool[v];  //boolean array for vertices which are visited

  for(int i=0;i<v;i++)
  visited[i]= false;
  
  list<int>queue;				//list as a queue for inserting the nodes which are traversed
  
  visited[source] = true;			//as source vertex is visited first let's mark it true
  
  queue.push_back(source); 
  
  list<int>::iterator i; 		// 'i' will be used to get all adjacent vertices of a vertex
  
  while(!queue.empty())
  {
  	// Dequeue a vertex from queue and print it
  	source=queue.front();			
  	cout<<source;
  	queue.pop_front();
  	
  	for (int i=adj[source].begin(); i!= adj[source].end(); ++i) 
        { 
            if (!visited[*i]) 
            { 
                visited[*i] = true; 
                queue.push_back(*i);
            }
        } 
  }
  
}

int main() 
{
  Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
  
    cout << "Following is Breadth First Traversal "<< "(starting from vertex 2) "<<endl;
    g.BFS(2); 
  
    return 0; 
}
