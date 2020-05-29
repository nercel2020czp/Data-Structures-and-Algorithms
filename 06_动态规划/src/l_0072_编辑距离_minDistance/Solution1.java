package l_0072_编辑距离_minDistance;
/*动态规划：
dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
所以，
当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], 
					dp[i-1][j], dp[i][j-1]) + 1

其中，dp[i-1][j-1] 表示替换操作【将word1[i]替换成word2[j]】，
	 dp[i-1][j] 表示删除操作【将word1[i]删除掉】，
	 dp[i][j-1] 表示插入操作【将word2[j]插入】。

对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”
的补充理解：
	以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字
	符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
	(1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 
		2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 
		替换为 s（即替换为 word2 的第三个字符，word2[2]）
	(2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2
	 	个字符 ro，然后在末尾补充一个 s，即插入操作
	(3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个
		字符 ros，然后删除 word1 的第 5 个字符

注意，针对第一行，第一列要单独考虑，我们引入 '' 下图所示：
https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/


作者：powcai
链接：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) 
        	dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) 
        	dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                	dp[i][j] = dp[i - 1][j - 1];
                else 
                	dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],
                			dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];  
    }
    
/*    执行用时 :
    	11 ms
    	, 在所有 Java 提交中击败了
    	20.49%
    	的用户
    	内存消耗 :
    	41.5 MB
    	, 在所有 Java 提交中击败了
    	5.11%
    	的用户*/
    
}
