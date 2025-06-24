import java.util.Scanner;
public class Pattern3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enetr number of row :");
        int r = sc.nextInt();
        for(int i=0;i<r*2;i++){
            int temp=1,temp1=r;

            for(int j=0;j<temp1;j++){
                System.out.print(" ");
            }
            for(int j=r-i;j<temp;j++){
                System.out.print("@");
            }
            System.out.println();

            if(temp>=r){
                temp--;
                temp1--;
            }
            else{
                temp++;
                temp1++;
            }
        }
    }
}