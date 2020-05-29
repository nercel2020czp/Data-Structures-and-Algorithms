package t051_构建乘积数组;
/*解题思路

通过 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]B[i]
        =A[0]×A[1]×…×A[i−1]×A[i+1]×…×A[n−1] ，
        我们发现 B[i] 就是 A[i] 左边所有元素的积 乘 A[i] 右边所有元素的积。
        
这和分发糖果的操作思想一样，都是利用对称关系，经过两遍对称运算就能得到最终的结果。
【分发糖果：https://leetcode-cn.com/problems/candy/】

对称遍历：
	从左往右遍历累乘，结果保存在数组 ret 中，此时 ret[i] 表示，A[i] 左边所有元素的乘积
	然后从右往左遍历累乘，获取A[i] 右边所有元素的乘积
	两边遍历之后得到的 ret，就是最终结果


--------------------------【题目分析】---------------------------------
既然不能用乘法，分析题目，我们可以将乘积拆为两项。即:
L[i] = A[0] * A[1] * ... *A[i-1]
R[i] = A[i+1] *...* A[n-1]
res[i] = L[i] * R[i]

我们先来计算L[i]，使用数学归纳法：
		L[0] = 1
		L[1] = A[0]
		L[2] = A[0] * A[1]
		L[3] = A[0] * A[1] * A[2]

我们可以得出规律：L[i] = L[i-1] * A[i -1](i >= 1)
我们继续用数学归纳法计算R[i]:
		R[n-1] = 1
		R[n-2] = A[n-1]
		R[n-3] = A[n-1] * A[n-2]
		
我们可以得出规律：res[i] = res[i+1]* A[i+1](i <= n-2)	


作者：huwt
链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/gou-jian-cheng-ji-shu-zu-dui-cheng-bian-li-by-huwt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
public class Solution1 {
    public int[] multiply(int[] A) {
    	int length = A.length;
    	if(length == 0) return null;
    	int[] ret = new int[length];
        int left = 1;
        for (int i = 0; i < length; i ++) {
            ret[i] = left;
            left = left * A[i];
        } 
        int right = 1;
        for (int i = length-1; i >= 0; i --) {
            ret[i] *= right;
            right *= A[i];
        }
    	return ret;
    }
    
    
/*    vector<int> constructArr(vector<int>& a) {
        int n = a.size();
        vector<int> ret(n, 1);
        int left = 1;
        for (int i = 0; i < n; i ++) {
            ret[i] = left;
            left = left * a[i];
        } 
        int right = 1;
        for (int i = n-1; i >= 0; i --) {
            ret[i] *= right;
            right *= a[i];
        }
        return ret;
    }*/
}
