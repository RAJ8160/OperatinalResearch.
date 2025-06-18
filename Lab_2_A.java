import java.util.*;
public class Lab_2_A{
    public static void main(String[] args){
        int t1 = 10,t2 = 20,t3 = 30;
        int sum =0, sum1 =0 ;
        int[] arr1 = new int[8];
        int ind1 = 0,ind2 = 0;
        for(int i =0;i<2;i++){
            for(int j = 0;j<2;j++){
                for(int k =0;k<2;k++){
                    sum = (t1*i)+(t2*j)+(t3*k);
                    sum1 = 60 - sum;
                    // System.out.println(sum+" "+sum1);
                    if(ind1<arr1.length){
                        arr1[ind1] = Math.max(sum,sum1);
                        ind1++;
                    }
                }
            }
        }
        // for(int i=0;i<arr1.length;i++){
        //      System.out.println(arr1[i]);
        // }
        int a = Arrays.stream(arr1).min().getAsInt();
        System.out.println("minimum time is :"+a);
        
    }
}