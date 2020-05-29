package t023_二叉搜索树的后序遍历序列;
/*链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd?answerType=1&f=discussion
来源：牛客网

第一眼看到题目似乎有一些陌生，但是把二叉搜索树画出来并回忆其特性之后思路就渐渐形成了，
并且看了一下其他小伙伴的思路，基本上是一致的。在编写的过程中，唯一不足的是忽略了java中
数组可以为null，也可以为[]，这个和c、c++语言空即null是不同的，需要额外注意一下*/
public class Solution1 {
    public boolean helpVerify(int [] sequence, int start, int root){
        if(start >= root)return true;
        int key = sequence[root];
        int i;
        //找到左右子数的分界点
/*        for(i=start; i < root; i++)
            if(sequence[i] > key)
                break;*/
        for(i=start; i < root && sequence[i] <= key; i++);
        //在右子树中判断是否含有小于root的值，如果有返回false
        for(int j = i; j < root; j++)
            if(sequence[j] < key)
                return false;
        return helpVerify(sequence, start, i-1) 
        		&& helpVerify(sequence, i, root-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return  helpVerify(sequence, 0, sequence.length-1);
 
    }
}
