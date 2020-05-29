package t029_最小的K个数;
/*链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf?answerType=1&f=discussion
来源：牛客网

题目的思路还是非常简单的：维持一个K长度的最小值集合，然后利用插入排序的思想进行对前K个元素的不断更新。
但是非常让人气愤的是居然if(k<= 0 || k > input.length)return result的判断占据了用例的发部分。*/

import java.util.ArrayList;
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
 
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k<= 0 || k > input.length)return result;
        //初次排序，完成k个元素的排序
        for(int i = 1; i< k; i++){
            int j = i-1;
            int unFindElement = input[i];
            while(j >= 0 && input[j] > unFindElement){
                input[j+1] = input[j];
                j--;
            }
 
            input[j+1] = unFindElement;
        }
        //遍历后面的元素 进行k个元素的更新和替换
        for(int i = k; i < input.length; i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k-1;
                while(j >= 0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        //把前k个元素返回
        for(int i=0; i < k; i++)
            result.add(input[i]);
        return result;
    }
}
