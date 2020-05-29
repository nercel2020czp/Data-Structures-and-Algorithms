package l_0297_二叉树的序列化与反序列化;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
方法一：深度优先搜索
【见图1.png】
Binary Search Tree 的序列化本质上是对其值进行编码，
更重要的是对其结构进行编码。可以遍历树来完成上述任务。
众所周知，我们有两个一般策略：
	1.广度优先搜索（BFS）:
		我们按照高度的顺序从上到下逐级扫描树。更高级别的节点将先于较低级别的节点访问。
	2.深度优先搜索（DFS):
		在这个策略中，我们采用深度作为优先顺序，这样我们就可以从一个根开始，
		一直延伸到某个叶，然后回到根，到达另一个分支。
		
	根据根节点、左节点和右节点之间的相对顺序，可以进一步将DFS策略区
	分为 preorder、inorder 和 postorder 。

然而，在这个任务中，DFS 策略更适合我们的需要，因为相邻节点之间的链接自然地
按顺序编码，这对后面的反序列化任务非常有帮助。

因此，在这个解决方案中，我们用 preorder DFS 策略演示了一个示例。
您可以在 leetcode explore上查看有关二叉搜索树的更多教程。

算法：
首先，这里是 TreeNode 的定义，我们将在下面的实现中使用它。
		public class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) {
		    val = x;
		  }
		}

先序遍历的 DNS 按 root -> left subtree -> right subtree 的顺序递归进行。

作为一个例子，让我们序列化下面的树。请注意，序列化包含有关节点值的信息以及有关树结构的信息。
见链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-leet/

我们从根节点 1 开始，序列化字符串是 1,。然后我们跳到根节点 2 的左子树，序列化字符串变成 1,2,。
现在从节点 2 开始，我们访问它的左节点 3（1,2,3，none，none，）和右节点 4。
(1,2,3,None,None,4,None,None)。None,None, 是用来标记缺少左、右子节点，
这就是我们在序列化期间保存树结构的方式。最后，我们回到根节点 1 并访问它的右子树，
它恰好是叶节点 5。最后，序列化字符串是按 1,2,3,None,None,4,None,None,5,None,None,.

	// Serialization
	public class Codec {
	  public String rserialize(TreeNode root, String str) {
	    // Recursive serialization.
	    if (root == null) {
	      str += "null,";
	    } else {
	    //字符串拼接应该用stringbuilder吧，
	      str += str.valueOf(root.val) + ",";
	      str = rserialize(root.left, str);
	      str = rserialize(root.right, str);
	    }
	    return str;
	  }
	
	  // Encodes a tree to a single string.
	  public String serialize(TreeNode root) {
	    return rserialize(root, "");
	  }
	}

现在让我们反序列化 1,2,3,None,None,4,None,None,5,None,None, 字符串。
它沿着字符串运行，初始化节点值，然后调用自身来构造其左、右子节点。

	public class Codec {
	  public TreeNode rdeserialize(List<String> l) {
	    // Recursive deserialization.
	    if (l.get(0).equals("null")) {
	      l.remove(0);
	      return null;
	    }
	
	    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
	    l.remove(0);
	    root.left = rdeserialize(l);
	    root.right = rdeserialize(l);
	
	    return root;
	  }
	
	  // Decodes your encoded data to tree.
	  public TreeNode deserialize(String data) {
	    String[] data_array = data.split(",");
	    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
	    return rdeserialize(data_list);
	  }
	}

复杂度分析：
	时间复杂度：在序列化和反序列化函数中，我们只访问每个节点一次，因此时间复杂度为 O(n)，其中 n 是节点数，即树的大小。
	空间复杂度：在序列化和反序列化函数中，我们将整棵树保留在开头或结尾，因此，空间复杂性为 O(n)。
	具有 BFS 或其他 DFS 策略的解决方案通常具有相同的时间和空间复杂性。

进一步空间优化 :
	在以上解决方案，我们存储节点值和对 None 节点的引用 ，这意味 N*V+2N 复杂性，其中 V 是大小的值。
	这称为自然序列化，并已在上面实现。


作者：LeetCode
链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-leet/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	public static void main(String[] args) {
//	     1
//	    / \
//	   2   3
//	      / \
//	     4   5
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		TreeNode root = node1;
		
		Codec codec = new Codec();
		String serializeString = codec.serialize(root);
		System.out.println(serializeString);
		
		serializeString = serializeString.substring(0, serializeString.length()-1);
//		String[] splitList = serializeString.substring(0, serializeString.length()-1).split(",");
//		
//		System.out.println(Arrays.toString(splitList));
		
		TreeNode newRoot = codec.deserialize(serializeString);
		String serializeString1 = codec.serialize(newRoot);
		System.out.println(serializeString1);
		
	}
}

// Serialization
class Codec {
	public String rserialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			//重点是碰到NULL时，也要将其用#标识并输出。NULL节点虽然不是数字，
			//但是能决定二叉树的结构。没有NULL节点，单靠先序序列是无法恢复成树的。
			str += "null,";
		} else {
			str += String.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}

	public TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}
	

}
/*
执行用时 :
159 ms
, 在所有 Java 提交中击败了
14.90%
的用户
内存消耗 :
41.9 MB
, 在所有 Java 提交中击败了
21.43%
的用户*/

