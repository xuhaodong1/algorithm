package Additional;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-31 15:39
 */
public class Question5 {
    public static final String s1 = "saabcd";
    public static final String s2 = "aaeefdhe";
    public static int[][] dp;
    public static void main(String[] args){
        dp = new int[s1.length() + 1][s2.length() + 1];
        findLongestCommonSubsequence();
        System.out.println(dp[s1.length()][s2.length()]);
        printFound(s1.length(), s2.length(), "");
    }

    public static void findLongestCommonSubsequence(){
        for(int i = 1;  i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    System.out.println("找到" + s1.charAt(i - 1) + "相同, 填入矩阵x:" + i + ",y:" + j + ";现有序列长度为" + dp[i][j] + "个相同");
                }else{
                    dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public static void printFound(int lengthS1, int lengthS2, String commonStr){
        while(lengthS1 >= 1 && lengthS2 >= 1){
            if(s1.charAt(lengthS1 - 1) == s2.charAt(lengthS2 - 1)){
                commonStr += s1.charAt(lengthS1 - 1);
                lengthS1--;
                lengthS2--;
            }else{
                if(dp[lengthS1][lengthS2 - 1] > dp[lengthS1 - 1][lengthS2]) {
                    lengthS2--;
                } else if(dp[lengthS1][lengthS2 - 1] <= dp[lengthS1 - 1][lengthS2]){
                    lengthS1--;
                }else{
                    printFound(lengthS1, lengthS2 - 1, commonStr);
                    printFound(lengthS1 - 1, lengthS2, commonStr);
                }
            }
        }
        System.out.println(commonStr);
    }
}