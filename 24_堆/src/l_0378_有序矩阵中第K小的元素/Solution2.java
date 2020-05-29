package l_0378_有序矩阵中第K小的元素;
/*
2.二分法的运用


*/
public class Solution2 {
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		45.8 MB
		, 在所有 Java 提交中击败了
		7.69%
		的用户*/
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0], right = matrix[n][n];
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int countNotMoreThanMid(int[][] matrix, int mid, int n){
        int count = 0;
        int x = 0, y = n;
        while(x <= n && y >= 0){
            if(matrix[y][x] <= mid){
                count += y + 1;
                x++;
            }else{
                y--;
            }
        }
        return count;
    }

/*作者：ustcyyw
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378java-er-fen-fa-tu-jie-you-xian-dui-lie-liang-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
