class Mergetwosortedarrays 
{
  public static void main(String[] args) 
  {
    int[] nums1 = {1,2,3,0,0,0};
    
    int m = 3;
    int[] nums2 = {2,5,6};
    int n = 3;

    int[] nums3 = new int[m+n];

    int i=0,j=0,pointer=0;

    while(j<n && i<m)
    {
      if(nums1[i]<=nums2[j])
      {
        System.out.println("here i is "+i+" and j is "+j+" and element "+nums1[i]+" <= "+nums2[j]);
        nums3[pointer] = nums1[i];
        i++;
        System.out.println("and now i is "+i);
      }
      else
      {
        System.out.println("here i is "+i+" and j is "+j+" and element "+nums1[i]+" >= "+nums2[j]);
        nums3[pointer] = nums2[j];
        j++;
        System.out.println("and now j is "+j);
      }
      pointer++;
      System.out.println("And now pointer value is "+pointer);
    }

    if(j<n)
    {
      System.out.println("here pointer value is "+pointer+" and j is "+j);
      while(j<n)
      {
        nums3[pointer] = nums2[j];
        j++;
        pointer++;
        System.out.println("And now pointer value is "+pointer);
      }
    }

    if(i<m)
    {
      System.out.println("here pointer value is "+pointer+" and i is "+i);
      while(i<m)
      {
        nums3[pointer] = nums1[i];
        i++;
        pointer++;
        System.out.println("And now pointer value is "+pointer);
      }
    }

    System.out.println("here is the array");

    for(int k=0;k<m+n;k++)
    {
      System.out.print(nums3[k]+" ");
    }

  }
}