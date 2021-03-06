/**
 * 
 */
/**
 * @author 15753
 *
 */
package c02_分治算法.c01_汉诺塔问题;

/*14.2.4 分治算法最佳实践-汉诺塔
 汉诺塔的传说
汉诺塔： 汉诺塔（又称河内塔） 问题是源于印度一个古老传说的益智玩具。 大梵天创造世界的时候做了三根金
刚石柱子， 在一根柱子上从下往上按照大小顺序摞着 64 片黄金圆盘。 大梵天命令婆罗门把圆盘从下面开始按大小
顺序重新摆放在另一根柱子上。 并且规定， 在小圆盘上不能放大圆盘， 在三根柱子之间一次只能移动一个圆盘。
假如每秒钟一次， 共需多长时间呢？ 移完这些金片需要 5845.54 亿年以上， 太阳系的预期寿命据说也就是数百
亿年。 真的过了 5845.54 亿年， 地球上的一切生命， 连同梵塔、 庙宇等， 都早已经灰飞烟灭。

	 汉诺塔游戏的演示和思路分析:
	
	1) 如果是有一个盘， A->C
		如果我们有 n >= 2 情况， 我们总是可以看做是两个盘 
			1.最下边的盘 
			2.上面的盘
	2) 先把 最上面的盘 A->B
	3) 把最下边的盘 A->C
	4) 把 B 塔的所有盘 从 B->C*/