import java.util.Scanner;

interface human
{
  void setname();
  void setage();
}

interface student
{
  void setroll();
  void setbdate();
}

interface engineeringStudent extends human,student
{
  void setbranch();
  void displaydetails();
}

class x implements engineeringStudent
{
  Scanner scan = new Scanner(System.in);
  int roll,age;
  String name,bdate,branch;

  public void setname()
  {
    System.out.println("enter the name :");
    this.name = scan.nextLine();
  }

  public void setage()
  {
    System.out.println("enter the age :");
    this.age = scan.nextInt();
  }

  public void setroll()
  {
    System.out.println("enter the rollno :");
    this.roll = scan.nextInt();
  }

  public void setbdate()
  {
    System.out.println("enter the birth date :");
    this.bdate = scan.next();
  }

  public void setbranch()
  {
    System.out.println("enter the branch :");
    this.branch = scan.next();
  }

  public void displaydetails()
  {
    System.out.println("name :"+this.name);
    System.out.println("age :"+this.age);
    System.out.println("rollno :"+this.roll);
    System.out.println("birth date :"+this.bdate);
    System.out.println("branch :"+this.branch);
  }
}

class multipleinheritance {
  public static void main(String[] args) 
  {
    x x1 = new x();
    x1.setname();
    x1.setage();
    x1.setroll();
    x1.setbdate();
    x1.setbranch();

    x1.displaydetails();
  }
}