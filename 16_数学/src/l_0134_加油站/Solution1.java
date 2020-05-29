package l_0134_加油站;


/*作者：LeetCode
链接：https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


class Solution {
	  public int canCompleteCircuit(int[] gas, int[] cost) {
	    int n = gas.length;

	    int total_tank = 0;
	    int curr_tank = 0;
	    int starting_station = 0;
	    for (int i = 0; i < n; ++i) {
	      total_tank += gas[i] - cost[i];
	      curr_tank += gas[i] - cost[i];
	      // If one couldn't get here,
	      if (curr_tank < 0) {
	        // Pick up the next station as the starting one.
	        starting_station = i + 1;
	        // Start with an empty tank.
	        curr_tank = 0;
	      }
	    }
	    return total_tank >= 0 ? starting_station : -1;
	  }
	}

public class Solution1 {

}
