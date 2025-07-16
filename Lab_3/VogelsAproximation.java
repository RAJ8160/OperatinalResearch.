import java.util.*;

class VogelsAproximation{

     private static void deleteRow(int row,boolean[][] b,int r){
        for(int i = 0;i<r;i++){
            b[row][i] = true;
        }
    }

    private static void deleteColumn(int column,boolean[][] b,int c){
        for(int i = 0;i<c;i++){
            b[i][column] = true;
        }
    }

public static int[] findRowPenalty(int[][] f,boolean[][] b){
    int[] row = new int[f.length];
    int least ,secondLeast ;
    for(int i=0;i<f.length;i++){
        least = Integer.MAX_VALUE;
        secondLeast =Integer.MAX_VALUE;
        for(int j = 0;j<f[0].length;j++){
            if(!b[i][j]){
                  if(least>f[i][j] ){
                secondLeast = least;
                least = f[i][j];
            }
            else if(secondLeast>f[i][j] ){
                secondLeast = f[i][j];
            }
            }

            
          
        }
            row[i] = secondLeast - least;
        
    }
    return row;
}

    
 
public static int[] findColumnPenalty(int[][] f, boolean[][] b) {
    int[] column = new int[f[0].length];
    int least = Integer.MAX_VALUE, secondLeast = Integer.MAX_VALUE;

    for (int i = 0; i < f[0].length; i++) {
        least = Integer.MAX_VALUE;
        secondLeast = Integer.MAX_VALUE;

        for (int j = 0; j < f.length; j++) {
            if (!b[j][i]) {
                if (f[j][i] < least) {
                    secondLeast = least;
                    least = f[j][i];
                } else if (f[j][i] < secondLeast) {
                    secondLeast = f[j][i];
                }
            }
        }

            column[i] = secondLeast - least;
        
    }

    return column;
}


    public static int findRow(int[][] f,boolean[][] b,int[] r,int rm){
        
        for(int i=0 ;i<r.length;i++){
             if(r[i] == rm){
                return i;
             }
        }
        return -1;
    }
    public static int findColumn(int[][] f,boolean[][] b,int[] c,int cm){
       
        for(int i=0 ;i<c.length;i++){
             if(c[i] == cm){
               return i;
             }
        }
         return -1;
    }
    public static int[] findSmallestInRow(int[][] f,boolean[][] b,int r){
         int[] idxr = new int[3];
         idxr[0] = Integer.MAX_VALUE;
         idxr[1] = r;
         idxr[2] = -1;
        for(int i=0;i<f[0].length;i++){
            if(!b[r][i] && f[r][i]<idxr[0]){
                idxr[0] = f[r][i];
                idxr[2] = i;
            }
        }
        return idxr;
    }
    public static int[] findSmallestInColumn(int[][] f,boolean[][] b,int c){
        int[] idxc = new int[3];
         idxc[0] = Integer.MAX_VALUE;
         idxc[2] = c;
         idxc[1] = -1;
        for(int i=0;i<f.length;i++){
            if(!b[i][c] && f[i][c]<idxc[0]){
                idxc[0] = f[i][c];
                idxc[1] = i;
            }
        }
        return idxc;
    }
    public static void printArr(boolean[][] b){
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int[][] f ={{12,10,12,13},{7,11,8,14},{6,16,11,7}};
        // int[] s ={500,300,200};
        // int[] d ={180,150,350,320};
        int[][] f = {{19,30,50,10},{40,30,40,60},{40,8,70,20}};
        int[] s ={7,9,18};
        int[] d ={5,8,7,14};
        
        int  r_length = f.length;
        int  c_length = f[0].length;
        boolean[][] b = new boolean[3][4];
       
       
       
        // System.out.println("Row panelty is :");
        // for(int i =0;i<r.length;i++){
        //     System.out.println(r[i]);
        // }
        // System.out.println("Column panelty is :");
        // for(int i =0;i<c.length;i++){
        //     System.out.println(c[i]);
        // }
      
    //    System.out.println("Maximum Element in Row us :"+maxr);
    //    System.out.println("Maximum Element in Column us :"+maxc);
    //    System.out.println("Index of max Element in Row is :"+r1);
    //    System.out.println("Index of max Element in Column is :"+c1);
    //    System.out.println("Smallest Element in Row is :"+mr);
    //    System.out.println("Smallest Element in Column is :"+mc);

       int totalSupply = Arrays.stream(s).sum();
        int totalDemand = Arrays.stream(d).sum();
        List<Integer> l = new ArrayList<>();
        // totalDemand!=0 && totalSupply!=0
        int temp = 0;
        // temp<3
         while(totalDemand!=0 && totalSupply!=0){
             int[] r = findRowPenalty(f,b);
             int[] c = findColumnPenalty(f,b);
             int maxr = Arrays.stream(r).max().getAsInt();
             int maxc = Arrays.stream(c).max().getAsInt();
             System.out.println("Max Priority in row is\n"+ maxr);
             System.out.println("Max Priority in column is\n"+ maxc);
             if(maxr > maxc){
                int r1 = findRow(f,b,r,maxr);
                System.out.println("Row is :"+r1);
                int[] mr = findSmallestInRow(f,b,r1);
                if (mr == null) break; // all blocked
                System.out.println("index of Smallest element is  :\n"+mr[1]+" "+mr[2]);
                int m = Math.min(d[mr[2]],s[mr[1]]);
                System.out.println("Minimum value is is :\n"+m);
                s[mr[1]] -= m;
            d[mr[2]] -= m;
            l.add(mr[0] * m); 
            totalSupply -= m;
            totalDemand -= m;
            if(s[mr[1]] == 0){
                deleteRow(mr[1],b,c_length);
            }
            if(d[mr[2]] == 0){
                deleteColumn(mr[2],b,r_length);
            }
            printArr(b);
             }else{
                 int c1 = findColumn(f,b,c,maxc);
                 System.out.println("Column is :\n"+c1);
                 int[] mc = findSmallestInColumn(f,b,c1);
                 if (mc == null) break; // all blocked
                System.out.println("index of Smallest element is  :\n"+mc[1]+" "+mc[2]);
                 int m1 = Math.min(d[mc[2]],s[mc[1]]);
                System.out.println("Minimum value is is :\n"+m1);
                 s[mc[1]] -= m1;
            d[mc[2]] -= m1;
            l.add(mc[0] * m1); 
            totalSupply -= m1;
            totalDemand -= m1;
            if(s[mc[1]] == 0){
                deleteRow(mc[1],b,c_length);
            }
            if(d[mc[2]] == 0){
                deleteColumn(mc[2],b,r_length);
            }
            printArr(b);
             }
             
        }
        int total = 0;
        for(int i =0;i<l.size() ;i++) {
            total += l.get(i);
        }
        System.out.println("Total transportation cost: " + total);
    }
}