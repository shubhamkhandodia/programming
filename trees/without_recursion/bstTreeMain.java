import java.io.*; 
import java.util.*;
class node
{
  node left;
  node right;
  int value;
  node(int value)
  {
    this.value = value;
    this.right = null;
    this.left = null;
  }
}

class tree
{
  public static node root;
  tree()
  {
    root = null;
  } 
   public void add(int data)
   {
     node newnode = new node(data);
     node currentnode = root;
     node parentnode = null;

     if(root==null)
     {
        root = newnode;
        return;
		 }

     while(true)
     {
       parentnode = currentnode;
       if(data>currentnode.value)
       {
         currentnode = currentnode.right;
         if(currentnode==null)
         {
            parentnode.right = newnode;
            return;
         }
          
       }

       else
       {
         currentnode = currentnode.left;
         if(currentnode==null)
         {
            parentnode.left = newnode;
            return;
         }
       }
     }
   }

   public boolean find(int id)
   {
     boolean found = false;
     node current = root;
     while(current!=null)
     {
       if(id==current.value)
       {
         found = true;
         break;
       }
       else if(id>current.value)
       current = current.right;
       else
       current = current.left;
     }

     return found;
   }

   void delete(int id)
   {
     if(root == null)
     {
       System.out.println("tree is empty");
       return;
     }

     else if(!find(id))
     {
       System.out.println("Node is not present in the tree");
       return;
     }

     else
     {
       node current = root;
       node parent = root;
        while(current!=null)
        {
          if(id==current.value)
            break;
          else if(id>current.value)
          {
            parent = current;
            current = current.right;
          }
          
          else
          {
            parent = current;
            current = current.left;
          }
          
        }

        if(current.left==null && current.right==null)
        {
          current = null;
        }

        else if(current.left==null || current.right==null)
        {
          node child;
          if(current.left!=null)
          {
            child = current.left;

            if(current.value>parent.value)
            {
              parent.right = child;
              current = null;
            }
            else
            {
              parent.left = child;
              current = null;
            }
          }
          else
          {
            child = current.right;
            parent.right = child;
            current=null;
          }
        }

        else
        {
          node child1,parent1;
          parent1 = current;
          child1 = current.left;
          while(child1.right!=null)
          {
            parent1 = child1;
            child1 = child1.right;
          }
          current.value = child1.value;
          if(child1.left!=null)
          {
            parent1.right = child1.left;
          }
          else
          parent1.right = null;
          child1 = null;
        }
     }
   }

  void preorder()
   {
     if(root == null)
     {
       return;
     }
     else
     {
       node current = root;
       Stack<node> prestack = new Stack<node>();
       prestack.push(current);
       while(!prestack.empty())
       {
         current = prestack.pop();

         System.out.print(current.value+" ");

         if(current.right!=null)
         prestack.push(current.right);

         if(current.left!=null)
         prestack.push(current.left);
       }
     }
      
   }

   void inorder()
   {
     if(root == null)
     {
       return;
     }
     else
     {
        Stack<node> nodestack = new Stack<node>(); 
        node current = root;
 
        while (current != null || nodestack.size() > 0) 
        {
            while (current !=  null) 
            {
                nodestack.push(current);
                current = current.left;
            } 
  
            // Current becomes NULL at this point
            current = nodestack.pop(); 
  
            System.out.print(current.value + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            current = current.right; 
        }
     }
      
   }

   void postorder()
   {
     if(root == null)
     {
       return;
     }
     else
     {
       node current = root;
       Stack<node> poststack = new Stack<node>();
       poststack.push(current);
       while(!poststack.empty())
       {
         current = poststack.pop();

         System.out.print(current.value+" ");

         if(current.left!=null)
         poststack.push(current.left);

         if(current.right!=null)
         poststack.push(current.right);
       }
     }
      
   }
}

 class Main {
  public static void main(String[] args) 
  {
    tree t1 = new tree();
    t1.add(40);
    t1.add(6);
    t1.add(30);
    t1.add(24);
    t1.add(80);
    t1.add(25);
    t1.add(37);
    
    if(t1.find(6))
     {
       System.out.println("found the node!");
     }
    else
     System.out.println("node is not present !");
    
    t1.inorder();
    System.out.println();
    t1.preorder();
    System.out.println();
    t1.postorder();
    System.out.println();
    t1.delete(60);
    t1.delete(40);
    t1.inorder();
  }
}