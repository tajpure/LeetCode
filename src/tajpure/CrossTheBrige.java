package tajpure;

/**
 * The problem doesn't belong to the problem list of the LeetCode. Description:
 * There are four women want to cross the brige. The time their will cost
 * respectively is 1,2,5,10 min, And the brige just permits two women to cross
 * each time. Please use 17 min, let them cross the brige.
 * 
 * @author taojx
 * 
 */
public class CrossTheBrige {

	public class Woman {
		public int time;
		public boolean crossed = false;

		public Woman(int time) {
			this.time = time;
		}
	}

	public class Torch {
		public Woman owner;

		public Torch(Woman owner) {
			this.owner = owner;
		}
	}

	public static boolean checkAllCrossed(Woman[] women) {
		boolean AllCrossed = true;
		for (int i = 0; i < women.length; i++) {
			if (!women[i].crossed) {
				AllCrossed = false;
				break;
			}
		}
		return AllCrossed;
	}
	
	public static int cross(Woman...women) {
		int time = 0;
		if (women.length == 1) {
			time = women[0].time;
			women[0].crossed = false;
		} else if (women.length == 2) {
			time = Math.max(women[0].time, women[1].time);
			women[0].crossed = true;
			women[1].crossed = true;
		}
		return time;
	}
	
	public static int crossTwo() {
		int time = 0;
		
		return time;
	}

	public static void main(String[] args) {
		// int minTime = 17;
		int curTime = 0;
		CrossTheBrige cross = new CrossTheBrige();
		Woman[] women = { cross.new Woman(1), cross.new Woman(2),
				cross.new Woman(5), cross.new Woman(10) };
		StringBuilder info = new StringBuilder();

		for (int i = 0; i < women.length; i++) {
			for (int j = 0; j < women.length; j++) {
				if (i == j) continue;

				curTime +=  cross(women[i], women[j]);
				if (women[i].time > women[j].time) {
					curTime += cross(women[j]);
				} else {
					curTime += cross(women[i]);
				}

				if (!checkAllCrossed(women)) { // Print the cross info
					System.out.println(info);
					info.delete(0, info.capacity() - 1);
				}
			}
		}

	}

}
