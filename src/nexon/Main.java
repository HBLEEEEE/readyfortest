package nexon;

import java.util.Comparator;
import java.util.List;

class Solution001 {

	public int fmg(List<Integer> arr) {

		if (arr.size() == 1) {
			return 0;
		}
		System.out.println("call");

		arr.sort(Comparator.naturalOrder());
		int ans = 0;
		int hold1 = 0;
		int hold2 = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == arr.get(i + 1)) {
				hold1++;
			} else {
				if (hold1 > 0) {
					hold1--;
					ans++;
				}
			}
		}

		return ans;

	}
}
