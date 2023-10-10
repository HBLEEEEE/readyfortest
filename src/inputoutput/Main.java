package inputoutput;

//백준 : 정답 입력 양식

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
class Solution_002 {
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

//문제 : 출퇴근길
//url : https://softeer.ai/practice/info.do?idx=1&eid=1529
class Solution_003 {

	static boolean[] checked;
	static int[][] direction;
	static int home;
	static int company;
	static Set<Integer> goC = new TreeSet<>();
	static Set<Integer> goH = new TreeSet<>();

	static boolean[] visited;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String pointAndway = sc.nextLine();

		int points = Integer.parseInt(pointAndway.split(" ")[0]);
		int ways = Integer.parseInt(pointAndway.split(" ")[1]);

		direction = new int[ways][2];
		for (int i = 0; i < ways; i++) {
			String temp = sc.nextLine();
			direction[i][0] = Integer.parseInt(temp.split(" ")[0]);
			direction[i][1] = Integer.parseInt(temp.split(" ")[1]);
		}

		String HandC = sc.nextLine();
		home = Integer.parseInt(HandC.split(" ")[0]);
		company = Integer.parseInt(HandC.split(" ")[1]);

		checked = new boolean[ways];
		visited = new boolean[points];
		for (int i = 0; i < ways; i++) {
			if (direction[i][0] == home) {
				checked[i] = true;
				bfs(goC, company, direction[i][1]);
				checked[i] = false;
			}
		}

		for (int i = 0; i < ways; i++) {
			if (direction[i][0] == company) {
				checked[i] = true;
				bfs(goH, home, direction[i][1]);
				checked[i] = false;
			}
		}

		int ans = 0;
		for (int i = 1; i < points + 1; i++) {
			if (i == home || i == company) {
				continue;
			}
			if (goC.contains(i) && goH.contains(i)) {
				ans++;
			}
		}

		System.out.println(ans);

	}

	public static void bfs(Set<Integer> set, int endpoint, int nowpoint) {
		for (int i = 0; i < checked.length; i++) {
			if (checked[i]) {
				continue;
			}
			if (direction[i][0] == nowpoint) {
				if (direction[i][1] == endpoint) {
					break;
				}
			} else {
				checked[i] = true;
				visited[direction[i][1]] = true;
				bfs(set, endpoint, direction[i][1]);
				visited[direction[i][1]] = false;
				checked[i] = false;
			}
		}
	}
}

//문제 : 염기서열 커버
//url : https://softeer.ai/practice/formCodeEditor.do
class Solution_004 {
	public static void main(String args[]) {
		int ans = 1;

		Scanner sc = new Scanner(System.in);
		String GnL = sc.nextLine();
		Map<String, List<Integer>> map = new HashMap<>();

		int genes = Integer.parseInt(GnL.split(" ")[0]);
		int len = Integer.parseInt(GnL.split(" ")[1]);

		if (genes == 1) {
			System.out.println(ans);
			return;
		}

		String[] bio = new String[genes];

		for (int i = 0; i < genes; i++) {
			String gen = sc.nextLine();
			bio[i] = gen;
		}

		for (int i = 0; i < genes; i++) {
			for (int j = 0; j < len; j++) {
				if (bio[i].charAt(j) != '.') {
					String key = i + Character.toString(bio[i].charAt(j));
					if (map.containsKey(key)) {
						map.get(key).add(i);
					} else {
						List<Integer> store = new ArrayList<>();
						store.add(i);
						map.put(key, store);
					}
				}
			}
		}

		Set<String> keys = map.keySet();

		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next();
			if (map.get(temp).size() != 1) {
				
			}
		}

		System.out.println(ans);
	}
}







