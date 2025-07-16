import java.util.*;
// import Arrays class to use inbuilt sum() method
import java.io.*;
public class North_East{
   public static void main(String[] args){

    int[] s = {500,300,200};
      int[] d = {180,150,350,320};
      
      int TotalSupply = Arrays.stream(s).sum();
      int TotalDemand = Arrays.stream(d).sum();

      if(TotalSupply != TotalDemand){
         System.out.println("Your Supply Demand is Not Equal");
         return;
      }

      System.out.println(TotalSupply);
      int[][] Fac_Cost = {{12,10,12,13},{7,11,8,14},{6,16,11,7}};
      
    /*  If You want to add Dynamic Data Use This
      int slength = 0;
      int dlength = 0;
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter length for Supply Array :");
      slength = sc.nextInt();
      System.out.println("Enter length for Demand Array :");
      dlength = sc.nextInt();
      int [] s = new int[slength];
      int [] d = new int[dlength];

      for(int i =0;i<slength;i++){
        System.out.println("Enter element for Supply Array :");
         s[i] = sc.nextInt();
      }
      for(int i =0;i<dlength;i++){
        System.out.println("Enter element for Demand Array :");
         d[i] = sc.nextInt();
      }

      int r =0,c =0;
      System.out.println("Enter Number of row for Factury cost Array :");
      r = sc.nextInt();
      System.out.println("Enter Number of column for Factury cost Array :");
      c = sc.nextInt();
      int[][] Fac_Cost = new int [r][c];

      for(int i =0;i<r;i++){
        for(int j=0;j<c;j++){
            System.out.println("Enter element for facutry cost ");
            Fac_Cost[i][j] = sc.nextInt();
        }
      }
      */
      int i =0,j =0,mult = 0;
      while(i<s.length && j<d.length){
           int  m = Math.min(s[i],d[j]);
            mult +=Fac_Cost[i][j]*m;
            if(s[i]-m == 0){
                i++;
            }else{
                s[i]-=m;
            }
            if(d[j]-m == 0){
                j++;
            }else{
                d[j]-=m;
            }
      }
      System.out.println("Total Cost is :"+mult);
   }
}