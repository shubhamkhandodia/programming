import java.lang.*;
import java.util.*;

class Mathematics
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		while(t-->0)
		{
			GP obj = new GP();
			int a,b;

			a = scan.nextInt();
			b = scan.nextInt();

			int n;

			n = scan.nextInt();

			System.out.println(Math.floor(obj.termOfGP(a,b,n)));
		}
	}
}

class GP 
{
    
    public double termOfGP(int A,int B,int N)
    {
        double r = B/A;
    
        if(N<=2)
        {
            if(N==1)
            return (double)A;
            
            if(N==2)
            return (double)B;
        }
        
        double nthterm = A*(Math.pow(r,N-1));
        
        return Math.floor(nthterm);
    }

}