package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

//문제 : 피보나치 수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12945
class Solution_0001 {
	public int solution(int n) {
		int answer = 0;
		answer = Fibonacci(n);

		return answer;
	}

	public int Fibonacci(int n) {
		int[] D = new int[n + 1];
		D[0] = 0;
		D[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			D[i] = (D[i - 1] + D[i - 2]) % 1234567;
		}
		return D[n];
	}

	public int Fibo(int n) {
		double sf = Math.sqrt(5);
		int ans = (int)(((Math.pow((1 + sf), n) - Math.pow((1 - sf), n)) / (Math.pow(2, n) * sf)) % 1234567);
		return ans;
	}

	public double dFibo(int n) {
		double sf = Math.sqrt(5);
		double ans = ((Math.pow((1 + sf), n) - Math.pow((1 - sf), n)) / (Math.pow(2, n) * sf));
		return ans;
	}
}

//문제 : 카펫
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42842
class Solution_0002 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int width;
		int hight;

		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				width = yellow / i;
				hight = yellow / width;
				if ((width + hight) * 2 + 4 == brown) {
					answer[0] = width + 2;
					answer[1] = hight + 2;
					break;
				}
			}
		}
		return answer;
	}
}

//문제 : 올바른 괄호
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12909
//import java.util.Arrays;
//        import java.util.Iterator;
//        import java.util.LinkedList;
//        import java.util.Queue;
class Solution_0003 {
	//    boolean solution(String s) {
	//        boolean answer = true;
	//        String[] str = s.split("");
	//        System.out.println(Arrays.toString(str));
	//        Queue que = new LinkedList(Arrays.asList(str));
	//        Iterator iter = que.iterator();
	//
	//        int cnt = 0;
	//        while (iter.hasNext()){
	//            System.out.println(iter.next());
	//            if (iter.next().equals("(")){
	//                cnt +=1;
	//            }else {
	//                cnt -=1;
	//            }
	//        }
	//
	//        if (cnt>0){
	//            answer = false;
	//        }
	//
	//
	//        return answer;
	//    }
	boolean solution(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				cnt += 1;
			} else {
				cnt -= 1;
			}
			if (cnt < 0) {
				return false;
			}
		}

		if (cnt > 0) {
			return false;
		}

		return true;
	}

}

//문제 : 멀리 뛰기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12914

class Solution_0004 {
	public long solution(int n) {
		return count_now(n);
	}

	public long count_now(long n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		return count_now(n - 1) + count_now(n - 2);
	}
}

class Solution_0004_1 {
	public static long solution(int n) {
		if (n == 1) {
			return 1;
		}

		long[] arr = new long[n];
		arr[0] = 1;
		arr[1] = 2;

		for (int i = 2; i < n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}

		return arr[n - 1];
	}
}

//문제 : 괄호 회전하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/76502

class Solution_0005 {
	public static int solution(String s) {
		int answer = 0;
		int len = s.length();
		String k = s + s;
		for (int i = 0; i < len; i++) {
			System.out.println(k.substring(i, i + s.length()));
			if (CheckPossible(k.substring(i, i + s.length()))) {
				answer += 1;
			}
		}
		return answer;
	}

	public static boolean CheckPossible(String s) {
		char now;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			now = s.charAt(i);
			if (res.length() == 0 && (now == ']' || now == '}' || now == ')')) {
				return false;
			}
			switch (now) {
				case '[':
					res += '[';
					break;
				case ']':
					if (res.charAt(res.length() - 1) == '[') {
						res = res.substring(0, res.length() - 1);
					} else {
						return false;
					}
					break;
				case '{':
					res += '{';
					break;
				case '}':
					if (res.charAt(res.length() - 1) == '{') {
						res = res.substring(0, res.length() - 1);
					} else {
						return false;
					}
					break;
				case '(':
					res += '(';
					break;
				case ')':
					if (res.charAt(res.length() - 1) == '(') {
						res = res.substring(0, res.length() - 1);
					} else {
						return false;
					}
					break;
			}
		}
		if (res.length() != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution("}]()[{"));
	}
}

//문제 : [1차 캐시]
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17680
//import java.util.List;
//import java.util.ArrayList;
class Solution_0006 {
	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return 5 * cities.length;
		}

		int answer = 0;
		List<String> cashlist = new ArrayList<>(cacheSize);
		String now = "";
		for (int i = 0; i < cities.length; i++) {
			now = cities[i].toLowerCase();
			if (cashlist.contains(now)) {
				answer += 1;
				cashlist.remove(now);
				cashlist.add(now);
			} else {
				answer += 5;
				if (cashlist.size() >= cacheSize) {
					cashlist.remove(0);
				}
				cashlist.add(now);
			}
			System.out.println(i + "번째 : " + now);
			System.out.println("answer : " + answer);

		}
		return answer;
	}

	public static void main(String[] args) {
		String[] strs = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(0, strs));
	}

}

//문제 : 행렬의 곱셈
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12949
//import java.util.List;
//import java.util.ArrayList;
class Solution_0007 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr2.length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}

		}

		return answer;
	}
}

//문제 : [1차] 뉴스 클러스터링
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17677
//import java.util.List;
//import java.util.ArrayList;
class Solution_0008 {
	public static int solution(String str1, String str2) {

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> totallist = new ArrayList<>();

		String temp = "";
		for (int i = 0; i < str1.length() - 1; i++) {
			temp = str1.substring(i, i + 2);
			if (temp.matches("^[a-z]*$")) {
				list1.add(temp);
				totallist.add(temp);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			temp = str2.substring(i, i + 2);
			if (temp.matches("^[a-z]*$")) {
				list2.add(temp);
				totallist.add(temp);
			}
		}

		if (list1.size() == 0 && list2.size() == 0) {
			return 65536;
		} else if (list1.size() == 0 && list2.size() > 0) {
			return 0;
		} else if (list2.size() == 0 && list1.size() > 0) {
			return 0;
		}

		int A = list1.size();
		int B = list2.size();

		for (String i : list1) {
			if (list2.contains(i)) {
				list2.remove(i);
				totallist.remove(i);
			}
		}

		int ApB = totallist.size();
		int AmB = A + B - ApB;

		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
		System.out.println("totallist = " + totallist);
		System.out.println(ApB);
		System.out.println(AmB);

		return (int)(AmB / (double)ApB * 65536);
	}

	public static void main(String[] args) {
		String str1 = "AAA AAAA";
		String str2 = "aaa aaa";

		System.out.println(solution(str1, str2));
	}
}

//문제 : 튜플
//url : https://school.programmers.co.kr/learn/courses/30/lessons/64065

class Solution_0009 {
	public List<Integer> solution(String s) {
		List<List<Integer>> arr = new ArrayList<>();

		List<Integer> temparrr = new ArrayList<>();
		String temp = "";
		String[] all = s.substring(2, s.length() - 2).split("},\\{");
		List<Integer> sizes = new ArrayList<>();

		for (String now : all) {
			//            System.out.println("now : " + now);
			for (int i = 0; i < now.length() + 1; i++) {
				//                System.out.println(i + " : "+temp);
				if (i == now.length()) {
					temparrr.add(Integer.parseInt(temp));
					temp = "";
				} else if (now.charAt(i) == ',') {
					temparrr.add(Integer.parseInt(temp));
					temp = "";
				} else {
					temp += now.charAt(i);
				}
			}
			arr.add(temparrr);
			sizes.add(temparrr.size());
			temparrr = new ArrayList<>();
		}

		for (List i : arr) {
			System.out.print(i.size() + " : ");
			System.out.println(i);
		}
		System.out.println(arr.size());
		System.out.println(sizes);

		List<Integer> res = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < sizes.size(); i++) {
			for (int a : arr.get(sizes.indexOf(i + 1))) {
				if (!res.contains(a)) {
					res.add(a);
				}
			}
		}
		System.out.println(res);

		return res;
	}

	//한수 배워야할 풀이법!
	public static int[] solution_01(String s) {
		Set<String> set = new HashSet<>();
		String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, (a, b) -> {
			return a.length() - b.length();
		});

		System.out.println(Arrays.toString(arr));
		int[] answer = new int[arr.length];
		int idx = 0;
		for (String s1 : arr) {
			for (String s2 : s1.split(",")) {
				if (set.add(s2))
					answer[idx++] = Integer.parseInt(s2);
			}
		}

		return answer;
	}
}

//문제 : 기능개발
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42586
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Stack;
class Solution_0010 {
	public List<Integer> solution(int[] progresses, int[] speeds) {

		Stack<Integer[]> stack = new Stack<>();
		for (int i = progresses.length - 1; i >= 0; i--) {
			stack.push(new Integer[] {progresses[i], speeds[i]});
		}

		int cnt = 0;
		int tempres = 0;
		List<Integer> res = new ArrayList<>();
		while (!stack.empty()) {
			if (stack.peek()[0] + cnt * stack.peek()[1] >= 100) {
				stack.pop();
				tempres += 1;
			} else {
				cnt++;
				if (tempres > 0) {
					res.add(tempres);

					tempres = 0;
				}
			}
		}
		res.add(tempres);

		return res;
	}

}

//문제 : 귤 고르기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/138476
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Stack;
class Solution_0011 {
	public static int solution(int k, int[] tangerine) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : tangerine) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		System.out.println(map);
		System.out.println(map.values());

		Collection<Integer> arr = map.values();
		Integer[] qqq = arr.toArray(new Integer[0]);
		Arrays.sort(qqq);
		System.out.println(Arrays.toString(qqq));
		for (int i = qqq.length - 1; i >= 0; i--) {
			k -= qqq[i];
			answer += 1;
			if (k <= 0) {
				return answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int k = 6;
		int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
		solution(k, arr);
	}

}

//문제 : n진수 게임
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17687

class Solution_0012 {
	public static String solution(int n, int t, int m, int p) {
		String answer = "";

		int max_number = 0;
		int cnt = 1;
		int total_need = 0;
		//        int mt = m*t;

		//N진법으로 변화시켜야할 숫자들 중 최대 숫자 = max_number
		all:
		while (true) {
			for (int i = 0; i < Math.pow(n, cnt); i++) {
				max_number += 1;
				total_need += cnt;
				if (total_need >= m * t) {
					break all;
				}
			}
			cnt += 1;
		}

		String fullnums = "";
		//max_number까지 n진법으로 변화시키고 쭉 이어버리기
		for (int i = 0; i < max_number + 1; i++) {
			fullnums += ChangeToNstep(n, i);
		}

		//다 이어붙인 fullnums에서 필요한 위치만 가져다 붙이기
		for (int i = 0; i < t; i++) {
			answer += fullnums.charAt(p - 1 + m * i);
		}

		return answer;
	}

	public static String ChangeToNstep(int n, int number) {
		String res = "";
		String[] overten = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"A", "B", "C", "D", "E", "F"};
		if (number == 0) {
			return "0";
		}

		while (number > 0) {

			res += overten[number % n];
			number /= n;
		}

		String res2 = new StringBuilder(res).reverse().toString();

		return res2;
	}

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		System.out.println(solution(16, 988, 50, 24));
		long afterTime = System.currentTimeMillis();
		long msDiffTime = afterTime - beforeTime;
		System.out.println("msDiffTime = " + msDiffTime);
	}

}

//문제 : 전화번호 목록
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42577

class Solution_0013 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		TreeSet<String> nums = new TreeSet<>();
		for (String i : phone_book) {
			i = i.replaceAll(" ", "");
			nums.add(i);
		}
		Iterator<String> iter = nums.iterator();

		String before = iter.next();
		String now = "";
		while (iter.hasNext()) {
			now = iter.next();
			//방법1-------
			//            if (before.length()>=now.length()){
			//                before = now;
			//                continue;
			//            }
			//            if (before.equals(now.substring(0,before.length()))){
			//                return false;
			//            }else {
			//                before = now;
			//            }
			//방법1-------

			//방법2------들쑥 날 쑥 하지만 2번이 코드도 간결하고 빠를 때가 있다.
			if (now.startsWith(before)) {
				return false;
			} else {
				before = now;
			}
			//방법2-------
		}
		return answer;
	}
}

//문제 : [3차] 압축
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17684

class Solution_0014 {
	public static int[] solution(String msg) {

		HashMap<String, Integer> dictionary = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			char alphabet = (char)('A' + i);
			dictionary.put(Character.toString(alphabet), i + 1);
		}

		int alphabetNumber = 27;
		int count = 1;
		int temp = 0;
		String tempWord = "";
		List<Integer> arr = new ArrayList<>();

		while (msg.length() > 0) {
			tempWord = msg.substring(0, count);
			System.out.println(tempWord);

			if (dictionary.containsKey(tempWord)) {
				System.out.println("이게있네");
				temp = dictionary.get(tempWord);
				count += 1;
			} else {
				System.out.println("이게없네");
				dictionary.put(tempWord, alphabetNumber++);
				arr.add(temp);
				msg = msg.substring(count - 1);
				count = 1;
			}

			if (count > msg.length()) {
				arr.add(temp);
				break;
			}
		}

		int[] answer = arr.stream().mapToInt(i -> i).toArray();

		return answer;
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));

	}

}

//문제 : 더 맵게
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42626
class Solution_0015 {
	public static int solution(int[] scoville, int K) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		Iterator iter = priorityQueue.iterator();

		Arrays.sort(scoville);

		for (int i : scoville) {
			priorityQueue.add(i);
		}
		int count = 0;
		int temp1 = 0;
		int temp2 = 0;

		while (iter.hasNext()) {
			temp1 = priorityQueue.poll();
			System.out.println(temp1);
			if (temp1 >= K) {
				break;
			}
			if (!iter.hasNext()) {
				return -1;
			}
			temp2 = priorityQueue.poll();
			priorityQueue.add(temp1 + temp2 * 2);
			count++;

		}
		return count;

	}

	public static void main(String[] args) {

		int[] sc = {1, 2, 3, 4, 5, 6, 79, 10, 12};
		System.out.println(solution(sc, 7));
	}
}

//문제 : 오픈 채팅방
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42888
class Solution_0016 {
	public String[] solution(String[] record) {
		String[] answer = new String[record.length];

		//아이디와 닉네임
		HashMap<String, String> idnickMap = new HashMap<>();

		String[] temp;
		String[][] talks = new String[record.length][2];
		for (int i = 0; i < record.length; i++) {
			temp = record[i].split(" ");
			talks[i][0] = temp[0]; // 행동
			talks[i][1] = temp[1]; // 유저 아이디
			if (temp.length == 3) {
				idnickMap.put(temp[1], temp[2]); // 유저 닉네임
			}
		}

		int cnt = 0;
		for (int i = 0; i < talks.length; i++) {
			if (talks[i][0].equals("Enter")) {
				answer[cnt] = idnickMap.get(talks[i][1]) + "님이 들어왔습니다.";
				cnt++;
			} else if (talks[i][0].equals("Leave")) {
				answer[cnt] = idnickMap.get(talks[i][1]) + "님이 나갔습니다.";
				cnt++;
			} else {
			}
		}

		answer = Arrays.copyOfRange(answer, 0, cnt);

		for (String i : answer) {
			System.out.println(i);
		}

		return answer;
	}

}

//문제 : 유사 칸토어 비트열
//url : https://school.programmers.co.kr/learn/courses/30/lessons/148652
class Solution_0017 {
	public static int solution(int n, long l, long r) {
		int answer = 0;

		long position_l = l % 5;
		long position_r = r % 5 + (r / 5 - l / 5);

		long[][] divides = new long[n + 1][2];
		divides[n][0] = l;
		divides[n][1] = r;

		for (int i = n; i >= 1; i--) {
			divides[i - 1][0] = divides[i][0] / 5;
			divides[i - 1][1] = divides[i][1] / 5;
		}

		System.out.println(Arrays.deepToString(divides));

		return answer;
	}

	//    public static void main(String[] args) {
	//        System.out.println(solution(4,48,133));
	//    }

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = {1, 2, 5, 2, 3, 4, 4, 4, 4, 4, 3, 3, 2, 2, 1};

		for (int i : arr) {
			System.out.println(i);
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		System.out.println(map);
	}
}

//문제 : 최솟값 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12941
class Solution_0018 {
	public int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[A.length - 1 - i];
		}

		return answer;
	}
}

//문제 : 구명보트
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42885
class Solution_0019 {
	public static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int l = 0;
		int r = people.length - 1;

		while (l < r) {
			int sum = people[l] + people[r];
			if (sum > limit) {
				r--;
			} else {
				l++;
				r--;
			}
			answer++;
		}
		if (l == r) {
			answer++;
		}

		//최대 2명인거 안보고 삽질한 코드들...
		//
		// for (int i : people) {
		// 	list.add(i);
		// }
		//
		// //순서
		// //max 가져온다> limit-max = x 가 있는지 본다.-> x보다 작은 수 중에 또 0이 되는게 있는지 본다 > 가장 작은 수 까지 가서 없으면 끝
		//
		// while (list.size() > 0) {
		// 	System.out.println("사이클 시작");
		// 	System.out.println("list = " + list);
		// 	if (list.size() == 1) {
		// 		answer += 1;
		// 		break;
		// 	}
		// 	int min = list.get(0);
		// 	int total = list.get(list.size() - 1);
		// 	list.remove(list.size() - 1);
		// 	int idx = list.size() - 1;
		// 	System.out.println("total = " + total);
		// 	while (idx >= 0) {
		// 		if (total + min > limit) {
		// 			break;
		// 		} else if (total + min == limit) {
		// 			list.remove(0);
		// 			break;
		// 		}
		// 		if (total + list.get(idx) < limit) {
		// 			total += list.get(idx);
		// 			list.remove(idx);
		// 		} else if (total + list.get(idx) == limit) {
		// 			list.remove(idx);
		// 			break;
		// 		}
		// 		idx -= 1;
		// 	}
		// 	answer += 1;
		// }

		return answer;
	}

	public static void main(String[] args) {
		int[] poeple = {1, 3, 5, 7, 4, 9, 12, 11};
		System.out.println("정답은" + solution(poeple, 13));

	}
}

//문제 : 구명보트
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42885
class Solution_0020 {
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<Integer> stack = new Stack<>();
		for (int i = prices.length - 1; i >= 0; i--) {
			stack.push(prices[i]);
		}

		Stack<Integer> substack = new Stack<>();

		int num;
		int now = 0;
		int cnt;
		int idx = 0;

		while (!stack.isEmpty()) {
			cnt = 1;
			num = stack.pop();
			System.out.println("num = " + num);
			while (!stack.isEmpty()) {
				now = stack.pop();
				substack.push(now);
				System.out.println("now = " + now);
				if (num <= now) {
					cnt++;
				} else {
					break;
				}
			}

			if (stack.isEmpty() && num <= now) {
				cnt--;
			}
			// System.out.println("substack.size() = " + substack.size());
			// while (!substack.isEmpty()) {
			// 	System.out.println("짜잔");
			// 	stack.push(substack.pop());
			// }

			System.out.println("substack.size() = " + substack.size());
			int len = substack.size();
			for (int i = 0; i < len; i++) {
				System.out.println("짜잔");
				stack.push(substack.pop());
			}

			answer[idx] = cnt;
			idx++;
		}

		return answer;
	}

	public int[] othersol(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		int i, j;
		for (i = 0; i < len; i++) {
			for (j = i + 1; j < len; j++) {
				answer[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}
		return answer;
	}

}

//문제 : [1차] 프렌즈4블록
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17679

// import java.util.ArrayList;
// import java.util.List;
class Solution_0021 {
	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		List<List<String>> game = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			List<String> temp = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				temp.add(String.valueOf(board[m - j - 1].charAt(i)));
			}
			game.add(temp);
		}

		for (int i = 0; i < game.size(); i++) {
			System.out.println(game.get(i));
		}

		//Z는 삭제 예정, 공백은 X

		while (true) {
			System.out.println("시작~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			int cnt = 0;

			List<List<String>> tempgame = new ArrayList<>();
			for (int i = 0; i < game.size(); i++) {
				tempgame.add(new ArrayList<>(game.get(i)));
			}

			for (int i = 0; i < game.size() - 1; i++) {
				if (game.get(i).size() == 0) {
					continue;
				}
				int len;
				if (game.get(i).size() > game.get(i + 1).size()) {
					len = game.get(i + 1).size();
				} else {
					len = game.get(i).size();
				}
				for (int j = 0; j < len - 1; j++) {
					if (game.get(i).get(j).equals(game.get(i + 1).get(j)) && game.get(i)
						.get(j)
						.equals(game.get(i).get(j + 1))
						&& game.get(i).get(j).equals(game.get(i + 1).get(j + 1))) {
						tempgame.get(i).set(j, "a");
						tempgame.get(i).set(j + 1, "a");
						tempgame.get(i + 1).set(j, "a");
						tempgame.get(i + 1).set(j + 1, "a");
					}
				}
			}

			System.out.println("a는 몇개~");
			for (int i = 0; i < tempgame.size(); i++) {
				System.out.println(tempgame.get(i));
			}
			for (int i = 0; i < game.size(); i++) {
				System.out.println(game.get(i));
			}

			for (int i = 0; i < tempgame.size(); i++) {
				for (int j = tempgame.get(i).size() - 1; j >= 0; j--) {
					if (tempgame.get(i).get(j).equals("a")) {
						cnt++;
						tempgame.get(i).remove(j);
					}
				}
			}

			if (cnt == 0) {
				break;
			}

			answer += cnt;

			game = List.copyOf(tempgame);

			System.out.println("중간 점검");
			for (int i = 0; i < game.size(); i++) {
				System.out.println(game.get(i));
			}

		}

		return answer;

	}

	public static void main(String[] args) {
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

		System.out.println(solution(2, 3, board));

	}
}

//문제 : 영어 끝말잇기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12981

// import java.util.ArrayList;
// import java.util.List;
class Solution_0022 {
	public static int[] solution(int n, String[] words) {

		List<String> dan = new ArrayList<>();
		for (String i : words) {
			dan.add(i);
		}

		int fastcase = dan.size();
		int fine = dan.size();
		int i = 0;
		String temp = "";

		while (dan.size() > 1) {
			System.out.println("i = " + i);
			System.out.println("fastcase = " + fastcase);
			System.out.println("dan = " + dan);
			System.out.println("dan.get(0) = " + dan.get(0));
			System.out.println("dan.get(1) = " + dan.get(1));
			// System.out.println("dan.get(0)의끝 = " + dan.get(0).charAt(dan.get(0).length() - 1));
			// System.out.println("dan.get(1)의 시작 = " + dan.get(1).charAt(0));
			if (dan.get(0).charAt(dan.get(0).length() - 1) != dan.get(1).charAt(0)) {
				System.out.println("마지막 몰라서 빠져나옴");
				fastcase = i + 1;
				break;
			}
			temp = dan.get(0);
			dan.remove(0);
			if (dan.contains(temp)) {
				if ((dan.indexOf(temp) + i) < fastcase) {
					fastcase = dan.indexOf(temp) + i + 1;
				}
			}
			i++;
			if (i >= fastcase) {
				System.out.println("같거나 크면 빠져나옴");
				break;
			}
		}
		if (fastcase == fine) {
			return new int[] {0, 0};
		}

		System.out.println("fastcase = " + fastcase);

		int who = (fastcase + 1) % n;
		int turn = (fastcase + 1) / n + 1;
		if (who == 0) {
			who = n;
			turn -= 1;
		}

		int[] answer = new int[] {who, turn};

		return answer;
	}

	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(Arrays.toString(solution(3, words)));
	}

}

//문제 : 게임 맵 최단거리
//url : https://school.programmers.co.kr/learn/courses/30/lessons/1844
//참조 url : https://tmdrl5779.tistory.com/216

// import java.util.ArrayList;
// import java.util.List;
class Solution_0023 {
	public static int solution(int[][] maps) {
		int answer = 0;

		int[][] ansmap = new int[maps.length][maps[0].length];
		bfs(maps, ansmap);
		System.out.println(Arrays.deepToString(ansmap));
		answer = ansmap[maps.length - 1][maps[0].length - 1];

		if (answer == 0) {
			answer = -1;
		}
		return answer;
	}

	public static void bfs(int[][] maps, int[][] ansmap) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		int x = 0;
		int y = 0;
		ansmap[x][y] = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] current = queue.remove();
			int cX = current[0];
			int cY = current[1];

			for (int i = 0; i < 4; i++) {
				int nX = cX + dx[i];
				int nY = cY + dy[i];

				if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
					continue;
				}

				if (ansmap[nX][nY] == 0 && maps[nX][nY] == 1) {
					ansmap[nX][nY] = ansmap[cX][cY] + 1;
					queue.add(new int[] {nX, nY});
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] maps = new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}};
		System.out.println(solution(maps));
	}

}

//문제 : 예상 대진표
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12985
class Solution_0024 {
	public static int solution(int n, int a, int b) {
		int answer = 1;

		if (n == 2) {
			answer = 1;
		}

		int cnt = 2;
		while (n > cnt) {
			System.out.println("스텝");
			if ((a - 1) / (n / cnt) != (b - 1) / (n / cnt)) {
				answer = (int)(Math.log(n / cnt * 2) / Math.log(2));
				break;
			} else {
				cnt *= 2;
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(32, 1, 2));
	}
}

//문제 : 피로도
//url : https://school.programmers.co.kr/learn/courses/30/lessons/87946

// import java.util.ArrayList;
// import java.util.List;
class Solution_0025 {
	static boolean[] checked;
	static int cnt = 0;

	public int solution(int k, int[][] dungeons) {

		checked = new boolean[dungeons.length];
		dfs(0, k, dungeons);
		return cnt;
	}

	public void dfs(int depth, int fatigue, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (checked[i] || dungeons[i][0] > fatigue) {
				continue;
			}
			checked[i] = true;
			dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
			checked[i] = false;
		}

		cnt = Math.max(cnt, depth);
	}

	public static void main(String[] args) {

		String text = "ab";
		for (int i = 0; i < text.length(); i++) {
			for (int j = i + 1; j < text.length() + 1; j++) {
				String temp = text.substring(i, j);
				System.out.println(temp);
			}
		}

	}

}




























