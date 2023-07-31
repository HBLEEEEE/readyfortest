package codetest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class tosstest {
}

class Solution {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];

		if (v[0][0] == v[1][0]) {
			answer[0] = v[2][0];
		} else if (v[1][0] == v[2][0]) {
			answer[0] = v[0][0];
		} else {
			answer[0] = v[1][0];
		}

		if (v[0][1] == v[1][1]) {
			answer[1] = v[2][1];
		} else if (v[1][1] == v[2][1]) {
			answer[1] = v[0][1];
		} else {
			answer[1] = v[1][1];
		}

		return answer;
	}
}

class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println(a);
	}
}

//멋쟁이 팬디지털
class Solution001 {
	public static int solution(String s, int N) {
		int answer = -1;

		all:
		for (int i = 0; i < s.length() - N + 1; i++) {
			String temp = "";

			boolean[] check = new boolean[N];

			System.out.println("시작지점 " + i + "번째 그리고 " + s.substring(i, i + 1));

			for (int j = i; j < i + N; j++) {
				int t = Integer.parseInt(s.substring(j, j + 1));
				System.out.println("t = " + t);
				if (t > N || t == 0) {
					System.out.println(" 여기서 탈출");
					continue all;
				}

				if (check[t - 1]) {
					System.out.println(" 저기서 탈출");
					continue all;
				} else {
					check[t - 1] = true;
				}

				temp += s.substring(j, j + 1);
			}
			System.out.println(" 돌긴 돌았네");

			System.out.println("tempans = " + temp);

			int tempans = Integer.parseInt(temp);

			if (answer < tempans) {
				answer = tempans;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("0", 1));
	}
}

//친구를 찾아줘
class Solution002 {
	public int solution(int[][] relationships, int target, int limit) {

		Set<Integer> firstRelation = new TreeSet<>();
		Set<Integer> secondRelation = new TreeSet<>();
		int[][] Other = new int[relationships.length][2];
		int idx = 0;

		for (int i = 0; i < relationships.length; i++) {
			if (relationships[i][0] == target) {
				firstRelation.add(relationships[i][1]);
			} else if (relationships[i][1] == target) {
				firstRelation.add(relationships[i][0]);
			} else {
				Other[idx] = relationships[i];
				idx++;
			}
		}

		System.out.println("firstRelation = " + firstRelation);
		System.out.println("Other = " + Arrays.deepToString(Other));

		for (int i = 0; i < limit - 1; i++) {

			for (int j = 0; j < idx; j++) {
				int a = Other[j][0];
				int b = Other[j][1];

				if (i == 0) {
					if (firstRelation.contains(a) && (!firstRelation.contains(b) && !secondRelation.contains(b))) {
						secondRelation.add(b);
					} else if (firstRelation.contains(b) && (!firstRelation.contains(a) && !secondRelation.contains(
						a))) {
						secondRelation.add(a);
					}
				} else {
					if (secondRelation.contains(a) && (!firstRelation.contains(b) && !secondRelation.contains(b))) {
						secondRelation.add(b);
					} else if (secondRelation.contains(b) && (!firstRelation.contains(a) && !secondRelation.contains(
						a))) {
						secondRelation.add(a);
					}
				}

				// if (firstRelation.contains(a)) {
				// 	if (!secondRelation.contains(b)) {
				// 		secondRelation.add(b);
				// 		continue;
				// 	}
				// }
				//
				// if (firstRelation.contains(b)) {
				// 	if (!secondRelation.contains(a)) {
				// 		secondRelation.add(a);
				// 		continue;
				// 	}
				// }
				//
				// if (i >= 1) {
				// 	if (secondRelation.contains(a)) {
				// 		if (!secondRelation.contains(b)) {
				// 			secondRelation.add(b);
				// 			continue;
				// 		}
				// 	}
				//
				// 	if (secondRelation.contains(b)) {
				// 		if (!secondRelation.contains(a)) {
				// 			secondRelation.contains(a);
				// 			continue;
				// 		}
				// 	}
				// }
			}
		}

		System.out.println("secondRelation = " + secondRelation);

		int answer = 5 * firstRelation.size() + 10 * secondRelation.size() + secondRelation.size();

		return answer;
	}
}

//유난한 초콜릿 도전
class Solution005 {
	public int solution(int A, int B, int C, int D, int N, int[][] Chips) {
		// 케이크: A cm x B cm
		// 직사각형 틀: C cm x D cm
		// 초콜릿 칩: N개
		// 초콜릿 칩의 좌표 xn, yn: (Chips[n-1][0], Chips[n-1][1])
		int answer = 0;
		return answer;
	}
}

























