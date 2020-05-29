package t001_二维数组中的查找;

/*一、暴力法
1. 分析
挨个遍历数组，如果找到就返回 true

3. 复杂度
时间复杂度：O(n^2)
空间复杂度：O(1)

*/
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
