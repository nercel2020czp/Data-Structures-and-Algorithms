package 面试题17_打印从1到最大的n位数;

class Solution1 {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n);
        int[] ans = new int[max - 1];
        for(int i = 1 ; i <= max - 1 ; i++){
            ans[i - 1] = i;
        }
        return ans;
    }
/*    执行用时 :
    	2 ms
    	, 在所有 Java 提交中击败了
    	64.67%
    	的用户
    	内存消耗 :
    	48.3 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}

