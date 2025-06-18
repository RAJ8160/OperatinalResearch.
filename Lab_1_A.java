import java.util.*;

public class Lab_1_A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = 0,y = 0,Z = 0,temp =Integer.MIN_VALUE;
        for(int i=0;i<=4;i++){
            for(int j=0;j<=4;j++){
                
                if(i+j<=4){
                    Z =(3*i)+(2*j);
                    if(Z>temp){
                        x = i;
                        y = j;
                        temp = Z;
                    }
                }
            }
        }
        System.out.println("Matimum value "+x+" and "+y+" of Z is : "+temp);
        
    }
}