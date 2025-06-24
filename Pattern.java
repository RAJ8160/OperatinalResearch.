import java.util.Scanner;
public class Pattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enetr number of row :");
        int r = sc.nextInt();
        for(int i=0;i<r;i++){
            for(int j=0;j<r-i;j++){
                System.out.print(" ");
            }
            for(int j=r-i;j<=r;j++){
                System.out.print("@");
            }
            System.out.println();
        }
    }
}