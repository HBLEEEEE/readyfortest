package inputoutput;

//백준 : 정답 입력 양식

import java.util.Scanner;

//문제 : A+B
//url : https://softeer.ai/practice/info.do?idx=1&eid=362
class Solution_001 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String count = sc.nextLine();

		int cnt = Integer.parseInt(count);

		for (int i = 0; i < cnt; i++) {
			String input = sc.nextLine();
			String[] nums = input.split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			System.out.println("Case #" + (i + 1) + ": " + (a + b));
		}
	}
}

//문제 : 지우는 소수를 좋아해
//url : https://softeer.ai/practice/info.do?idx=1&eid=582
class Solution_input {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String GnR = sc.nextLine();

		int[] gyms = new int[Integer.parseInt(GnR.split(" ")[0])];
		int roads = Integer.parseInt(GnR.split(" ")[1]);

		for (int i = 0; i < roads; i++) {
			String temp = sc.nextLine();
			String[] GGL = temp.split(" ");
			int G1 = Integer.parseInt(GGL[0]);
			int G2 = Integer.parseInt(GGL[1]);
			int L = Integer.parseInt(GGL[2]);

			if (gyms[G1 - 1] == 0) {
				gyms[G1 - 1] = L;
			} else if (gyms[G1 - 1] > L) {
				gyms[G1 - 1] = L;
			}

			if (gyms[G2 - 1] == 0) {
				gyms[G2 - 1] = L;
			} else if (gyms[G2 - 1] > L) {
				gyms[G2 - 1] = L;
			}
		}

		int answer = gyms[0];
		for (int i = 1; i < gyms.length; i++) {
			if (gyms[i] > answer) {
				answer = gyms[i];
			}
		}

		while (!checkPrime(answer)) {
			answer++;
		}

		System.out.println(answer);

	}

	public static boolean checkPrime(int n) {
		if (n == 1) {
			return false;
		} else if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		int div = (int)Math.sqrt(n);
		for (int i = 3; i < div; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}
}