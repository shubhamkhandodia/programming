class SinglyLinkedList 
{    
    //Represent a node of the singly linked list    
    class Node
    {    
        int data;    
        Node next;    
            
        public Node(int data) 
        {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    //Represent the head and tail of the singly linked list    
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    public void addNode(int data) {    
        //Create a new node    
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
        
    //display() will display all the nodes present in the list    
    public void display() 
    {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }

    public SinglyLinkedList add(SinglyLinkedList l1,SinglyLinkedList l2)
    {
      Node i1 = l1.head , i2 = l2.head;

      String x1="",x2="";
        
        while(i1!=null)
        {
            x1+=i1.data;
            i1 = i1.next;
        }

        System.out.println("here is x1 :"+x1);
        
        while(i2!=null)
        {
            x2+=i2.data;
            i2 = i2.next;
        }

        System.out.println("here is x2 :"+x2);
        
        StringBuffer y1 = new StringBuffer(x1);
        StringBuffer y2 = new StringBuffer(x2);
        y1.reverse();y2.reverse();
        
        x1 = y1.toString(); x2 = y2.toString();

        System.out.println("here are new x1 and x2 :"+x1+" "+x2);
        
        int a1 = Integer.valueOf(x1) , a2 = Integer.valueOf(x2);

        System.out.println("here are new a1 and a2 :"+a1+" "+a2);
        
        int sum = a1+a2;

        System.out.println("here's the sum :"+sum);
        
        String sumstring = String.valueOf(sum);

        System.out.println("here is the sumstring :"+sumstring);

        StringBuffer sumrev = new StringBuffer(sumstring);

        sumrev.reverse();

        sumstring = sumrev.toString();

        System.out.println("here's the reversed sumstring :"+sumstring);

        i1 = l1.head;

        if(x1.length()==sumstring.length())
        {
            for(int i=0;i<sumstring.length();i++)
            {
              i1.val = Integer.valueOf(Character.toString(sumstring.charAt(i)));
              i1 = i1.next;
            }
            
            return l1;
        }
        
        else
        {
            ListNode j1 = new ListNode(Integer.valueOf(Character.toString(sumstring.charAt(0))));
            
            ListNode root = j1,current = j1;
            
            for(int k=1;k<sumstring.length();k++)
            {
                ListNode z = new ListNode(Integer.valueOf(Character.toString(sumstring.charAt(k))));
                
                if(current.next == null)
                {
                    current.next = z;
                }
                
                current = current.next;
            }
            
            return root;
        }
    }
        
        
}


class addTwoNumbers
{
  public static void main(String[] args) 
  {    
            
      SinglyLinkedList sList = new SinglyLinkedList();    
            
        //Add nodes to the list    
        sList.addNode(2);
        sList.addNode(4);    
        sList.addNode(3);    
        

      SinglyLinkedList  l2 = new SinglyLinkedList();

      l2.addNode(5);
      l2.addNode(6);
      l2.addNode(4); 
            
        //Displays the nodes present in the list    
      sList.display();

      SinglyLinkedList l3 = sList.add(sList,l2);

      System.out.println("sjsnfjsnjks");

      l3.display();   
  }
}