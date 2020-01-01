package Additional;

public class Question5_2 {
    public static int[][] dp;

    public static int[][] breakDp;

    public static int matrixNum; //矩阵数

    public static int[] matrixChain = {1,2,3,4,5,6}; //矩阵链

    public static void main(String[] args){
        loadData();
        for(int i = 0; i < matrixNum; i++){
            dp[i][i] = 0;
        }
        matrixLinkedMultiply();
    }

    public static void matrixLinkedMultiply(){
        for(int x = 1; x < matrixNum; x++){
            for(int y = x - 1; y >= 0; y--){
                int count = Integer.MAX_VALUE;
                for(int k = y; k <= x - 1; k++){
                    int tempCount = dp[y][k] + dp[k + 1][x] + matrixChain[y] * matrixChain[x + 1] *  matrixChain[k + 1];
                    if(count > tempCount){
                        count = tempCount;
                        dp[y][x] = tempCount;
                        breakDp[y][x] = k;
                    }
                }
            }
        }
        System.out.println("该矩阵链的最小计算次数："+ dp[0][matrixNum - 1]);
        for(int i = 0; i < matrixChain.length - 1; i++){
            for(int j = 0; j < matrixChain.length - 1; j++){
                System.out.print(dp[i][j] +"\t\t\t");
            }
            System.out.println();
        }

        printOptimalPatterns(breakDp, 0, matrixNum - 1);
        System.out.println();
        for(int i = 0; i < breakDp.length; i++){
            for(int j = 0; j < breakDp.length; j++){
                System.out.print(breakDp[i][j] +"\t\t\t");
            }
            System.out.println();
        }

    }

    static void printOptimalPatterns(int[][] breakDp,int i, int j){
        if(i==j)
            System.out.print("A"+(i+1));//A从1开始，所以记得加1
        else{
            System.out.print("(");
            printOptimalPatterns(breakDp,i, breakDp[i][j]);
            printOptimalPatterns(breakDp, breakDp[i][j] + 1,j);
            System.out.print(")");
        }
    }

    public static void loadData(){
        matrixNum = matrixChain.length - 1;
        dp = new int[matrixNum][matrixNum];
        breakDp = new int[matrixNum][matrixNum];
    }
}
