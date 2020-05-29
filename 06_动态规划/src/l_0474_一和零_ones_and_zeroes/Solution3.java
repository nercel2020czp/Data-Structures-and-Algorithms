package l_0474_一和零_ones_and_zeroes;

public class Solution3 {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0 || (m==0 && n==0)){
            return 0;
        }
        
        int[][] dp = new int[m+1][n+1];
    
        for(int i=0;i<strs.length;i++){
            int numsOf0 = 0;
            int numsOf1 = 0;
            String str = strs[i];
            for(int j = 0;j<str.length();j++){
                if(str.charAt(j) == '0'){
                    numsOf0++;
                }else{
                    numsOf1++;
                }
            }
            for(int j=m;j>=numsOf0;j--){
                for(int k=n;k>=numsOf1;k--){
                    dp[j][k] = Math.max(dp[j][k],1+dp[j-numsOf0][k-numsOf1]);
                }
            }
        }
        return dp[m][n];
    }
}
