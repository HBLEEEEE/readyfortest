package KakaoBrain220520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

	/*
	 * Complete the 'closestStraightCity' function below.
	 *
	 * The function is expected to return a STRING_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY c
	 *  2. INTEGER_ARRAY x
	 *  3. INTEGER_ARRAY y
	 *  4. STRING_ARRAY q
	 */

	public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
		// Write your code here

		System.out.println("c = " + c);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("q = " + q);

		List<String> answer = new ArrayList<>();
		int[] nums = new int[c.size()];
		Arrays.fill(nums, -1);

		for (int i = 0; i < c.size(); i++) {
			int nearDistance = 1000000000;
			int cordX = x.get(i);
			int cordY = y.get(i);

			for (int j = 0; j < c.size(); j++) {
				if (i == j) {
					continue;
				}
				int tempX = x.get(j);
				int tempY = y.get(j);
				if (cordX == tempX || cordY == tempY) {
					int dis = Math.abs((cordX + cordY - tempX - tempY));
					if (dis < nearDistance) {
						nearDistance = dis;
						nums[i] = j;
					} else if (dis == nearDistance) {
						int res = c.get(nums[i]).compareTo(c.get(j));
						if (res > 0) {
							nums[i] = j;
						}
					}
				}
			}
			if (nums[i] == -1) {
				answer.add(i, "NONE");
			} else {
				answer.add(i, c.get(nums[i]));
			}
		}

		return answer;

	}

}
