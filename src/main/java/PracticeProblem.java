import java.util.*;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int fib(int num){
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	return fibHelper(num, map);
}

public static int fibHelper(int num, HashMap<Integer, Integer> map) {

	//base cases

	if (num == 0){
		return 0;
	}
	

	if (num == 1){
		return 1;
	}

	//check the map

	if (map.containsKey(num)){
		return map.get(num);
	}
	
	int fibNum = fibHelper(num - 1, map) + fibHelper(num - 2, map);
	map.put(num, fibNum);

	return fibNum;
	}

	public static int minCostClimbingStairs(int[] cost){
	
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (cost.length == 1){
			return cost[0];
		}

		return Math.min(minCostClimbingStairsHelper(cost, map, 0), minCostClimbingStairsHelper(cost, map, 1));
	}

	public static int minCostClimbingStairsHelper(int[] cost, HashMap<Integer, Integer> map, int index){
		//base case
		if (index >= cost.length){
			return 0;
		}
		
		//memorization 
		if (map.containsKey(index)){
			return map.get(index);
		}

		//goes up one step or two steps, reccursive case
		int oneStep = minCostClimbingStairsHelper(cost, map, index + 1);
		int twoSteps = minCostClimbingStairsHelper(cost, map, index + 2);

		map.put(index, cost[index] + Math.min(oneStep, twoSteps));

		return map.get(index);
	}
}
