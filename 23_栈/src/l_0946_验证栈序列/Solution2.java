package l_0946_验证栈序列;
/*
解法二：优化解法一

解法二：
仔细观察解法一，你可以发现，其实stack是多余的。在遍历数组pushed的时候，
pushed[i]其实就是stack栈顶的元素，这时候，pushed[i-1]、push[i-2]...
这些位置已经是"空闲"出来了，所以完全可以用数组pushed来取代stack的作用。

作者：TuFeiBaBa
链接：https://leetcode-cn.com/problems/validate-stack-sequences/solution/jie-fa-yi-shi-yong-shu-zu-lai-shi-xian-zhan-de-zuo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution2 {
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.5 MB
		, 在所有 Java 提交中击败了
		90.00%
		的用户*/
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
	    int size = 0;
	    for (int i = 0, j = 0; i < pushed.length; i++) {
	        pushed[size++] = pushed[i];
	        while (size != 0 && pushed[size - 1] == popped[j]) {
	            size--; j++;
	        }
	    }
	    return size == 0;
	}

/*	作者：TuFeiBaBa
	链接：https://leetcode-cn.com/problems/validate-stack-sequences/solution/jie-fa-yi-shi-yong-shu-zu-lai-shi-xian-zhan-de-zuo/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
