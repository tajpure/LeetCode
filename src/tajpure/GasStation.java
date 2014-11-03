package tajpure;

public class GasStation {
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int restGas = 0;
		int length = gas.length;
		int needGas = 0;
		for (int i=0; i < length; i++) {
			restGas += gas[i];
			if (restGas >= cost[i]) {
				restGas -= cost[i];
			} else {
				needGas += cost[i] - restGas;
				start = i + 1;
				restGas = 0;
			}
		}
		if (needGas - restGas > 0) {
			start = -1;
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] gas = {2,2,3,4,5,6,3};
		int[] cost = {1,2,4,4,5,4,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
