package l_0046_全排列_permutations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*执行用时 :
3 ms
, 在所有 Java 提交中击败了
44.87%
的用户
内存消耗 :
40.1 MB
, 在所有 Java 提交中击败了
7.32%
的用户*/

public class Solution1 {
	List<List<Integer>> res = new LinkedList<>();
	
	//主函数，输入一组不重复的数字，返回它们的全排列 
	List<List<Integer>> permute(int[] nums) {
	    // 记录「路径」
	    LinkedList<Integer> track = new LinkedList<>();
	    backtrack(nums, track);
	    return res;
	}
	
	// 路径：记录在 track 中
	// 选择列表：nums 中不存在于 track 的那些元素
	// 结束条件：nums 中的元素全都在 track 中出现
	void backtrack(int[] nums, LinkedList<Integer> track) {
	    // 触发结束条件
	    if (track.size() == nums.length) {
	        res.add(new LinkedList(track));
	        return;
	    }
	    
	    for (int i = 0; i < nums.length; i++) {
	        // 排除不合法的选择
	        if (track.contains(nums[i]))
	            continue;
	        // 做选择
	        track.add(nums[i]);
	        // 进入下一层决策树
	        backtrack(nums, track);
	        // 取消选择
	        track.removeLast();
	    }
	}
	
	private void printResult(List<List<Integer>> result) {
		// TODO Auto-generated method stub
		
		for(List<Integer> temp : result) {
			Iterator<Integer> iter = temp.iterator();
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
//			System.out.println("******************");
		}
		
		System.out.println(result.size());

	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		Solution1 s = new Solution1();
		s.printResult(s.permute(arr));
		
	}
}
