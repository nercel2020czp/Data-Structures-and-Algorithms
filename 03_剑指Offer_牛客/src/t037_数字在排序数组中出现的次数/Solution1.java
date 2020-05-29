package t037_数字在排序数组中出现的次数;
/*这道题目思路挺简单的，就是先二叉搜索找一下这个元素的位置，然后再开始遍历搜索一下。
本来想自己写一个二叉搜索函数的，但是转念一下java中有排序，还是用一下吧，这样代码就简洁很多。

*/

import java.util.Arrays;
public class Solution1 {
    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array, k);
        if(index<0)return 0;
        int cnt = 1;
        for(int i=index+1; i < array.length && array[i]==k;i++)
            cnt++;
        for(int i=index-1; i >= 0 && array[i]==k;i--)
            cnt++;
        return cnt;
    }
}
