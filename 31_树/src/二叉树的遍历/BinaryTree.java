package 二叉树的遍历;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


@SuppressWarnings("unchecked")
//public class BinaryTree<E> implements BinaryTreeInfo {
public class BinaryTree<E> {
	protected int size;
	protected Node<E> root;
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		root = null;
		size = 0;
	}
	
/*	public void preorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> node = stack.pop();
			// 访问node节点
			if (visitor.visit(node.element)) return;
			//要注意的是先把右孩子压入栈
			if (node.right != null) {
				stack.push(node.right);
			}
			//再把左孩子压入栈
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}*/
	
	public void preorder(Visitor<E> visitor) {
/*		if (visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while (true) {
			if (node != null) {
				// 访问node节点
				if (visitor.visit(node.element)) return;
				// 将右子节点入栈
				if (node.right != null) {
					stack.push(node.right);
				}
				// 向左走
				node = node.left;
			} else if (stack.isEmpty()) {
				return;
			} else { 
				// 处理右边
				node = stack.pop();
			}
		}*/
		if (visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while(!stack.empty() || node != null) {
			/*首先，我们遍历左子树，边遍历边打印，并把根节点存入栈中，以后需借助这些节点进入右子树开启新一轮的循环。*/
			//边遍历边打印，并存入栈中，以后需要借助这些根节点(不要怀疑这种说法哦)进入右子树
			while(node != null) {
				// 访问node节点
				if (visitor.visit(node.element)) return;
				// 并把node节点存入栈中
				stack.push(node);
				// 向左走
				node = node.left;
			}
			//当p为空时，说明根和左子树都遍历完了，该进入右子树了
			if(!stack.empty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}
	
	
	
	public void inorder(Visitor<E> visitor) {
		/*		【方法1】
		if (visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
 		while (true) {
			if (node != null) {
				stack.push(node);
				// 向左走
				node = node.left;
			} else if (stack.isEmpty()) {
				return;
			} else {
				node = stack.pop();
				// 访问node节点
				if (visitor.visit(node.element)) return;
				// 让右节点进行中序遍历
				node = node.right;
			}
		}*/
		//【方法2：自己修改】
		if (visitor == null || root == null) 
			return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while(!stack.empty() || node != null) {
			//一直遍历到左子树最下边，边遍历边保存根节点到栈中
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			//当p为空时，说明已经到达左子树最下边，这时需要出栈了
			if(!stack.empty()) {
				node = stack.pop();
				if (visitor.visit(node.element)) 
					return;
				//进入右子树，开始新的一轮左子树遍历(这是递归的自我实现)
				node = node.right;
			}
		}
	}
	
	
	
	public void postorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		// 记录上一次弹出访问的节点
		Node<E> prev = null;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> top = stack.peek();
			if (top.isLeaf() || (prev != null && prev.parent == top)) {
				prev = stack.pop();
				// 访问节点
				if (visitor.visit(prev.element)) return;
			} else {
				if (top.right != null) {
					stack.push(top.right);
				}
				if (top.left != null) {
					stack.push(top.left);
				}
			}
		}
	}
	
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) return;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public boolean isComplete() {
		if (root == null) return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;

			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				return false;
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			} else { // 后面遍历的节点都必须是叶子节点
				leaf = true;
			}
		}
		
		return true;
	}
	
	public int height() {
		if (root == null) return 0;
		
		// 树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}

			if (levelSize == 0) { // 意味着即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}
	
	public int height2() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	protected Node<E> createNode(E element, Node<E> parent) {
		return new Node<>(element, parent);
	}

	protected Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		
		// 前驱节点在左子树当中（left.right.right.right....）
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}

		// node.parent == null
		// node == node.parent.right
		return node.parent;
	}
	
	protected Node<E> successor(Node<E> node) {
		if (node == null) return null;
		
		// 前驱节点在左子树当中（right.left.left.left....）
		Node<E> p = node.right;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}

		return node.parent;
	}

	public static abstract class Visitor<E> {
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
	}
	
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
		
		public boolean isLeftChild() {
			return parent != null && this == parent.left;
		}
		
		public boolean isRightChild() {
			return parent != null && this == parent.right;
		}
		
		public Node<E> sibling() {
			if (isLeftChild()) {
				return parent.right;
			}
			
			if (isRightChild()) {
				return parent.left;
			}
			
			return null;
		}
		
		@Override
		public String toString() {
			return element.toString();
		}
	}

/*	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return node;
	}*/
}
