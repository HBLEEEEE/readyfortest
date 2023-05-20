package KakaoBrain220520;

class problem3 {

	/*
	 * Complete the 'calculateScore' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. STRING text
	 *  2. STRING prefixString
	 *  3. STRING suffixString
	 */

	public static String calculateScore(String text, String prefixString, String suffixString) {
		// Write your code here
		String answer = "";

		System.out.println("text = " + text);
		System.out.println("prefixString = " + prefixString);
		System.out.println("suffixString = " + suffixString);

		int maxcnt = 0;
		for (int i = 0; i < text.length(); i++) {
			for (int j = i + 1; j < text.length() + 1; j++) {
				String temp = text.substring(i, j);
				System.out.println("temp = " + temp);
				int minPreLen = Math.min(temp.length(), prefixString.length());
				int cnt = 0;
				int tempMaxcnt = 0;
				for (int k = 0; k < minPreLen; k++) {
					System.out.println(temp.substring(0, k + 1));
					System.out.println(prefixString.substring(prefixString.length() - 1 - k));
					if (temp.substring(0, k + 1).equals(prefixString.substring(prefixString.length() - 1 - k))) {
						tempMaxcnt = Math.max(tempMaxcnt, temp.substring(0, k + 1).length());
						System.out.println("check");
					}
				}

				int tempMaxcnt2 = 0;
				int minSufLen = Math.min(temp.length(), suffixString.length());
				for (int k = 0; k < minSufLen; k++) {
					System.out.println(suffixString.substring(0, k + 1));
					System.out.println(temp.substring(temp.length() - 1 - k));
					if (suffixString.substring(0, k + 1).equals(temp.substring(temp.length() - 1 - k))) {
						tempMaxcnt2 = Math.max(tempMaxcnt2, temp.substring(0, k + 1).length());
						System.out.println("check");
					}
				}
				cnt = tempMaxcnt + tempMaxcnt2;

				if (cnt > maxcnt) {
					System.out.println("temp = " + temp);
					maxcnt = cnt;
					answer = temp;
				} else if (cnt == maxcnt && answer.length() > 0) {
					int res = temp.compareTo(answer);
					if (res < 0) {
						answer = temp;
					}
				}
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		// System.out.println(calculateScore("mis", "bruno", "ingenious"));

		char a = 'b';
		char b = 'c';
		if (a > b) {
			System.out.println("킥");
		} else {
			System.out.println("쩜쩜");
		}

	}

}

