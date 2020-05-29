package l_0904_水果成篮;
//与l_0003_无重复字符的最长子串   类似
class Solution {
    public int totalFruit(int[] tree) {
        int res = 0, len = tree.length;
        int one = tree[0], two, begin = 0, end = 1; //2种树的状态(one, two)， one初始化为tree数组的第1个元素
        while (end < len && tree[end] == one)   //寻找two的初始值，以构成初始(one, two)
            ++end;
        if (end == len) return len; //若整个数组的元素都由初始的(one, two)所构成，则直接返回数组长度
        two = tree[end++];  //构成初始的(one, two)
        for (; end < len; ++end) {
            if (one != tree[end] && two != tree[end]) { //遇到了第3种树
                res = Math.max(res, end - begin);   //更新最终返回结果
                one = tree[end - 1];    //(one, two)更新为(第3种树的左边的树, 第3种树)
                two = tree[end];
                begin = end - 1;    //更新由当前(one, two)所构成的连续子数组的左边界
                while (begin > -1 && tree[begin - 1] == one)   //向左寻找由one构成的连续子数组
                    --begin;
            }
        }
        return Math.max(res, end - begin);
    }
}

public class Solution1 {

}

/*执行用时 :
4 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗 :
47.8 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/
