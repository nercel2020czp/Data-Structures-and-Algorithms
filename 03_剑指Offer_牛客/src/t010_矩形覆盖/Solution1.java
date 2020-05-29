package t010_矩形覆盖;
/*
迭代:
	涂掉最后一级矩形的时候，是用什么方式完成的？

链接：https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6?answerType=1&f=discussion
来源：牛客网

n = 1 的时候
	只能横着覆盖，一种
n = 2 的时候
	可以横着和竖着覆盖，两种
n = 3 的时候
	第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
	第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
	总共有 3 种
n = 4 的时候
	第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
	第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
	总共有 5 种方法
n = n 的时候
	第 n 级横着覆盖，用了一级，剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法
	第 n 级竖着覆盖，用了两级，剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
	总和为两种情况的总和

从 n = 1 到 n = 4 的示意图如下：【见图2.png】


所以回答上面的问题，涂掉最后一级矩阵的时候，可以选择使用横向完成，也可以使用竖向完成，横向涂剩下 n - 1 阶，竖向涂剩下 n - 2 阶

关注 n - 1 与 n - 2 时的涂法有几种，这就是斐波那契数列

*/


public class Solution1 {
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int pre1 = 2; // n 最后使用一块，剩下 n-1 块的写法
        int pre2 = 1; // n 最后使用两块，剩下 n-2 块的写法
        for (int i = 3; i <= target; i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1; //相对于 n+1 块来说，第 n 种的方法
    }
}
