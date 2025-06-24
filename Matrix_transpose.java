import java.util.Scanner;

public class Matrix_transpose{
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

        int[][] arr2 = new int[c1][r1];

        for(int i = 0;i<c1;i++){
            for(int j = 0;j<r1;j++){
                arr2[i][j] =arr1[j][i];
            }
        }

        System.out.println("Answer matrix is :");
        for(int i = 0;i<c1;i++){
            for(int j=0;j<r1;j++){
                System.out.println("Element of answer is arr["+i+"]["+j+"]:"+arr2[i][j]);
            }
        }

        }
        
        

    }