import java.util.*;
import java.io.*;
import java.lang.*;

class bst
{
	private class Node 
  {

		int data;
		Node left;
		Node right;

		public Node(int data) 
    {
			this.data = data;
		}
	}

	private Node root;

	public void insert(int item) 
  {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) 
  {

		if (node == null) 
    {
			Node nn = new Node(item);
			return nn;
		}

		if (item > node.data) 
    {
			node.right = insert(node.right, item);
		} 
    else if (item < node.data) 
    {
			node.left = insert(node.left, item);
		}
		return node;
	}

	private int height(Node node)   //function to compute height of the node
  {
		if (node == null) 
    {
			return 0;
		}

		else
   {
     int leftsubtreeheight = height(node.left);
     int rightsubtreeheight = height(node.right);
  
     if (leftsubtreeheight > rightsubtreeheight)
         return(leftsubtreeheight+1);
     else
        return(rightsubtreeheight+1);
   }
	}

	private int bf(Node node)       //function to compute balance factor of the node
  {
		if (node == null) 
    {
			return 0;
		}

		return height(node.left) - height(node.right);
	}

  public void printfunction()
  {
    printLevelOrder(this.root);
  }

  void printLevelOrder(Node node)
  {
      int h = height(node);
      
      for(int i=1; i<=h; i++)
      {
        System.out.println("the current level is "+i);
        printLevel(node, i);
        System.out.println();
      }
          
  }
  
/* Print nodes at a given level */
  void printLevel(Node currentnode, int level)
  {
      if(currentnode == null)
          return;
      if(level == 1)
          System.out.print(currentnode.data+" , ");
      else if (level > 1)
      {
          printLevel(currentnode.left, level-1);
          printLevel(currentnode.right, level-1);
      }
  }


}

class Main 
{
  public static void main(String[] args) 
  {
    bst tree = new bst();
		tree.insert(20);
		tree.insert(25);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);
		
    tree.printfunction();
  }
}