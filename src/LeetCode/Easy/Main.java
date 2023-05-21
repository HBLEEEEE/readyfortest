package LeetCode.Easy;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

//url : https://leetcode.com/problems/valid-parentheses/
//title : 20. Valid Parentheses
class Solution0020 {
	public static boolean isValid(String s) {

		if (s.length() < 2 || s.length() % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);

			if (now == '[' || now == '{' || now == '(') {
				stack.push(now);
			} else if (now == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (now == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (now == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}

//url : https://leetcode.com/problems/longest-substring-without-repeating-characters/
//title : 3. Longest Substring Without Repeating Characters
class Solution0003 {
	public static int lengthOfLongestSubstring(String s) {
		int answer = 0;
		int len = 0;
		Set<Character> strset = new TreeSet<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				strset.add(s.charAt(j));
				if (strset.size() == len) {
					break;
				}
				len++;
			}
			answer = Math.max(answer, len);
			len = 0;
			strset.clear();
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}

//url : https://leetcode.com/problems/longest-palindromic-substring/
//title : 5. Longest Palindromic Substring
class Solution0005 {
	public static String longestPalindrome(String s) {

		char[] w = new char[s.length()];

		for (int i = 0; i < s.length(); i++) {
			w[i] = s.charAt(i);

		}

		int len = w.length;
		String answer = s.substring(0, 1);
		int answerlen = 1;
		int cnt;
		int left;
		int right;

		//AA케이스
		for (int i = 0; i < w.length - 1; i++) {
			//AA case;
			if (w[i] == w[i + 1]) {
				cnt = 1;
				left = i - 1;
				right = i + 2;
				while (left >= 0 && right < len) {
					if (w[left] != w[right]) {
						break;
					}
					cnt++;
					left -= 1;
					right += 1;
				}
				if (answerlen < (cnt * 2 + 2)) {
					answerlen = cnt * 2 + 2;
					answer = s.substring(left + 1, right);
				}
			}
		}

		//aba 케이스
		for (int i = 0; i < w.length - 2; i++) {
			if (w[i] == w[i + 2]) {
				cnt = 1;
				left = i - 1;
				right = i + 3;
				while (left >= 0 && right < len) {
					if (w[left] != w[right]) {
						break;
					}
					cnt++;
					left -= 1;
					right += 1;
				}
				if (answerlen < cnt * 2 + 3) {
					answerlen = cnt * 2 + 3;
					answer = s.substring(left + 1, right);
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("a"));
	}
}