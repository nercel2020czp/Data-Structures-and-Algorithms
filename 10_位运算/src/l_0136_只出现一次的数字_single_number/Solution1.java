package l_0136_只出现一次的数字_single_number;

import java.util.HashMap;
import java.util.Map;

//利用 Hash 表，Time: O(n) Space: O(n)
class Solution {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			Integer count = map.get(i);
			count = count == null ? 1 : ++count;
			map.put(i, count);
		}
		for (Integer i : map.keySet()) {
			Integer count = map.get(i);
			if (count == 1) {
				return i;
			}
		}
		return -1; // can't find it.
	}
}
