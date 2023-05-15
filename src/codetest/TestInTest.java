package codetest;

import java.util.Arrays;

public class TestInTest {

	public static int solution(int[] nums) {
		int answer = 0;

		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (prime_check(sum)) {
						System.out.println("nums[i] = " + nums[i]);
						System.out.println("nums[j] = " + nums[j]);
						System.out.println("nums[k] = " + nums[k]);
						System.out.println("sum = " + sum);
						answer += 1;
					}
				}
			}

		}

		return answer;

	}

	public static boolean prime_check(int n) {
		boolean ans = true;
		if (n == 2) {
			return ans;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 7, 6, 4};
		System.out.println(solution(nums));
	}

}

class Solution_02 {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];

		int x1 = v[0][0];
		int y1 = v[0][1];
		int x2 = v[1][0];
		int y2 = v[1][1];
		int x3 = v[2][0];
		int y3 = v[2][1];

		if (x1 == x2) {
			answer[0] = x3;
		} else if (x1 == x3) {
			answer[0] = x2;
		} else {
			answer[0] = x1;
		}

		if (y1 == y2) {
			answer[1] = y3;
		} else if (y1 == y3) {
			answer[1] = y2;
		} else {
			answer[1] = y1;
		}

		return answer;
	}
}

class Solution_03 {
	public boolean solution(int[] arr) {

		Arrays.sort(arr);

		if (arr[arr.length - 1] == arr.length && arr[0] == 1) {
			return true;
		} else {
			return false;
		}

	}
}