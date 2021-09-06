import java.util.*;
public class Test {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        String s = "bbb";
        //babad   cbbd
        int n = s.length();
        int[][] dp = new int[n ][n ];

        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){
                    dp[i][j] = 1;
                }
                else if(j - i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                }
                else if(dp[i + 1][j - 1] > 0 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        int a = 0; int b = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                    a = i; b = j;
                }
            }
        }
        for(int i = a; i <= b; i++){
            System.out.print(s.charAt(i));
        }
    }

}
