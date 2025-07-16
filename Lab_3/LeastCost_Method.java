import java.util.*;

public class LeastCost_Method{
    private static void deleteRow(int row,boolean[][] visite,int r){
        for(int i = 0;i<r;i++){
            visite[row][i] = true;
        }
    }
    private static void deleteColumn(int column,boolean[][] visite,int c){
        for(int i = 0;i<c;i++){
            visite[i][column] = true;
        }
    }
    public static int[] findAttribute(int[][] nums,boolean[][] visite,int[] d,int[] s){
        int[] property = new int[2];
         int[] temp1 = new int[2];
        int  m = Integer.MAX_VALUE;
        int temp = 0;
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(!visite[i][j] && nums[i][j]<=m){
                        
                        if(temp == nums[i][j]){
                           int m1 = Math.min(d[temp1[1]],s[temp1[0]]);
                           int m2 = Math.min(d[j],s[i]);
                           if(m2>m1){
                              m = nums[i][j];
                           }else{
                             m = temp;
                           }
                        }else{
                            m = nums[i][j];
                            temp = m;
                            temp1[0]=i;
                            temp1[1] =j;
                            property[0] = i;
                            property[1] = j; 
                        }
                        
                }
            }
        }
        return property;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*  If you want to add data staticaly*/

        /* -----------------------Example 1 for check------------------------*/
        // int[] s ={30, 40, 30};
        // int[] d ={20, 50, 30};
        // int[][] TravelCost = {  {4, 3, 1},  // S1
        //     {2, 1, 5},  // S2
        //     {3, 2, 1} };


        /* -----------------------Example 2 for check------------------------*/
        // int[] s = {50, 60, 25};    // S1, S2, S3
        // int[] d = {30, 50, 55};    // D1, D2, D3

        // int[][] TravelCost = {
        //     {2, 3, 1},   // S1 → D1, D2, D3
        //     {5, 4, 8},   // S2 → D1, D2, D3
        //     {5, 6, 8}    // S3 → D1, D2, D3
        // };

         /* -----------------------Example 3 for check------------------------*/
        //int[] s = {40, 30, 50};     // S1, S2, S3
        // int[] d = {20, 60, 40};     // D1, D2, D3

        // int[][] TravelCost = {
        //     {3, 1, 7},    // S1
        //     {2, 6, 5},    // S2
        //     {4, 3, 2}     // S3
        // };
        
        /* -----------------------Example 4 for check------------------------*/
        int[] s ={500,300,200};
        int[] d ={180,150,350,320};

        int[][] TravelCost = {{12,10,12,13},{7,11,8,14},{6,16,11,7}}; 
         int  r = TravelCost[0].length;
         int  c = TravelCost.length;

        boolean[][] visite = new boolean[3][4];

        int totalSupply = Arrays.stream(s).sum();
        int totalDemand = Arrays.stream(d).sum();
        List<Integer> l = new ArrayList<>();
        while(totalDemand!=0 && totalSupply!=0){
            int[] p = findAttribute(TravelCost,visite,d,s);
            int x = p[0];
            int y = p[1];
            System.out.println("x ="+x);
            System.out.println("y ="+y);
            int m = Math.min(d[y],s[x]);
            // if(d[y]-m == 0){
            //     totalDemand-=m;
            //     l.add(TravelCost[x][y]*m);
            //     s[x]-=m;
            //     deleteColumn(y,visite,r);
            // }
            // if(s[x]-m == 0){
            //     totalSupply-=m;
            //     l.add(TravelCost[x][y]*m);
            //     d[y]-=m;
            //     deleteRow(x,visite,c);
            // }
            s[x] -= m;
            d[y] -= m;
            l.add(TravelCost[x][y] * m); 
            totalSupply -= m;
            totalDemand -= m;
            if(s[x] == 0){
                deleteRow(x,visite,r);
            }
            if(d[y] == 0){
                deleteColumn(y,visite,c);
            }
        }
        int total = 0;
        for (Integer num : l) {
            total += num;
        }
        System.out.println("Total transportation cost: " + total);

    }
}