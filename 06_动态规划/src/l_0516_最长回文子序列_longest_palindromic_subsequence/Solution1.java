package l_0516_最长回文子序列_longest_palindromic_subsequence;

/*
执行结果：
通过
显示详情
执行用时 :
140 ms
, 在所有 C++ 提交中击败了
38.54%
的用户
内存消耗 :
67.2 MB
, 在所有 C++ 提交中击败了
75.00%
的用户
int longestPalindromeSubseq(string s) {
	int n = s.size();
	// dp 数组全部初始化为 0
	vector<vector<int>> dp(n, vector<int>(n, 0));
	// base case
	for (int i = 0; i < n; i++)
		dp[i][i] = 1;
	// 反着遍历保证正确的状态转移
	for (int i = n - 1; i >= 0; i--) {
	for (int j = i + 1; j < n; j++) {
		// 状态转移方程
		if (s[i] == s[j])
			dp[i][j] = dp[i + 1][j - 1] + 2;
		else
			dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
		}
	}
	// 整个 s 的最长回文串长度
	return dp[0][n - 1];
}

 */

public class Solution1 {

}
