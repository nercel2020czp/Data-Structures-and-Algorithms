package l_0331_验证二叉树的前序序列化;
/*
方法一：迭代

思路

首先不考虑最优性，从最简单的解法来讨论这个问题。

我们可以定义一个概念，叫做槽位，二叉树中任意一个节点或者空孩子节点都要占据一个槽位。
二叉树的建立也伴随着槽位数量的变化。开始时只有一个槽位，如果根节点是空节点，就只消耗掉一个槽位，
如果根节点不是空节点，除了消耗一个槽位，还要为孩子节点增加两个新的槽位。之后的节点也是同理。

有了上面的讨论，方法就很简单了。依次遍历前序序列化，根据节点是否为空，按照规则消耗/增加槽位。
如果最后可以将所有的槽位消耗完，那么这个前序序列化就是合法的。

		开始时只有一个可用槽位。
		空节点和非空节点都消耗一个槽位。
		空节点不增加槽位，非空节点增加两个槽位。

rules.png

算法:
	1.初始化可用槽位：slots = 1。
	2.根据逗号分隔前序序列化，将结果数组存储，随后遍历该数组：
		2.1 空节点和非空节点都消耗一个槽位：slots = slot - 1.
		2.2 如果当前的可用槽位是负数，那么这个前序序列化是非法的，返回 False。
		2.3 非空节点（node != '#'）新增两个可用槽位：slots = slots + 2.
		2.4 如果所有的槽位都消耗完，那么这个前序序列化就是合法的：返回 slots == 0。

作者：LeetCode
链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-hua-by-leet/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
/*	
	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		76.55%
		的用户
		内存消耗 :
		39.1 MB
		, 在所有 Java 提交中击败了
		5.55%
		的用户
	*/
	class Solution {
/*		开始时只有一个可用槽位。
		空节点和非空节点都消耗一个槽位。
		空节点不增加槽位，非空节点增加两个槽位。*/
		public boolean isValidSerialization(String preorder) {
			// number of available slots
			//开始时只有一个可用槽位。
			int slots = 1;

			for (String node : preorder.split(",")) {
				// one node takes one slot
				//空节点和非空节点都消耗一个槽位。
				--slots;

				// no more slots available
				//空节点不增加槽位
				if (slots < 0)
					return false;

				//非空节点增加两个槽位。
				// non-empty node creates two children slots
				if (!node.equals("#"))
					slots += 2;
			}

			// all slots should be used up
			return slots == 0;
		}
	}

/*		作者：LeetCode
		链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-hua-by-leet/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
