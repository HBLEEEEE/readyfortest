package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

//url : https://leetcode.com/problems/two-sum/
//title : 1. Two Sum
class Solution0001 {
	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];

		main:
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					ans[0] = i;
					ans[1] = j;
					break main;
				}
			}

		}

		return ans;

	}
}

//url : https://leetcode.com/problems/reverse-integer/
//title : 7. reverse-integer
class Solution0007 {
	public int reverse(int x) {
		long ans = 0;
		int t = 1;
		if (x < 0) {
			x *= -1;
			t = -1;
		}

		while (x > 0) {
			ans *= 10;
			ans += x % 10;
			x = x / 10;
		}

		if (ans >= Math.pow(2, 31)) {
			return 0;
		}

		ans *= t;

		return (int)ans;
	}
}

//url : https://leetcode.com/problems/string-to-integer-atoi/
//title : 8. String to Integer (atoi)
class Solution0008 {

	public static int myAtoi(String s) {

		Boolean check = true;

		char c;

		String answer = "";

		System.out.println("s.length() = " + s.length());
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			System.out.println("c = " + c);

			if (c == 32 && check) {

			} else if ((c == 45 || c == 43) && check) {
				check = false;
				answer += c;

			} else if ((c >= 48 && c <= 57)) {
				check = false;
				answer += c;
			} else {
				System.out.println("여기로 나감?");
				break;
			}
		}

		System.out.println("answer = " + answer);

		if (answer.length() == 0) {
			return 0;
		} else if (answer.equals("+") || answer.equals("-")) {
			return 0;
		}

		try {

			return Integer.parseInt(answer);

		} catch (Exception e) {

			if (answer.charAt(0) == '-') {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("400000000000000000000"));

	}
}

//url : https://leetcode.com/problems/median-of-two-sorted-arrays/
//title : 4. Median of Two Sorted Arrays
class Solution0004 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] merge = new int[nums1.length + nums2.length];

		for (int i = 0; i < nums1.length; i++) {
			merge[i] = nums1[i];
		}

		for (int i = 0; i < nums2.length; i++) {
			merge[nums1.length + i] = nums2[i];
		}

		Arrays.sort(merge);

		if (merge.length % 2 == 0) {
			return (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2F;
		} else {
			return merge[merge.length / 2];
		}
	}
}

//url : https://leetcode.com/problems/container-with-most-water/
//title : 11. Container With Most Water
class Solution0011 {
	public static int maxArea(int[] height) {

		int l = 0;
		int r = height.length - 1;
		int ans = (r - l) * Math.min(height[l], height[r]);

		int temp;
		while (l < r) {
			if (height[l] < height[r]) {
				l++;
			} else if (height[l] > height[r]) {
				r--;
			} else {
				l++;
				r--;
			}
			temp = (r - l) * Math.min(height[l], height[r]);
			if (temp > ans) {
				ans = temp;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] h = {8, 10, 14, 0, 13, 10, 9, 9, 11, 11};
		System.out.println(maxArea(h));
	}
}

//url : https://leetcode.com/problems/longest-common-prefix/
//title : 14. Longest Common Prefix
class Solution0014 {
	public static String longestCommonPrefix(String[] strs) {

		if (strs.length == 1) {
			return strs[0];
		}

		Arrays.sort(strs);

		String ans = "";
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];

		for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				ans += s1.charAt(i);
			} else {
				break;
			}
		}

		System.out.println(Arrays.toString(strs));

		return ans;
	}

	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};
		System.out.println(longestCommonPrefix(strs));
	}
}

//url : https://leetcode.com/problems/3sum/
//title : 15. 3Sum
class Solution0015 {
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> answer = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			System.out.println(nums[i]);
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1;
				int high = nums.length - 1;
				int sum = -nums[i];

				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						answer.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;

					} else if (nums[low] + nums[high] > sum) {
						high--;
					} else if (nums[low] + nums[high] < sum) {
						low++;
					}
				}
			}
		}

		return answer;

	}
}























