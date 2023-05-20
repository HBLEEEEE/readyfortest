package KakaoBrain220520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem2 {

	/*
	 * Complete the 'findMinimumTime' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. UNWEIGHTED_INTEGER_GRAPH centre
	 *  2. INTEGER_ARRAY status
	 */

	/*
	 * For the unweighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes.
	 * 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] and <name>To[i].
	 *
	 */

	public static int findMinimumTime(int centreNodes, List<Integer> centreFrom, List<Integer> centreTo,
		List<Integer> status) {

		int answer = 0;
		int count = 0;
		int loop = 0;
		int from;
		int to;
		Queue<Integer> queue = new LinkedList<>();
		Boolean[] check = new Boolean[centreFrom.size()];

		for (int i = 0; i < centreNodes; i++) {
			if (status.get(i) == 1) {
				Arrays.fill(check, false);
				count = 0;

				queue.add(i + 1);

				main:
				while (!queue.isEmpty()) {
					loop = queue.size();

					count++;

					for (int j = 0; j < loop; j++) {
						int now = queue.poll();
						for (int k = 0; k < check.length; k++) {

							from = centreFrom.get(k);
							to = centreTo.get(k);

							if ((now != from && now != to) || check[k]) {
								continue;
							}

							check[k] = true;

							if (from == now) {
								if (status.get(to - 1) == 3) {
									break main;
								}
								queue.add(to);
							} else if (to == now) {
								if (status.get(from - 1) == 3) {
									break main;
								}
								queue.add(from);
							}
						}
					}

				}
				answer = Math.max(answer, count);
				queue.clear();
			}

		}
		return answer;
	}

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(2);
		list1.add(3);
		list1.add(3);

		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);

		List<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(2);
		list3.add(2);
		list3.add(3);
		list3.add(2);
		list3.add(2);
		list3.add(1);

		System.out.println(findMinimumTime(7, list1, list2, list3));
	}

}
