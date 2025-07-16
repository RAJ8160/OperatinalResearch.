import java.util.Scanner;

public class Programme2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of row :");
        int r1 = sc.nextInt();
        System.out.println("Enter Number of Column :");
        int c1 = sc.nextInt();

        int[][] arr1 = new int[r1][c1];

        for(int i = 0;i<r1;i++){
            for(int j = 0;j<c1;j++){
                System.out.println("Enter Element arr1["+i+"]["+j+"]:");
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Number of row :");
        int r2 = sc.nextInt();
        System.out.println("Enter Number of Column :");
        int c2 = sc.nextInt();

        int[][] arr2 = new int[r2][c2];

        for(int i = 0;i<r2;i++){
            for(int j = 0;j<c2;j++){
                System.out.println("Enter Element arr2["+i+"]["+j+"]:");
                arr2[i][j] = sc.nextInt();
            }
        }

        if(r1!=r2 && c1!=c2){
            System.out.println("You not performe addtion between them");
        }else{
            for(int i = 0;i<r1;i++){
            for(int j=0;j<c1;j++){
                arr1[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("Answer matrix is :");
        for(int i = 0;i<r1;i++){
            for(int j=0;j<c1;j++){
                System.out.println("Element of answer is arr["+i+"]["+j+"]:"+arr1[i][j]);
            }
        }

        }
        
        

    }
}