package tajpure;

public class GasStation {
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int totalGas = 0;
		int length = gas.length;
		int needGas = 0;
		for (int i=0; i < length; i++) {
			totalGas += gas[i];
			if (totalGas >= cost[i]) {
				totalGas -= cost[i];
			} else {
				needGas += cost[i] - totalGas;
				start = i;
				totalGas = 0;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5,6};
		int[] cost = {1,2,4,4,5,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
