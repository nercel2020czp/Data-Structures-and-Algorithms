/**
 * 
 */
/**
 * @author 15753
 *
 */
package c08_红黑树;
/*
◼ 红黑树必须满足以下 5 条性质

1. 节点是 RED 或者 BLACK
2. 根节点是 BLACK
3. 叶子节点（外部节点，空节点）都是 BLACK

4. RED 节点的子节点都是 BLACK
✓ RED 节点的 parent 都是 BLACK
✓ 从根节点到叶子节点的所有路径上不能有 2 个连续的 RED 节点

5. 从任一节点到叶子节点的所有路径都包含相同数目的 BLACK 节点

为何这些规则下，就能保证平衡？

最初遗留的困惑：为何那5条性质，就能保证红黑树是平衡的？
那5条性质，可以保证 红黑树 等价于 4阶B树


AVL树 vs 红黑树

◼ AVL树
平衡标准比较严格： 每个左右子树的高度差不超过1
最大高度是 1.44 ∗ log2 n + 2 − 1.328（100W个节点， AVL树最大树高28）
搜索、添加、删除都是 O(logn) 复杂度，其中添加仅需 O(1) 次旋转调整、删除最多需要 O(logn) 次旋转调整
◼ 红黑树
平衡标准比较宽松： 没有一条路径会大于其他路径的2倍
最大高度是 2 ∗ log2(n + 1)（ 100W个节点，红黑树最大树高40）
搜索、添加、删除都是 O(logn) 复杂度，其中添加、删除都仅需 O(1) 次旋转调整
◼ 搜索的次数远远大于插入和删除，选择AVL树；搜索、插入、删除次数几乎差不多，选择红黑树
◼ 相对于AVL树来说，红黑树牺牲了部分平衡性以换取插入/删除操作时少量的旋转操作，整体来说性能要优于AVL树
◼ 红黑树的平均统计性能优于AVL树，实际应用中更多选择使用红黑树

*/