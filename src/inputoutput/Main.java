package inputoutput;

//백준 : 정답 입력 양식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
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

//문제 : 금고털이
//url : https://softeer.ai/app/assessment/index.html?xid=40350&xsrfToken=5HluQuHCwmSQbuWZFT0EDtBdDgs3xaYc&testType=practice
class Solution_005 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int W = Integer.parseInt(str.split(" ")[0]);
		int N = Integer.parseInt(str.split(" ")[1]);

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String jp = sc.nextLine();
			list.add(new int[] {Integer.parseInt(jp.split(" ")[0]), Integer.parseInt(jp.split(" ")[1])});
		}

		Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);

		int ans = 0;
		for (int[] i : list) {
			if (W > i[0]) {
				ans += i[0] * i[1];
				W -= i[0];
			} else {
				ans += W * i[1];
				break;
			}
		}

		System.out.println(ans);
	}
}

//문제 : 징검다리
//url : https://softeer.ai/app/assessment/index.html?xid=40521&xsrfToken=UDV8ATtlN2np1ohmCNcR7UGtEdQ8eV5f&testType=practice
class Solution_006 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		int[] stones = new int[N];
		String ss = sc.nextLine();
		String[] sts = ss.split(" ");
		for (int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(sts[i]);
		}

		System.out.println(Arrays.toString(stones));

		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (stones[i] > stones[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}

//문제 : 수퍼바이러스
//url : https://softeer.ai/app/assessment/index.html?xid=41873&xsrfToken=KIp30fstMqxZJhLEY2aCwoABtujykkQ4&testType=practice
class Solution_007 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long k = Long.parseLong(st.nextToken());
		long p = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());

		n *= 10;

		long res = recursion(p, n);

		System.out.println(k * res % 1000000007);
	}

	public static long recursion(long p, long n) {
		if (n == 1) {
			return p;
		}

		long cur = recursion(p, n / 2);
		if (n % 2 == 1) {
			return (cur * cur % 1000000007) * p % 1000000007;
		} else {
			return cur * cur % 1000000007;
		}
	}
}

//문제 : 강의실 배정
//url : https://softeer.ai/app/assessment/index.html?xid=41994&xsrfToken=iT39FnTf68ToHTsCZ50XS2L7TDyrJomD&testType=practice
class Solution_008 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] lessons = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			lessons[i][0] = Integer.parseInt(s.nextToken());
			lessons[i][1] = Integer.parseInt(s.nextToken());
		}

		Arrays.sort(lessons, (a, b) -> a[1] - b[1]);

		int ans = 0;
		int s = 0;

		for (int[] i : lessons) {
			if (i[0] >= s) {
				s = i[1];
				ans++;
			}
		}

		System.out.println(ans);

	}
}

//문제 : 우물 안 개구리
//url : https://softeer.ai/app/assessment/index.html?xid=42180&xsrfToken=aYXOve5Nj6tsITwIVYfFB0fr7ITRylif&testType=practice
class Solution_009 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] Wn = new int[N];
		StringTokenizer ws = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Wn[i] = Integer.parseInt(ws.nextToken());
		}

		String as = "name";

		int[][] Mn = new int[M][2];

		for (int i = 0; i < M; i++) {
			StringTokenizer ms = new StringTokenizer(br.readLine());
			Mn[i][0] = Integer.parseInt(ms.nextToken());
			Mn[i][1] = Integer.parseInt(ms.nextToken());
		}

		boolean[] frog = new boolean[N];
		Arrays.fill(frog, true);

		for (int i = 0; i < M; i++) {
			if (Wn[Mn[i][0] - 1] > Wn[Mn[i][1] - 1]) {
				frog[Mn[i][1] - 1] = false;
			} else if (Wn[Mn[i][0] - 1] < Wn[Mn[i][1] - 1]) {
				frog[Mn[i][0] - 1] = false;
			} else {
				frog[Mn[i][0] - 1] = false;
				frog[Mn[i][1] - 1] = false;
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (frog[i]) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}

//문제 : 징검다리 2
//url : https://softeer.ai/app/assessment/index.html?xid=44699&xsrfToken=a5U0pG3hx0csJ26mNyxSaDTZ900rDLKe&testType=practice
class Solution_010 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] stones = new int[N];

		StringTokenizer ss = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(ss.nextToken());
		}

		System.out.println("N = " + N);
		System.out.println("stones = " + Arrays.toString(stones));

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int total;
			int lowMax = 0;
			int highMax = 0;

			int[] lowS = new int[i + 1];
			Arrays.fill(lowS, 1);
			for (int j = 0; j <= i; j++) {
				for (int k = 0; k <= j; k++) {
					if (stones[j] > stones[k]) {
						lowS[j] = Math.max(lowS[j], lowS[k] + 1);
					}
				}
			}

			int[] highS = new int[N - i];
			Arrays.fill(highS, 1);
			for (int j = i; j < N; j++) {
				for (int k = i; k <= j; k++) {
					if (stones[j] < stones[k]) {
						highS[j - i] = Math.max(highS[j - i], highS[k - i] + 1);
					}
				}
			}

			for (int j = 0; j < lowS.length; j++) {
				lowMax = Math.max(lowMax, lowS[j]);
			}
			for (int j = 0; j < highS.length; j++) {
				highMax = Math.max(highMax, highS[j]);
			}

			total = lowMax + highMax - 1;
			System.out.println("lowMax = " + lowMax);
			System.out.println("highMax = " + highMax);
			System.out.println("total = " + total);
			ans = Math.max(ans, total);

		}

		System.out.println(ans);
	}
}

//문제 : 스마트 물류
//url : https://softeer.ai/app/assessment/index.html?xid=45049&xsrfToken=iTWANBZxSqaPwZuVMHRtwWk1XQL8eyTO&testType=practice
class Solution_011 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		StringTokenizer hp = new StringTokenizer(br.readLine());
		String d = hp.nextToken();
		int[] parts = new int[N];
		for (int i = 0; i < d.length(); i++) {
			if (d.charAt(i) == 'P') {
				parts[i] = 1;
			}
		}

		int ans = 0;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i] == 0) {
				for (int j = -K; j <= K; j++) {
					if ((j == 0) || (i + j < 0) || (i + j >= N)) {
						continue;
					}
					if (parts[i + j] == 1) {
						parts[i + j] = 3;
						ans++;
						break;
					}
				}
			}
		}

		System.out.println(ans);

	}
}











