package l_0718_最长重复子数组_findLength;

public class Solution1 {
    public int findLength(int[] A, int[] B) {
        int i,j;
        int len = 0;
        //建立一个二维表。
        int[][] dp = new int[A.length + 1][B.length + 1]; 
        for(i = 1; i <= A.length; i++){
            for(j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){
                	//如果两个元素相等，就看他前面一个元素匹配的结果。
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(dp[i][j] > len){
                	//这里是找最长得长度
                    len = dp[i][j];
                }
            }
        }
        return len;
    }
}
/*执行结果：
通过
显示详情
执行用时 :
54 ms
, 在所有 Java 提交中击败了
30.56%
的用户
内存消耗 :
53.4 MB
, 在所有 Java 提交中击败了
5.23%
的用户*/