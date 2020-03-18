#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <vector>

using namespace std;

class Node
{
  public:

  int val;
  vector< int > children;

    Node( int v )
    {
      this->val=v;
    }


    Node( const Node &n )
    {
      this->val = n.val;
      this->children = n.children;
    }

    void add_child( int v )
     { 
       children.push_back( v ); 
      }


    int size() const { return children.size(); }

};


class TreeHeight
{
    int n;

    vector< int > parent;

    map< int, Node * > ns;

    Node *node;

  public:

    ~TreeHeight()

    {
      for ( const auto &n : ns )
      {
        delete n.second;
      }

    }

    void read()
    {

      cin >> n;

      parent.resize( n );

      for ( int i = 0; i < n; i++ )
        cin >> parent[ i ];
    }


    int compute_height()

    {
      construct_tree();
      return max_depth( node );
    }

  private:

    int max_depth( Node *n )

    {
      if ( n == nullptr )
        return 0;

      if ( n->size() == 0 )

        return 1;

      int m = 0;

      for ( int i = 0; i < n->size(); ++i )
      {
        int d = max_depth( ns[ n->children[ i ] ] );

        if ( d > m )
          m = d;
      }

      return m + 1;
    }



    void construct_tree()
    {

      for ( int i = 0; i < n; ++i )
      {
        ns[ i ] = new Node( i );
      }

      for ( int i = 0; i < n; ++i )
      {
        int p = parent[ i ];

        if ( p != -1 )
        {
          ns[ p ]->add_child( i );
        }
        else
        {
          node = ns[ i ];
        }

      }
    }

};



int main()

{

  ios_base::sync_with_stdio( 0 );

  TreeHeight tree;

  tree.read();

  cout << tree.compute_height() << endl;



  return 0;

}
