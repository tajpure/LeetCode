package tajpure;

public class Candy {
	
	public static int candy(int[] ratings) {
		int length = ratings.length;
		if (length == 0) return 0;
		int[] candy = new int[length];
		int sum = 0;
		candy[0] = 1;
		for (int i = 1; i < length; i++) {
			if (ratings[i-1] < ratings[i]) {
				candy[i] = candy[i-1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		sum = candy[length-1];
		for (int i = length-2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1]) {
				candy[i] = Math.max(candy[i] ,candy[i+1] + 1);
			}
			sum += candy[i];
		}
		return sum;
	}
	
	public static void print(int[] candy) {
		for (int i=0; i < candy.length; i++) {
			System.out.print(candy[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] rating = {4,2,3,4,1}; // 1 2 1 2 3 4 1 1 2 1 1
		System.out.println(candy(rating));
	}
}
