import java.util.*;
import java.io.*;
import java.lang.*;

class AVLTree
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

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		int bf = bf(node);

		// LL Case
		if (bf > 1 && item < node.left.data) 
    	{
			return rightRotate(node);
		}

		// RR Case
		if (bf < -1 && item > node.right.data) 
    	{
			return leftRotate(node);
		}

		// LR Case
		if (bf > 1 && item > node.left.data) 
    	{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RL Case
		if (bf < -1 && item < node.right.data) 
    	{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;

	}

	private int height(Node node) 
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

	private int bf(Node node) 
  	{
		if (node == null) 
    	{
			return 0;
		}

		return height(node.left) - height(node.right);
	}

	private Node rightRotate(Node c) 
  	{

		Node b = c.left;
		Node T3 = b.right;

		// rotate
		b.right = c;
		c.left = T3;

		// ht update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	private Node leftRotate(Node c) 
  	{

		Node b = c.right;
		Node T2 = b.left;

		// rotate
		b.left = c;
		c.right = T2;

		// ht update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	public void inorderdisplay() 
  	{
		inorder(this.root);
	}

	private void inorder(Node node) 
  	{

		if (node == null) 
    	{
			return;
		}

		inorder(node.left);
    	System.out.print(node.data+" ");
    	inorder(node.right);

	}

}

class avlMain 
{
  public static void main(String[] args) 
  {
    AVLTree tree = new AVLTree();
		tree.insert(20);
		tree.insert(25);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);
		tree.inorderdisplay();
  }
}