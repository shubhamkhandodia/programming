import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    public void shiftdown(int i)
    {
      int minindex = i;

      int leftchildindex = 2*i+1,rightchildindex = 2*i+2;

      if(leftchildindex<data.length && data[leftchildindex]<data[minindex])
      minindex = leftchildindex;

      if(rightchildindex<data.length && data[rightchildindex]<data[minindex])
      minindex = rightchildindex;

      if(i!=minindex)
      {
          
          swaps.add(new Swap(i,minindex));
          int temp = data[i];
          data[i]=data[minindex];
          data[minindex]=temp;
          shiftdown(minindex);
      }
    }

    private void generateSwaps() 
    {
      swaps = new ArrayList<Swap>();
      
      int size = data.length;

      for(int i=size/2-1;i>=0;i--)
      {
        shiftdown(i);
      }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}