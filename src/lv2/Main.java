package lv2;

import java.util.*;

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
        int ans = (int) (((Math.pow((1 + sf), n) - Math.pow((1 - sf), n)) / (Math.pow(2, n) * sf)) % 1234567);
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

        return (int) (AmB / (double) ApB * 65536);
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
            stack.push(new Integer[]{progresses[i], speeds[i]});
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
            char alphabet = (char) ('A' + i);
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
            return new int[]{0, 0};
        }

        System.out.println("fastcase = " + fastcase);

        int who = (fastcase + 1) % n;
        int turn = (fastcase + 1) / n + 1;
        if (who == 0) {
            who = n;
            turn -= 1;
        }

        int[] answer = new int[]{who, turn};

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
        queue.add(new int[]{x, y});

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
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
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
                answer = (int) (Math.log(n / cnt * 2) / Math.log(2));
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

//문제 : JadenCase 문자열 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12951

class Solution_0026 {
    public String solution(String s) {
        String answer = "";
        answer += Character.toString(s.charAt(0)).toUpperCase();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ') {
                answer += Character.toString(s.charAt(i)).toUpperCase();
            } else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
        }
        return answer;
    }
}

//문제 : 이진 변환 반복하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/70129

class Solution_0027 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (true) {
            int ones = 0;
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            answer[1] += zeros;
            answer[0]++;
            s = toBinary(ones);

            if (s.length() == 1) {
                break;
            }
        }
        return answer;
    }

    public String toBinary(int n) {
        String ans = "";
        while (true) {
            if (n > 0) {
                ans = n % 2 + ans;
                n = n / 2;
            } else {
                break;
            }
        }
        return ans;
    }
}

//문제 : 다음 큰 숫자
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12911

class Solution_0028 {
    public static int solution(int n) {
        int maxN = 1;
        while (true) {
            if (n / maxN > 0) {
                maxN *= 2;
            } else {
                break;
            }
        }

        int countOne = 0;
        int cnt = maxN;
        int copyN = n;
        while (cnt > 0) {
            if (copyN / cnt == 1) {
                countOne++;
                copyN = copyN - cnt;
            }
            cnt /= 2;
        }

        n++;
        while (true) {
            int now = n;
            if (now >= maxN * 2) {
                maxN *= 2;
            }

            int newCountOne = 0;
            cnt = maxN;
            while (cnt > 0) {
                if (now / cnt == 1) {
                    newCountOne++;
                    now = now - cnt;
                }
                cnt /= 2;
            }

            if (newCountOne == countOne) {
                return n;
            } else {
                n++;
            }
        }
    }
}

//문제 : 짝지어 제거하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12973

class Solution_0029 {
    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
}

//문제 : 점프와 순간 이동
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12980

class Solution_0030 {
    public int solution(int n) {
        int ans = 0;

        while (n != 1) {
            if (n % 2 == 1) {
                ans++;
                n -= 1;
            } else {
                n /= 2;
            }
        }

        return ans + 1;
    }
}

//문제 : N개의 최소공배수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12953

class Solution_0031 {
    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return arr[0] * arr[1] / getGCD(arr[0], arr[1]);
        }

        int lcm = arr[0] * arr[1] / getGCD(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            lcm = lcm * arr[i] / getGCD(arr[i], lcm);
        }

        return lcm;
    }

    public int getGCD(int n, int m) {
        int n1, n2, temp;
        if (n >= m) {
            n1 = n;
            n2 = m;
        } else {
            n1 = m;
            n2 = n;
        }

        while (true) {
            if (n1 % n2 == 0) {
                return n2;
            } else {
                n1 = n1 % n2;
                temp = n1;
                n1 = n2;
                n2 = temp;
            }
        }
    }
}

//문제 : 연속 부분 수열 합의 개수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/131701

class Solution_0032 {
    public int solution(int[] elements) {

        int[] arr = new int[elements.length * 2];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        System.arraycopy(elements, 0, arr, elements.length, elements.length);

        Set<Integer> totals = new HashSet<>();

        int cnt = 0;

        for (int i = 1; i < elements.length + 1; i++) {
            for (int j = 0; j < elements.length; j++) {
                cnt = 0;
                for (int k = j; k < j + i; k++) {
                    cnt += arr[k];
                }
                totals.add(cnt);
            }

        }

        return totals.size();
    }

    public int solution2(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] num = new int[elements.length];
        for (int len = 1; len < elements.length + 1; len++) {
            for (int i = 0; i < elements.length; i++) {
                num[i] += elements[(len + i - 1) % elements.length];
                set.add(num[i]);
            }
        }

        return set.size();
    }
}

//문제 : 할인 행사
//url : https://school.programmers.co.kr/learn/courses/30/lessons/131127

class Solution_0033 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int temp;
        List<String> wants = Arrays.asList(want);

        for (int i = 0; i < 10; i++) {
            if (wants.contains(discount[i])) {
                number[wants.indexOf(discount[i])]--;
            }
        }

        if (allZero(number)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            if (wants.contains(discount[i - 10])) {
                number[wants.indexOf(discount[i - 10])]++;
            }
            if (wants.contains(discount[i])) {
                number[wants.indexOf(discount[i])]--;
            }

            if (allZero(number)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean allZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

//문제 : n^2 배열 자르기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/87390

class Solution_0034 {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) (right - left + 1)];
        int cnt = 0;
        for (long i = left; i <= right; i++) {
            answer[cnt] = (int) change(i, n);
            cnt++;
        }

        return answer;
    }

    public long change(long x, int n) {
        if (x / n >= x % n) {
            return (x) / n + 1;
        } else {
            return x % n + 1;
        }
    }
}

//문제 : H-Index
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42747

class Solution_0035 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > answer) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}

//문제 : 의상
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42578

class Solution_0036 {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        int answer = 1;

        for (String i : map.keySet()) {
            answer *= (map.get(i) + 1);
        }

        return answer - 1;
    }
}

//문제 : 프로세스
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42587

class Solution_0037 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }

        while (true) {
            int max = -1;
            int maxIdx = -1;
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] > max) {
                    max = priorities[i];
                    maxIdx = i;
                }
            }

            while (true) {
                int t = queue.poll();
                if (max == priorities[t]) {
                    answer += 1;
                    if (t == location) {
                        return answer;
                    }
                    priorities[t] = -1;
                    break;
                } else {
                    queue.add(t);
                }
            }
        }
    }
}

//문제 : 타겟 넘버
//url : https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution_0038 {

    int[] nums;
    int mainTarget;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        nums = numbers;
        mainTarget = target;

        int total = 0;
        cal(total, 0);

        return answer;
    }

    public void cal(int total, int idx) {
        if (idx > nums.length - 1) {
            if (total == mainTarget) {
                answer += 1;
            }
            return;
        }

        for (int i = -1; i < 2; i += 2) {
            cal(total + nums[idx] * i, idx + 1);
        }

    }

}

//문제 : k진수에서 소수 개수 구하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/92335

class Solution_0039 {
    public int solution(int n, int k) {
        String kNumber = Long.toString(n, k);

        String[] pArr = kNumber.split("0");

        int pCount = 0;

        for (String p : pArr) {
            if (p.isEmpty() || p.isBlank())
                continue;

            if (isPrime(Long.parseLong(p)))
                pCount++;
        }
        return pCount;
    }

    public boolean isPrime(long n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;

        int count = 0;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}

//문제 : 모음사전
//url : https://school.programmers.co.kr/learn/courses/30/lessons/84512

class Solution_0040 {
    public int solution(String word) {
        int answer = 0;
        //AEIOU

        int c = 781;
        int idx = 0;
        int m = 625;
        while (idx < word.length()) {
            answer += calNum(word.charAt(idx)) * c;
            answer += 1;
            idx++;
            c -= m;
            m /= 5;

        }
        answer += 1;

        return answer;
    }

    public int calNum(char a) {
        if (a == 'A') {
            return 0;
        } else if (a == 'E') {
            return 1;
        } else if (a == 'I') {
            return 2;
        } else if (a == 'O') {
            return 3;
        } else {
            return 4;
        }
    }
}

//문제 : 주차 요금 계산
//url : https://school.programmers.co.kr/learn/courses/30/lessons/92341

class Solution_0041 {
    public int[] solution(int[] fees, String[] records) {

        List<String> carNums = new ArrayList<>();
        Map<String, Boolean> carInOut = new HashMap<>(); // 출차 확인
        Map<String, Integer> carParking = new HashMap<>(); //총 주차 시간 계산
        Map<String, Integer> carInTime = new HashMap<>(); // 최근 입차 시간 h*60 + m 값으로 환산

        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");
            //차량 기록이 있는지 확인
            if (carInOut.containsKey(str[1])) {
                //입차인지 출차인지
                if (carInOut.get(str[1])) {
                    //입차 기록이 있고 이번이 출차 기록일 때
                    carInOut.put(str[1], false); // 출차로 바꾸기
                    //총 주차 시간 = 이전 주차 시간 + 출차 시간 - 입차 시간
                    carParking.put(str[1], carParking.get(str[1]) + calTime(str[0]) - carInTime.get(str[1]));

                } else {
                    //출차 기록이 있고 이번이 입차 일때
                    carInOut.put(str[1], true);
                    carInTime.put(str[1], calTime(str[0]));
                }

            } else {
                //차량 기록이 없다면 입차 등록
                carNums.add(str[1]);
                carInOut.put(str[1], true);
                carParking.put(str[1], 0);
                carInTime.put(str[1], calTime(str[0]));
            }
        }

        //입차 상태인 것들 23:59에 출차시켜야함
        String[] cars = carInOut.keySet().toArray(new String[0]);
        for (String i : cars) {
            if (carInOut.get(i)) {
                carParking.put(i, carParking.get(i) + calTime("23:59") - carInTime.get(i));
            }
        }

        int[] answer = new int[carNums.size()];

        String[] sortCars = carNums.toArray(new String[carNums.size()]);
        Arrays.sort(sortCars);

        for (int i = 0; i < sortCars.length; i++) {
            // 총시간
            int totalTime = carParking.get(sortCars[i]);

            if (totalTime < fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = (int) (fees[1] + Math.ceil((totalTime - fees[0]) / (float) fees[2]) * fees[3]);
            }

        }

        return answer;
    }

    public int calTime(String time) {
        //time의 형태는 00:00
        String[] HaM = time.split(":");
        int hour = Integer.parseInt(HaM[0]);
        int min = Integer.parseInt(HaM[1]);

        return hour * 60 + min;
    }
}

//문제 : 땅따먹기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12913

class Solution_0042 {
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += findMax(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += findMax(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += findMax(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += findMax(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }

        return Math.max(Math.max(land[land.length - 1][0], land[land.length - 1][1]),
                Math.max(land[land.length - 1][2], land[land.length - 1][3]));
    }

    int findMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}

//문제 : 방문 길이
//url : https://school.programmers.co.kr/learn/courses/30/lessons/49994

class Solution_0043 {
    public int solution(String dirs) {
        Set<String> cord = new HashSet<>();

        int[] before = new int[]{0, 0};
        int[] after = new int[2];

        char c;

        float x;
        float y;
        for (int i = 0; i < dirs.length(); i++) {
            c = dirs.charAt(i);
            if (c == 'U') {
                after[0] = before[0];
                after[1] = before[1] + 1;
                if (after[1] == 6) {
                    after[1] = 5;
                    continue;
                }
            } else if (c == 'D') {
                after[0] = before[0];
                after[1] = before[1] - 1;
                if (after[1] == -6) {
                    after[1] = -5;
                    continue;
                }
            } else if (c == 'R') {
                after[0] = before[0] + 1;
                after[1] = before[1];
                if (after[0] == 6) {
                    after[0] = 5;
                    continue;
                }
            } else {
                //L
                after[0] = before[0] - 1;
                after[1] = before[1];
                if (after[0] == -6) {
                    after[0] = -5;
                    continue;
                }
            }

            x = (after[0] + before[0]) / 2f;
            y = (after[1] + before[1]) / 2f;
            cord.add(x + " " + y);
            before[0] = after[0];
            before[1] = after[1];
        }
        return cord.size();
    }
}

//문제 : 뒤에 있는 큰 수 찾기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/154539

class Solution_0044 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        int max = 0;
        int maxIdx = numbers.length;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIdx = i;
                answer[i] = -1;
            } else if (numbers[i] == max) {
                maxIdx = i;
                answer[i] = -1;
            } else {
                if (numbers[i] == numbers[i + 1]) {
                    answer[i] = answer[i + 1];
                } else if (numbers[i] < numbers[i + 1]) {
                    answer[i] = numbers[i + 1];
                } else {
                    for (int j = i + 1; j <= maxIdx; j++) {
                        if (numbers[i] == numbers[j]) {
                            answer[i] = answer[j];
                            break;
                        } else if (numbers[i] < numbers[j]) {
                            answer[i] = numbers[j];
                            break;
                        }

                    }
                }
            }
        }

        return answer;
    }
}

//문제 : LCS(Longest Common Substring)

class Solution_0045 {
    public static int solution(String a, String b) {

        int[][] cal = new int[a.length() + 1][b.length() + 1];

        int ans = 0;

        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    cal[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cal[i][j] = cal[i - 1][j - 1] + 1;
                } else {
                    cal[i][j] = 0;
                }
                ans = Math.max(ans, cal[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(cal));

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEF", "GBCDFE"));
    }
}

//문제 : LCS(Longest Common Subsequence)

class Solution_0046 {
    public static int solution(String a, String b) {

        int[][] cal = new int[a.length() + 1][b.length() + 1];

        int ans = 0;

        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    cal[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cal[i][j] = cal[i - 1][j - 1] + 1;
                } else {
                    cal[i][j] = Math.max(cal[i - 1][j], cal[i][j - 1]);
                }
                ans = Math.max(ans, cal[i][j]);
            }
        }

        for (int i = 0; i < cal.length; i++) {
            System.out.println(Arrays.toString(cal[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEF", "AFKD"));
    }
}

//문제 : LCS(Longest Common Subsequence) 응용문제

class Solution_0047 {
    public static int solution(String a, String b) {

        int[][] cal = new int[a.length() + 1][b.length() + 1];

        int ans = 0;

        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    cal[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cal[i][j] = cal[i - 1][j - 1] + 1;
                } else {
                    cal[i][j] = Math.max(cal[i - 1][j], cal[i][j - 1]);
                }
                ans = Math.max(ans, cal[i][j]);
            }
        }

        for (int i = 0; i < cal.length; i++) {
            System.out.println(Arrays.toString(cal[i]));
        }

        if (ans == Math.min(a.length(), b.length())) {
            return ans;
        } else {
            int x = a.length();
            int y = b.length();
            all:
            for (int i = 0; i < a.length() + 1; i++) {
                for (int j = 0; j < b.length() + 1; j++) {
                    if (cal[i][j] == ans) {
                        x = i;
                        y = j;
                        break all;
                    }
                }
            }

            if (x == a.length() && y == b.length()) {
                return ans + 1;
            } else {
                if (y == b.length()) {
                    for (int i = x; i < a.length(); i++) {
                        if (a.charAt(i) == a.charAt(x - 1)) {
                            return ans + 1;
                        }
                    }
                    return ans;
                } else if (x == a.length()) {
                    for (int i = y; i < b.length(); i++) {
                        if (b.charAt(i) == b.charAt(y - 1)) {
                            return ans + 1;
                        }
                    }
                    return ans;
                } else {
                    return ans + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEF", "ABFZ"));
    }
}

//문제 : 스킬트리
//url : https://school.programmers.co.kr/learn/courses/30/lessons/49993

class Solution_0048 {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        List<Character> treeChar = new ArrayList<>();
        List<Boolean> treeBool = new ArrayList<>();

        treeChar.add('a');
        treeBool.add(true);

        for (int i = 0; i < skill.length(); i++) {
            treeChar.add(skill.charAt(i));
            treeBool.add(false);
        }

        all:
        for (int i = 0; i < skill_trees.length; i++) {

            for (int j = 1; j < treeBool.size(); j++) {
                treeBool.set(j, false);
            }

            for (int j = 0; j < skill_trees[i].length(); j++) {
                char now = skill_trees[i].charAt(j);
                if (treeChar.contains(now)) {
                    if (treeBool.get(treeChar.indexOf(now) - 1)) {
                        treeBool.set(treeChar.indexOf(now), true);
                    } else {
                        continue all;
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}

//문제 : [3차] 파일명 정렬
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17686

class Solution_0049 {
    public String[] solution(String[] files) {

        int check = 0;

        while (true) {
            check = 0;
            for (int i = 0; i < files.length - 1; i++) {
                if (compareStr(files[i], files[i + 1])) {
                    String temp = files[i];
                    files[i] = files[i + 1];
                    files[i + 1] = temp;
                    check++;
                }
            }
            if (check == 0) {
                break;
            }
        }

        return files;
    }

    public static boolean compareStr(String a, String b) {
        //false면 비교환
        //true면 교환

        String[] partA = a.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String[] partB = b.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        int compare = partA[0].toLowerCase().compareTo(partB[0].toLowerCase());

        int numA = Integer.parseInt(partA[1]);
        int numB = Integer.parseInt(partB[1]);
        if (compare == 0) {
            if (numA <= numB) {
                return false;
            } else {
                return true;
            }
        } else if (compare < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String a = "abcd001.zip";
        String b = "bff002.txt";
        // String a = "abcd";
        // String b = "bff";

        System.out.println(b.compareTo(a));
        System.out.println(compareStr(a, b));

    }
}

//문제 : 롤케이크 자르기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/132265

class Solution_0050 {
    public int solution(int[] topping) {
        int[] cal = new int[topping.length];
        int[] calR = new int[topping.length];
        Set<Integer> set = new HashSet<>();
        Set<Integer> setR = new HashSet<>();
        int tl = topping.length - 1;

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            setR.add(topping[tl - i]);
            cal[i] = set.size();
            calR[tl - i] = setR.size();
        }

        int answer = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            if (cal[i] == calR[i + 1]) {
                answer++;
            } else if (cal[i] > calR[i + 1]) {
                break;
            }
        }

        return answer;
    }
}

//문제 : 숫자 변환하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/154538

class Solution_0051 {

    public int solution(int x, int y, int n) {

        Queue<Integer> queue = new LinkedList<>();

        int ans = 1;
        queue.add(x);

        if (x == y) {
            return 0;
        }

        while (true) {
            int s = queue.size();
            System.out.println(ans);
            for (int i = 0; i < s; i++) {
                int t = queue.poll();
                System.out.println("t = " + t);
                if (t * 2 == y || t * 3 == y || t + n == y) {
                    return ans;
                }

                if (t * 3 < y) {
                    queue.add(t * 3);
                    queue.add(t * 2);
                } else if (t * 2 < y) {
                    queue.add(t * 2);
                }
                if (t + n < y) {
                    queue.add(t + n);
                }
            }
            System.out.println(queue);

            ans++;
            if (queue.size() == 0) {
                return -1;
            }
        }
    }

    public int solution2(int x, int y, int n) {

        if (x == y) {
            return 0;
        }

        int[] dp = new int[y + 1];

        dp[x] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);

        all:
        while (!queue.isEmpty()) {
            int s = queue.size();

            for (int i = 0; i < s; i++) {
                int t = queue.poll();
                if (t == x) {
                    break all;
                }
                if (t % 2 == 0 && dp[t / 2] <= 0) {
                    queue.add(t / 2);
                    dp[t / 2] = dp[t] + 1;
                }
                if (t % 3 == 0 && dp[t / 3] <= 0) {
                    queue.add(t / 3);
                    dp[t / 3] = dp[t] + 1;
                }
                if (t - n > 0 && dp[t - n] <= 0) {
                    queue.add(t - n);
                    dp[t - n] = dp[t] + 1;
                }
            }
        }

        return dp[x];
    }
}

//문제 : 2 x n 타일링
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12900

class Solution_0052 {
    public long solution(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] pibo = new int[n];
        pibo[0] = 1;
        pibo[1] = 2;
        for (int i = 2; i < n; i++) {
            pibo[i] = (pibo[i - 1] + pibo[i - 2]) % 1000000007;
        }

        return pibo[n - 1];
    }
}

//문제 : 택배상자
//url : https://school.programmers.co.kr/learn/courses/30/lessons/131704

class Solution_0053 {
    public static int solution(int[] order) {

        Stack<Integer> main = new Stack<>();
        Stack<Integer> sub = new Stack<>();

        for (int i = order.length; i >= 1; i--) {
            main.add(i);
        }

        int idx = 0;

        while (true) {
            if (!main.isEmpty() && (main.peek() == order[idx])) {
                idx++;
                main.pop();
            } else if (!sub.isEmpty() && (sub.peek() == order[idx])) {
                sub.pop();
                idx++;
            } else if (!main.isEmpty()) {
                sub.add(main.pop());
            } else {
                break;
            }
        }

        return idx;
    }
}

//문제 : 2개 이하로 다른 비트
//url : https://school.programmers.co.kr/learn/courses/30/lessons/77885

class Solution_0054 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            int idx = -1;
            for (int j = bin.length() - 1; j >= 0; j--) {
                if (bin.charAt(j) == '0') {
                    idx = j;
                    break;
                }
            }
            if (idx == bin.length() - 1) {
                answer[i] = Long.parseLong(bin.substring(0, bin.length() - 1) + "1", 2);
            } else if (idx == -1) {
                answer[i] = Long.parseLong("10" + bin.substring(1), 2);
            } else {
                answer[i] = Long.parseLong(bin.substring(0, idx) + "10" + bin.substring(idx + 2), 2);
            }

        }

        return answer;
    }

    public static void main(String[] args) {

        long[] numbers = new long[]{11, 7};

        System.out.println(Arrays.toString(solution(numbers)));
    }
}

//문제 : 쿼드압축 후 개수 세기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution_0055 {

    int one = 0;
    int zero = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        cal(arr);

        answer[0] = zero;
        answer[1] = one;

        return answer;
    }

    public void cal(int[][] arr) {
        if (arr.length == 1) {
            if (arr[0][0] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }

        int t = arr[0][0];
        int n = arr.length / 2;
        boolean c = true;
        all:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != t) {
                    c = false;
                    break all;
                }
            }
        }

        if (c) {
            if (t == 1) {
                one++;
            } else {
                zero++;
            }
        } else {
            int[][] arr1 = new int[n][n];
            int[][] arr2 = new int[n][n];
            int[][] arr3 = new int[n][n];
            int[][] arr4 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr1[i][j] = arr[i][j];
                    arr2[i][j] = arr[i + n][j];
                    arr3[i][j] = arr[i][j + n];
                    arr4[i][j] = arr[i + n][j + n];
                }
            }
            cal(arr1);
            cal(arr2);
            cal(arr3);
            cal(arr4);
        }
    }
}

//문제 : 가장 큰 수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42746

class Solution_0056 {
    public static String solution(int[] numbers) {
        String answer = "";

        String[] strs = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strs[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        if (strs[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < strs.length; i++) {
            answer += strs[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{0, 0, 0};

        System.out.println(solution(arr));

    }
}

//문제 : 가장 큰 수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42583

class Solution_0057 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> process = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            process.add(0);
        }

        int now = 0;
        int idx = 0;
        int time = 1;

        while (true) {
            now += process.poll();
            if (now == -1) {
                break;
            }
            if (idx == truck_weights.length) {
                process.add(-1);
            } else {
                if (now + truck_weights[idx] <= weight) {
                    now += truck_weights[idx];
                    process.add(-truck_weights[idx]);
                    idx++;
                } else {
                    process.add(0);
                }
            }
            time++;
        }

        return time - 1;
    }
}

//문제 : 소수 찾기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42839

class Solution_0058 {

    static String number;
    static boolean[] check;
    static Set<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;

        number = numbers;
        check = new boolean[numbers.length()];

        backTrack("");

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            if (checkPrime(it.next())) {
                answer++;
            }
        }

        System.out.println(set);

        return answer;

    }

    public static void backTrack(String now) {
        for (int i = 0; i < number.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                set.add(Integer.parseInt(now + number.charAt(i)));
                backTrack(now + number.charAt(i));
                check[i] = false;
            }
        }
    }

    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        }

        System.out.println(Math.sqrt(n));

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            System.out.println("i = " + i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println("----------------------------");
        System.out.println(checkPrime(17));
    }
}

//문제 : 삼각 달팽이
//url : https://school.programmers.co.kr/learn/courses/30/lessons/68645

class Solution_0059 {

    public static int[] solution(int n) {

        int l = (n + 1) * n / 2;

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new int[i]);
        }

        int row = 0;
        int col = 0;

        int cnt = 1;
        int downRightUp = 0;
        int len = n;
        while (cnt <= l) {
            if (downRightUp == 0) {
                for (int i = 0; i < len - 1; i++) {
                    list.get(row++)[col] = cnt++;
                }
                list.get(row)[col++] = cnt++;

            } else if (downRightUp == 1) {
                for (int i = 0; i < len - 1; i++) {
                    list.get(row)[col++] = cnt++;
                }
                list.get(row--)[col--] = cnt++;

            } else {
                for (int i = 0; i < len - 1; i++) {
                    list.get(row--)[col--] = cnt++;
                }
                list.get(row++)[col] = cnt++;
            }

            len--;
            downRightUp = (downRightUp + 1) % 3;

        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }

        int[] answer = new int[l];
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            for (int j = 0; j < temp.length; j++) {
                answer[idx++] = temp[j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }
}

//문제 : 큰 수 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42883

class Solution_0060 {
    public static String solution(String number, int k) {
        String answer = "";

        int[] nums = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            nums[i] = number.charAt(i) - 48;
        }

        int cnt = 0;
        int beforeIdx = -1;
        int max;
        while (cnt < number.length() - k) {
            max = -1;
            for (int i = beforeIdx + 1; i < k + cnt + 1; i++) {
                if (nums[i] == 9) {
                    max = nums[i];
                    beforeIdx = i;
                    break;
                }
                if (nums[i] > max) {
                    max = nums[i];
                    beforeIdx = i;
                }
            }
            answer += (int) max;
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }
}

//문제 : 두 큐 합 같게 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/118667

class Solution_0061 {
    public int solution(int[] queue1, int[] queue2) {

        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }

        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int cnt = 0;
        int l = Math.max(queue1.length, queue2.length) * 3;
        int temp;
        while (true) {

            if (sum1 > sum2) {
                temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                cnt++;
            } else if (sum1 < sum2) {
                temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
                cnt++;
            } else {
                break;
            }
            if (cnt > l) {
                return -1;
            }

        }

        return cnt;
    }
}

//문제 : 연속된 부분 수열의 합
//url : https://school.programmers.co.kr/learn/courses/30/lessons/178870

class Solution_0062 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length;
        answer[0] = 0;

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (right < sequence.length && left <= right) {
            if (sum < k) {
                right++;
                if (right == sequence.length) {
                    break;
                }
                sum += sequence[right];
            } else if (sum == k) {
                if (answer[1] - answer[0] > right - left) {
                    answer[1] = right;
                    answer[0] = left;
                }
                right++;
                if (right == sequence.length) {
                    break;
                }
                sum += sequence[right];

            } else {
                sum -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}

//문제 : 124 나라의 숫자
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12899

class Solution_0063 {
    public static String solution(int n) {
        String answer = "";
        int i = 0;
        int s = 0;

        while (n > s) {
            i++;
            s += Math.pow(3, i);
        }

        System.out.println("n = " + n);
        System.out.println("s = " + s);
        System.out.println("i = " + i);

        n -= s - Math.pow(3, i);
        i--;

        System.out.println("n = " + n);
        System.out.println("s = " + s);
        System.out.println("i = " + i);

        while (i > -1) {
            if (n > Math.pow(3, i) * 2) {
                answer += "4";
                n -= Math.pow(3, i) * 2;
            } else if (n > Math.pow(3, i)) {
                answer += "2";
                n -= Math.pow(3, i);
            } else {
                answer += "1";
            }
            i--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}

//문제 : 메뉴 리뉴얼
//url : https://school.programmers.co.kr/learn/courses/30/lessons/72411

class Solution_0064 {

    static Map<String, Integer> map = new HashMap<>();
    static List<String> temp = new ArrayList<>();

    public static String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        int idx = 0;
        while (idx < course.length) {

            temp.clear();
            for (int i = 0; i < orders.length; i++) {
                if (orders[i].length() >= course[idx])
                    calSibling("", orders[i], -1, 0, course[idx]);
            }

            map.clear();
            int max = 0;
            for (int i = 0; i < temp.size(); i++) {
                String t = temp.get(i);
                if (map.containsKey(t)) {
                    max = Math.max(max, map.get(t) + 1);
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 0);
                }
            }

            String[] strs = map.keySet().toArray(new String[0]);

            if (max >= 1) {
                for (int i = 0; i < strs.length; i++) {
                    if (map.get(strs[i]) == max) {
                        answer.add(strs[i]);
                    }
                }
            }
            idx++;
        }

        String[] ans = answer.toArray(new String[0]);
        Arrays.sort(ans);

        return ans;
    }

    public static void calSibling(String now, String str, int beforeIdx, int c, int n) {
        if (c == n) {
            if (now.length() == n) {
                temp.add(now);
            }
            return;
        }

        for (int i = beforeIdx + 1; i < str.length() - n + 1 + c; i++) {
            calSibling(now + str.charAt(i), str, i, c + 1, n);
        }

    }

    public static void main(String[] args) {
        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = new int[]{2, 3, 4};

        System.out.println(Arrays.toString(solution(orders, course)));

    }

}

//문제 : 무인도 여행
//url : https://school.programmers.co.kr/learn/courses/30/lessons/154540

class Solution_0065 {

    int[][] check;

    public int[] solution(String[] maps) {

        List<Integer> answer = new ArrayList<>();

        check = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'X') {
                    check[i][j] = maps[i].charAt(j) - 48;
                }
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (check[i][j] != 0) {
                    search(i, j, i, j);
                    answer.add(check[i][j]);
                }
            }
        }

        if (answer.size() == 0) {
            return new int[]{-1};
        }

        int[] ans = new int[answer.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        Arrays.sort(ans);

        return ans;
    }

    public void search(int si, int sy, int ni, int ny) {
        for (int i = 0; i < 4; i++) {
            if (i == 0 && ni - 1 != -1 && check[ni - 1][ny] != 0) {
                if (ni - 1 == si && ny == sy) {
                    continue;
                }
                check[si][sy] += check[ni - 1][ny];
                check[ni - 1][ny] = 0;
                search(si, sy, ni - 1, ny);
            } else if (i == 1 && ni + 1 != check.length && check[ni + 1][ny] != 0) {
                if (ni + 1 == si && ny == sy) {
                    continue;
                }
                check[si][sy] += check[ni + 1][ny];
                check[ni + 1][ny] = 0;
                search(si, sy, ni + 1, ny);
            } else if (i == 2 && ny - 1 != -1 && check[ni][ny - 1] != 0) {
                if (ni == si && ny - 1 == sy) {
                    continue;
                }
                check[si][sy] += check[ni][ny - 1];
                check[ni][ny - 1] = 0;
                search(si, sy, ni, ny - 1);
            } else if (i == 3 && ny + 1 != check[0].length && check[ni][ny + 1] != 0) {
                if (ni == si && ny + 1 == sy) {
                    continue;
                }
                check[si][sy] += check[ni][ny + 1];
                check[ni][ny + 1] = 0;
                search(si, sy, ni, ny + 1);
            }
        }
    }
}

//문제 : 전력망을 둘로 나누기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/86971

class Solution_0066 {
    public static int solution(int n, int[][] wires) {
        int answer = n;

        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("i = " + i);
            left.clear();
            right.clear();
            queue.clear();
            left.add(wires[i][0]);
            right.add(wires[i][1]);

            for (int j = i + 1; j < i + wires.length; j++) {
                int t = j % wires.length;
                if (left.contains(wires[t][0])) {
                    left.add(wires[t][1]);
                } else if (left.contains(wires[t][1])) {
                    left.add(wires[t][0]);
                } else if (right.contains(wires[t][0])) {
                    right.add(wires[t][1]);
                } else if (right.contains(wires[t][1])) {
                    right.add(wires[t][0]);
                } else {
                    queue.add(t);
                }
            }

            System.out.println("ㅊㅊㅊㅊ");
            System.out.println(left);
            System.out.println(right);

            while (!queue.isEmpty()) {
                int t = queue.poll();
                if (left.contains(wires[t][0])) {
                    left.add(wires[t][1]);
                } else if (left.contains(wires[t][1])) {
                    left.add(wires[t][0]);
                } else if (right.contains(wires[t][0])) {
                    right.add(wires[t][1]);
                } else if (right.contains(wires[t][1])) {
                    right.add(wires[t][0]);
                } else {
                    queue.add(t);
                }
            }

            answer = Math.min(answer, Math.abs(left.size() - right.size()));

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] wires = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(4, wires));

    }
}

//문제 : 소카1

class Solution_001167 {

    boolean[] check;
    int n;
    List<Integer> pile = new ArrayList<>();
    int[] orders;
    long answer = Long.MAX_VALUE;

    public int solution(int n, int[] orders) {

        check = new boolean[n];
        this.n = n;
        this.orders = orders;

        search(0, n);

        return (int) (answer % 1000000000);

    }

    public void search(int cnt, int len) {

        // 책을 다 쌓으면 검사한다.
        if (cnt == len) {
            if (pile.size() == n * 2) {
                cal();
            }
        }

        // 재귀 함수를 이용하여 모든 쌓을 수 있는 경우의 수를 쌓아본다.
        // 이미 쌓은 책 번호인지는 check 배열을 이용해 확인
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                pile.add(i + 1);
                pile.add(i + 1);

                search(cnt + 1, len);

                pile.remove(Integer.valueOf(i + 1));
                pile.remove(Integer.valueOf(i + 1));
                check[i] = false;
            }
        }

    }

    public void cal() {
        List<Integer> copiedPile = new ArrayList<>(pile);

        long ans = 0;

        // 빼낼 번호의 책 중 가장 위에 있는 책을 뽑으면 되며, 이때 인덱스가 책의 위치이자 뽑을 때 드는 힘이다.
        // 인덱스 만큼 정답에 더해준다.
        // 해당 책을 뽑으면서 list에서 삭제해 준다.
        int temp;
        for (int i = 0; i < orders.length; i++) {
            temp = copiedPile.indexOf(orders[i]);
            ans += temp;
            copiedPile.remove(temp);
        }

        //기존 정답과 비교하여 최소값으로 바꿔준다.
        answer = (int) Math.min(answer, ans);

    }
}

//문제 : 소카2
class Solution_010168 {

    int[][] grid;
    int n;
    int k;

    public int solution(int n, int k, int[][] grid) {
        this.k = k;
        this.n = n;
        this.grid = grid;

        // 만들수 있는 정사각형의 크기를 l 로 한다.
        // 최대 크기부터 계산해본다.
        int l = n;

        while (l > 1) {
            // 계산을 시작할 위치를 고려한다.
            // 예를들어 전체가 4*4일때 3*3의 시작점은 (0,0),(0,1),(1,0),(1,1)만 가능하다.
            for (int i = 0; i <= n - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    if (find(i, j, l)) {
                        // 가장 크기가 큰 정사각형부터 계산함으로 true가 나오면 바로 종료한다.
                        return l * l;
                    }
                }
            }
            l--;
        }

        return 1;
    }

    public boolean find(int x, int y, int l) {
        Map<Integer, Integer> map = new HashMap<>();

        //x,y 지점을 시작으로 x ~ x+l-1, y ~ y+l-1 범위 내에 각각 숫자가 몇개씩 있는지 계산한다.
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                if (map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], map.get(grid[i][j]) + 1);
                } else {
                    map.put(grid[i][j], 1);
                }
            }
        }

        //특정 숫자가 l*l-k 개 보다 많으면 k개 이하의 사각형을 새롭게 칠해서 정사각형을 만들 수 있다.
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        int min = l * l - k;
        for (int i = 0; i < keys.length; i++) {
            if (map.get(keys[i]) >= min) {
                return true;
            }
        }

        return false;
    }
}

class sol02020 {
    public static void main(String[] args) throws Exception {
        float n = 5 / (float) 3;

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < n - 1 - i; j++) {
                temp += " ";
            }
            for (int j = 0; j < i + 1; j++) {
                temp += "*";
            }
            System.out.println(temp);
        }
    }
}

class sol02021 {
    public static int solution(int n) {
        if (n < 5) {
            if (n == 3) {
                return 1;
            } else {
                return -1;
            }
        }

        if (n % 5 == 0) {
            return n / 5;
        }

        int d5 = n / 5;
        int d3 = 0;
        int m = n % 5;

        while (d5 >= 0) {
            if (m % 3 == 0) {
                d3 = m / 3;
                break;
            } else {
                m += 5;
                d5--;
            }
        }

        return d5 + d3;
    }
}

class sol03 {

    static Map<Integer, List<Integer>> map;

    static int[] answer;
    static int total = 0;

    public static int[] solution(int total_sp, int[][] skills) {

        int[] real = new int[skills.length + 2];

        answer = new int[skills.length + 1];

        map = new HashMap<>();

        for (int i = 0; i < skills.length; i++) {

            real[skills[i][1]]++;

            if (map.containsKey(skills[i][0])) {
                map.get(skills[i][0]).add(skills[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(skills[i][1]);
                map.put(skills[i][0], list);
            }
        }

        System.out.println(Arrays.toString(real));
        System.out.println(map);

        int top = -1;
        for (int i = 1; i < real.length; i++) {
            if (real[i] == 0) {
                top = i;
                break;
            }
        }

        System.out.println("top = " + top);

        int a = cal(top);
        int d = total_sp / total;

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        System.out.println("total = " + total);

        for (int i = 0; i < answer.length; i++) {
            answer[i] *= d;
        }

        return answer;

    }

    public static int cal(int i) {
        System.out.println("i = " + i);
        if (!map.containsKey(i)) {
            total += 1;
            answer[i - 1] = 1;
            return 1;
        } else {
            List<Integer> temp = map.get(i);
            int ans = 0;
            for (int j = 0; j < temp.size(); j++) {
                System.out.println("temp.get(j) = " + temp.get(j));
                ans += cal(temp.get(j));
            }
            total += ans;
            answer[i - 1] = ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] skills = new int[][]{{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        System.out.println(Arrays.toString(solution(121, skills)));
    }
}

class Solutionkakao001 {
    public int solution(String[] friends, String[] gifts) {
        List<String> nameIdx = new ArrayList<>();

        // 준사람, 받은사람
        int[][] getTabel = new int[friends.length][friends.length];
        Map<String, Integer> point = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            nameIdx.add(friends[i]);
            point.put(friends[i], 0);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] giveTake = gifts[i].split(" ");
            point.put(giveTake[0], point.get(giveTake[0]) + 1);
            point.put(giveTake[1], point.get(giveTake[1]) - 1);

            getTabel[nameIdx.indexOf(giveTake[0])][nameIdx.indexOf(giveTake[1])] += 1;
            getTabel[nameIdx.indexOf(giveTake[1])][nameIdx.indexOf(giveTake[0])] -= 1;

        }

        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            int temp = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (getTabel[i][j] > 0) {
                    temp += 1;
                } else if (getTabel[i][j] == 0) {
                    if (point.get(nameIdx.get(i)) > point.get(nameIdx.get(j))) {
                        temp += 1;
                    }
                }
            }
            answer = Math.max(answer, temp);
        }

        return answer;
    }
}

class Solutionkakao002 {
    public int[] solution(int[][] edges) {

        int[] answer = new int[4];

        Map<Integer, List<Integer>> map = new HashMap<>();

        int max = 0;
        int idx = 0;

        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
                if (map.get(edges[i][0]).size() > max) {
                    max = map.get(edges[i][0]).size();
                    idx = edges[i][0];
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
        }

        System.out.println("idx = " + idx);

        List<Integer> temp = map.get(idx);
        answer[0] = idx;

        for (int i = 0; i < temp.size(); i++) {
            int t = temp.get(i);//3
            System.out.println("t = " + t);
            System.out.println("answer = " + Arrays.toString(answer));
            if (!map.containsKey(t)) {
                answer[2]++;
            } else {
                if (map.get(t).size() == 2) {
                    answer[3]++;

                } else {
                    // size = 1일때 3이 원소가 있고, 3이 8을 가지고 있고, 원소가 2개 이상일때
                    if (map.containsKey(map.get(t).get(0)) && map.get(map.get(t).get(0)).contains(t)
                            && map.get(map.get(t).get(0)).size() > 1) {
                        answer[3]++;
                    } else {
                        int a = map.get(t).get(0);//5
                        while (true) {
                            if (!map.containsKey(a)) {
                                answer[2]++;
                                break;
                            }
                            if (a == t) {
                                answer[1]++;
                                break;
                            }
                            a = map.get(a).get(0);
                        }
                    }
                }
            }
        }

        return answer;
    }
}

class Solutionkakao003 {

    int[] nums1;
    int[] nums2;

    boolean[] visit;

    int[][] diceGlobal;

    int totalWin = 0;

    public int[] solution(int[][] dice) {
        diceGlobal = dice;
        int[] answer = new int[dice.length / 2];
        visit = new boolean[dice.length];
        nums1 = new int[(int) Math.pow(6, dice.length / 2)];
        nums2 = new int[(int) Math.pow(6, dice.length / 2)];

        return answer;
    }

    public void comb(int n, int b, int c) {
        if (c == n / 2) {
            cal(c);
        }
        for (int i = b + 1; i < n - n / 2 + 1 + c; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(n, i, c + 1);
                visit[i] = false;
            }
        }

    }

    public void cal(int c) {

    }

}

class Solutionkakao004 {

    int[] cards;
    int coin;
    int ans = 0;

    public int solution(int coin, int[] cards) {

        this.cards = cards;
        this.coin = coin;

        List<Integer> gets = new ArrayList<>();

        for (int i = 0; i < cards.length / 3; i++) {
            gets.add(cards[i]);
        }

        search(gets, 1, coin);

        int answer = 0;
        return answer;
    }

    public void search(List<Integer> list, int round, int leftCoin) {
        if (round == cards.length / 3) {
            ans = round;
            return;
        } else {
            ans = Math.max(ans, round);
        }

        if (leftCoin >= 2) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 1]);
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 2]);
                    leftCoin -= 2;
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                } else if (i == 1) {
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 1]);
                    leftCoin -= 1;
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                } else if (i == 2) {
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 2]);
                    leftCoin -= 1;
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                } else {
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                }
            }
        } else if (leftCoin == 1) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 1]);
                    leftCoin -= 1;
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                } else if (i == 1) {
                    list.add(cards[cards.length / 3 + (round - 1) * 2 + 2]);
                    leftCoin -= 1;
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                } else {
                    List<List<Integer>> res = calPoss(list);
                    for (int j = 0; j < res.size(); j++) {
                        list.remove(Integer.valueOf(res.get(j).get(0)));
                        list.remove(Integer.valueOf(res.get(j).get(1)));
                        search(list, round + 1, leftCoin);
                    }
                }
            }
        } else {
            List<List<Integer>> res = calPoss(list);
            for (int j = 0; j < res.size(); j++) {
                list.remove(Integer.valueOf(res.get(j).get(0)));
                list.remove(Integer.valueOf(res.get(j).get(1)));
                search(list, round + 1, leftCoin);
            }
        }
    }

    public List<List<Integer>> calPoss(List<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();

        if (list.size() < 2) {
            return res;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == cards.length + 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(list.get(i));
                    temp.add(list.get(j));
                    res.add(temp);
                }
            }
        }
        return res;
    }
}

//가비아 1번
class Solution {
    public static int solution(int fuel, int[] powers, int[] distances) {

        int[] fuels = new int[powers.length];
        for (int i = 0; i < fuels.length; i++) {
            fuels[i] = fuel / fuels.length;
        }
        if (fuel % fuels.length != 0) {
            fuels[fuels.length - 1] += fuel % fuels.length;
        }

        int maxIdx = -1;
        int maxTime = Integer.MIN_VALUE;
        int minIdx = -1;
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++) {
            int t = timeToArr(fuels[i], powers[i], distances[i]);
            if (t > maxTime) {
                maxTime = t;
                maxIdx = i;
            }
            if (t < minTime) {
                minTime = t;
                minIdx = i;
            }
        }

        System.out.println("minTime = " + minTime);
        System.out.println("maxTime = " + maxTime);

        boolean checker = true;

        while (checker) {

            fuels[maxIdx]++;
            fuels[minIdx]--;

            System.out.println(Arrays.toString(fuels));

            if (fuels[minIdx] <= 0) {
                break;
            }

            int temp = maxTime;

            maxTime = Integer.MIN_VALUE;
            minTime = Integer.MAX_VALUE;

            for (int i = 0; i < distances.length; i++) {
                int t = timeToArr(fuels[i], powers[i], distances[i]);
                System.out.println("i = " + t);
                if (t > maxTime) {
                    maxTime = t;
                    maxIdx = i;
                }
                if (t < minTime && fuels[i] > 1) {
                    minTime = t;
                    minIdx = i;
                }
            }

            System.out.println("maxTime = " + maxTime);
            System.out.println("minTime = " + minTime);

            if (maxTime > temp) {
                checker = false;
                maxTime = temp;
            }
        }

        return maxTime;
    }

    public static int timeToArr(int fuel, int power, int dis) {

        int acelDis = fuel * fuel * power / 2;
        if (dis < acelDis) {
            return (int) Math.ceil(Math.sqrt(dis * 2 / power));
        }

        return (int) Math.ceil((dis - fuel * fuel * power / 2) / fuel / power + fuel);
    }

    public static void main(String[] args) {
        int[] powers = new int[]{40, 30, 20, 10};
        int[] dis = new int[]{1000, 2000, 3000, 4000};
        int fuel = 19;

        System.out.println(solution(fuel, powers, dis));
    }
}

//가비아2
class Solution_G2 {
    public long[] solution(int[][] fees, int t) {
        long[][] minmax = new long[2][2];
        long[] answer = new long[2];

        minmax[0][0] = 1;
        minmax[0][1] = fees[0][1] / (fees[0][0] + 1);
        minmax[1][0] = Long.MAX_VALUE;
        minmax[1][1] = fees[0][1];

        if (fees.length == 1) {
            answer[0] = minmax[1][1];
            answer[1] = minmax[0][1] * (t + 1);
            return answer;
        }

        return answer;
    }

    public boolean possible(int a, int b, int t, int cost) {
        long cal = (long) Math.ceil(t / a) * b;
        if (cal == cost) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] fees = new int[][]{{4, 1000}, {6, 1000}, {21, 3000}, {16, 2000}, {26, 3000}};

        for (int i = 0; i < fees.length; i++) {
            int a = fees[i][1] / fees[i][0];
            System.out.println("a = " + a);
        }
    }
}

//가비아3
class Solution_G3 {
    public String[] solution(String[] req_id, int[][] req_info) {

        // Andy , "Andy +11 -240"
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < req_info.length; i++) {
            //구매 요청인지 확인
            if (req_info[i][0] == 0) {
                int lowIdx = 0;
                int lowCost = Integer.MAX_VALUE;
                boolean check = true;
                while (req_info[i][1] > 0 && check) {
                    check = false;
                    //구매 가능한 상품중 가장 저렴한 물품 찾기
                    for (int j = 0; j < req_info.length; j++) {
                        if (req_info[j][0] == 1 && req_info[j][2] < lowCost) {
                            lowIdx = j;
                            lowCost = req_info[j][2];
                            check = true;
                        }
                    }

                    System.out.println("거래 대상자 찾음");
                    System.out.println("i = " + i);
                    System.out.println("lowIdx = " + lowIdx);

                    //거래하기
                    //구매 수량이 판매 수량 보다 적은 경우
                    int tradeCost = 0;
                    int tradeQuantity = 0;
                    //구매 수량이 판매 수량 보다 적은 경우
                    if (req_info[i][1] < req_info[lowIdx][1]) {
                        tradeCost = req_info[lowIdx][2];
                        tradeQuantity = req_info[i][1];
                        req_info[i][0] = 2;
                        req_info[lowIdx][1] -= req_info[i][1];
                        //구매 수량과 판매 수량이 같은경우
                    } else if (req_info[i][1] == req_info[lowIdx][1]) {
                        tradeCost = req_info[lowIdx][2];
                        tradeQuantity = req_info[i][1];
                        req_info[i][0] = 2;
                        req_info[lowIdx][0] = 2;
                        req_info[i][1] = 2;
                        req_info[lowIdx][1] = 2;
                        //구매 수량이 판매 수량 보다 많은 경우
                    } else {
                        tradeCost = req_info[lowIdx][2];
                        tradeQuantity = req_info[lowIdx][1];
                        req_info[lowIdx][0] = 2;
                        req_info[i][1] -= req_info[lowIdx][1];
                        req_info[lowIdx][1] = 0;
                    }

                    //거래한거 map에 계산하기
                    String buyer = "";
                    String seller = "";
                    if (map.containsKey(req_id[i])) {
                        String[] nameQM = map.get(req_id[i]).split(" ");
                        buyer += req_id[i];
                        buyer += " ";
                        int tempQ = Integer.parseInt(nameQM[1]) + tradeQuantity;
                        if (tempQ > 0) {
                            buyer += "+";
                            buyer += tempQ;
                        } else {
                            buyer += tempQ;
                        }
                        buyer += " ";
                        int tempM = Integer.parseInt(nameQM[2]) - tradeCost;
                        if (tempM > 0) {
                            buyer += "+";
                            buyer += tempM;
                        } else {
                            buyer += tempM;
                        }
                    } else {
                        buyer += req_id[i];
                        buyer += " ";
                        buyer += tradeQuantity;
                        buyer += " ";
                        buyer += "-" + tradeCost;
                    }

                    map.put(req_id[i], buyer);

                    if (map.containsKey(req_id[lowIdx])) {
                        String[] nameQM = map.get(req_id[lowIdx]).split(" ");
                        seller += req_id[lowIdx];
                        seller += " ";
                        int tempQ = Integer.parseInt(nameQM[1]) - tradeQuantity;
                        if (tempQ > 0) {
                            seller += "+";
                            seller += tempQ;
                        } else {
                            seller += tempQ;
                        }
                        seller += " ";
                        int tempM = Integer.parseInt(nameQM[2]) + tradeCost;
                        if (tempM > 0) {
                            seller += "+";
                            seller += tempM;
                        } else {
                            seller += tempM;
                        }
                    } else {
                        seller += req_id[i];
                        seller += " ";
                        seller += "-" + tradeQuantity;
                        seller += " ";
                        seller += "+" + tradeCost;
                    }

                    map.put(req_id[lowIdx], seller);

                }
            }

        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        System.out.println(keys);

        String[] ans = new String[keys.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(keys.get(i));
        }
        return ans;
    }
}


//문제 : 호텔 대실
//url : https://school.programmers.co.kr/learn/courses/30/lessons/155651
class Solution_0067 {
    public int solution(String[][] book_time) {

        //24시간 * 1분단위로 60칸 = 1440
        int[] schedule = new int[1440];

        for (int i = 0; i < book_time.length; i++) {
            String[] begin = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            int startHour = Integer.parseInt(begin[0]);
            int startMin = Integer.parseInt(begin[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1]);
            int s = startHour * 60 + startMin;
            int e = endHour * 60 + endMin + 9;

            if (e >= 1440) {
                e = 1439;
            }

            for (int j = s; j <= e; j++) {
                schedule[j]++;
            }
        }

        int answer = 0;

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] > answer) {
                answer = schedule[i];
            }
        }
        return answer;
    }
}


//문제 : 호텔 대실
//url : https://school.programmers.co.kr/learn/courses/30/lessons/148653
class Solution_0068 {
    public static int solution(int storey) {

        int answer = 0;

        while (storey > 0) {
            int t = storey % 10;
            if (t < 5) {
                answer += t;
            } else if (t > 5) {
                answer += 10 - t;
                storey += 10;
            } else {
                if (storey % 100 >= 55) {
                    answer += 10 - t;
                    storey += 10;
                } else {
                    answer += t;
                }
            }

            storey /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(95));
    }
}

//문제 : [3차] 방금그곡
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17683
class Solution_0069 {
    public static String solution(String m, String[] musicinfos) {
        int ans = 0;
        String answer = "(None)";

        // C, C#, D, D#, E, F, F#, G, G#, A, A#, B
        // C, Q , D, R , E, F, S , G, T , A, U , B

        m = m.replaceAll("C#", "Q");
        m = m.replaceAll("D#", "R");
        m = m.replaceAll("F#", "S");
        m = m.replaceAll("G#", "T");
        m = m.replaceAll("A#", "U");

        System.out.println("m = " + m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] infoSplit = musicinfos[i].split(",");
            String[] startTime = infoSplit[0].split(":");
            String[] endTime = infoSplit[1].split(":");
            String songName = infoSplit[2];

            String lyrics = infoSplit[3];
            lyrics = lyrics.replaceAll("C#", "Q");
            lyrics = lyrics.replaceAll("D#", "R");
            lyrics = lyrics.replaceAll("F#", "S");
            lyrics = lyrics.replaceAll("C#", "T");
            lyrics = lyrics.replaceAll("A#", "U");

            String totalsong = "";

            int startMin = Integer.parseInt(startTime[0]);
            int startSec = Integer.parseInt(startTime[1]);
            int endMin = Integer.parseInt(endTime[0]);
            int endSec = Integer.parseInt(endTime[1]);
            int songtime = (endMin - startMin) * 60 + endSec - startSec;

            System.out.println("songtime = " + songtime);

            totalsong = lyrics.repeat(1 + songtime / lyrics.length());
            totalsong = totalsong.substring(0, songtime);

            if (totalsong.contains(m) && songtime > ans) {
                ans = songtime;
                answer = songName;
            }
        }


        return answer;
    }
}


//문제 : 괄호 변환
//url : https://school.programmers.co.kr/learn/courses/30/lessons/60058
class Solution_0070 {
    public static String solution(String p) {

        return sliceAndSort(p);
    }

    public static String sliceAndSort(String a) {

        String ans = "";

        if (CheckCorrect(a)) {
            return a;
        }

        int n = 0;
        int m = 0;
        int point = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                n++;
            } else {
                m++;
            }
            if (n == m) {
                point = i;
                break;
            }
        }


        String u = "";
        String v = "";

        if (point == 0) {
            v = a;
        } else if (point == a.length()) {
            u = a;
        } else {
            u = a.substring(0, point + 1);
            v = a.substring(point + 1);
        }

        System.out.println("u = " + u);
        System.out.println("v = " + v);

        if (CheckCorrect(u)) {
            ans += u + sliceAndSort(v);
        } else {
            ans += "(" + sliceAndSort(v) + ")" + cutAndReverse(u);
        }

        return ans;

    }


    public static boolean CheckCorrect(String s) {

        if (s.length() == 0) {
            return true;
        }

        while (s.length() != 0) {

            boolean c = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                    s = s.substring(0, i) + s.substring(i + 2);
                    c = false;
                    break;
                }
            }

            if (c) {
                return false;
            }
        }
        return true;
    }

    public static String cutAndReverse(String t) {
        String ans = "";
        for (int i = 1; i < t.length() - 1; i++) {
            if (t.charAt(i) == '(') {
                ans += ")";
            } else {
                ans += "(";
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String a = "))((";

        System.out.println(solution(a));

    }

}


//문제 : 수식 최대화
//url : https://school.programmers.co.kr/learn/courses/30/lessons/67257
class Solution_0071 {
    public static long solution(String expression) {
        List<String> cals = new ArrayList<>();
        List<Long> nums = new ArrayList<>();

        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);

            if (now >= '0' && now <= '9') {
                temp += now;
            } else {
                nums.add(Long.parseLong(temp));
                temp = "";
                cals.add(String.valueOf(now));
            }
        }
        nums.add(Long.parseLong(temp));

        System.out.println("cals = " + cals);
        System.out.println("nums = " + nums);

        long answer = 0;

        String[] orders = new String[]{"+", "-", "*"};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && j != k && k != i) {
                        System.out.println(orders[i]);
                        System.out.println(orders[j]);
                        System.out.println(orders[k]);


                        List<Long> numsCopy = new ArrayList<>(List.copyOf(nums));
                        List<String> calsCopy = new ArrayList<>(List.copyOf(cals));

                        System.out.println("numsCopy = " + numsCopy);
                        System.out.println("calsCopy = " + calsCopy);


                        for (int l = 0; l < calsCopy.size(); l++) {
                            if (calsCopy.get(l).equals(orders[i])) {
                                numsCopy.set(l, calByOper(numsCopy.get(l), numsCopy.get(l + 1), orders[i]));
                                numsCopy.remove(l + 1);
                                calsCopy.remove(l);
                                l--;
                            }
                        }

                        System.out.println("numsCopy = " + numsCopy);
                        System.out.println("calsCopy = " + calsCopy);
                        for (int l = 0; l < calsCopy.size(); l++) {
                            if (calsCopy.get(l).equals(orders[j])) {
                                numsCopy.set(l, calByOper(numsCopy.get(l), numsCopy.get(l + 1), orders[j]));
                                numsCopy.remove(l + 1);
                                calsCopy.remove(l);
                                l--;
                            }
                        }

                        System.out.println("numsCopy = " + numsCopy);
                        System.out.println("calsCopy = " + calsCopy);

                        for (int l = 0; l < calsCopy.size(); l++) {
                            System.out.println("l = " + l);
                            if (calsCopy.get(l).equals(orders[k])) {
                                numsCopy.set(l, calByOper(numsCopy.get(l), numsCopy.get(l + 1), orders[k]));
                                numsCopy.remove(l + 1);
                                calsCopy.remove(l);
                                l--;
                            }
                        }

                        System.out.println("numsCopy = " + numsCopy);
                        System.out.println("calsCopy = " + calsCopy);

                        System.out.println("finals = " + numsCopy.get(0));

                        if (answer < Math.abs(numsCopy.get(0))) {
                            answer = Math.abs(numsCopy.get(0));
                        }
                    }
                }
            }
        }


        return answer;
    }

    public static Long calByOper(long a, long b, String c) {
        if (c.equals("+")) {
            return a + b;
        } else if (c.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }

    public static void main(String[] args) {
        String exp = "100-200*300-500+20";
        System.out.println(solution(exp));

    }
}


//문제 : 시소 짝꿍
//url : https://school.programmers.co.kr/learn/courses/30/lessons/152996
class Solution_0072 {
    public static long solution(int[] weights) {
        long answer = 0;

        Map<Float, Integer> map = new HashMap<>();
        Float[] cals = new Float[7];
        cals[0] = 0.5f;
        cals[1] = 2 / 3f;
        cals[2] = 3 / 4f;
        cals[3] = 4 / 3f;
        cals[4] = 3 / 2f;
        cals[5] = 2f;
        cals[6] = 1f;


        for (int i = 0; i < weights.length - 1; i++) {

            int now = weights[i];
            float after = (float) weights[i + 1];

            for (int j = 0; j < cals.length; j++) {
                if (map.containsKey(now * cals[j])) {
                    map.put(now * cals[j], map.get(now * cals[j]) + 1);
                } else {
                    map.put(now * cals[j], 1);
                }
            }

            if (map.containsKey(after)) {
                answer += map.get(after);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] weigths = new int[]{100, 180, 360, 100, 270};

        System.out.println(solution(weigths));
    }
}

//문제 : 행렬 테두리 회전하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/77485
class Solution_0073 {

    static int[][] matrix;

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];

        int c = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = c++;
            }
        }

        System.out.println("기본이다요");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = RotateAndLeast(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
            System.out.println("변신!");
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(Arrays.toString(matrix[j]));
            }
        }


        return answer;
    }

    public static int RotateAndLeast(int r1, int c1, int r2, int c2) {
        int least = 10100;

        int temp = matrix[r1][c1];

        for (int i = r1; i < r2; i++) {
            if (least > matrix[i + 1][c1]) {
                least = matrix[i + 1][c1];
            }
            matrix[i][c1] = matrix[i + 1][c1];
        }

        for (int i = c1; i < c2; i++) {
            if (least > matrix[r2][i + 1]) {
                least = matrix[r2][i + 1];
            }
            matrix[r2][i] = matrix[r2][i + 1];
        }

        for (int i = r2; i > r1; i--) {
            if (least > matrix[i - 1][c2]) {
                least = matrix[i - 1][c2];
            }
            matrix[i][c2] = matrix[i - 1][c2];
        }

        for (int i = c2; i > c1 + 1; i--) {
            if (least > matrix[r1][i - 1]) {
                least = matrix[r1][i - 1];
            }
            matrix[r1][i] = matrix[r1][i - 1];
        }

        matrix[r1][c1 + 1] = temp;
        if (least > temp) {
            least = temp;
        }

        return least;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        System.out.println(Arrays.toString(solution(6, 6, arr)));
    }
}


//문제 : 배달
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12978
class Solution_0074 {

    int[][] globalRoad;
    boolean[] check;
    int[] time;
    int globalK;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        globalK = K;
        globalRoad = road;
        check = new boolean[road.length];
        time = new int[N];
        Arrays.fill(time, 500001);

        for (int i = 0; i < globalRoad.length; i++) {
            if (globalRoad[i][0] == 1) {
                check[i] = true;
                searchTime(globalRoad[i][1], globalRoad[i][2]);
            } else if (globalRoad[i][1] == 1) {
                check[i] = true;
                searchTime(globalRoad[i][0], globalRoad[i][2]);
            }
        }

        time[0] = 0;

        for (int i = 0; i < time.length; i++) {
            if (time[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public void searchTime(int next, int total_time) {
        if (total_time > globalK || next == 1) {
            return;
        }

        if (total_time < time[next - 1]) {
            time[next - 1] = total_time;
        }

        for (int i = 0; i < globalRoad.length; i++) {
            if (globalRoad[i][2] > globalK) {
                check[i] = true;
                continue;
            }

            if (!check[i]) {
                if (globalRoad[i][0] == next) {
                    check[i] = true;
                    searchTime(globalRoad[i][1], total_time + globalRoad[i][2]);
                    check[i] = false;
                } else if (globalRoad[i][1] == next) {
                    check[i] = true;
                    searchTime(globalRoad[i][0], total_time + globalRoad[i][2]);
                    check[i] = false;
                }
            }
        }
    }
}

//다익스트라 알고리즘
class Solution_0074_1 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //갈 수 있는 길들을 2차원 배열에 정리
        int[][] roads = new int[N + 1][N + 1];
        for (int i = 0; i < road.length; i++) {
            if ((roads[road[i][0]][road[i][1]] > road[i][2]) || (roads[road[i][0]][road[i][1]] == 0)) {
                roads[road[i][0]][road[i][1]] = road[i][2];
                roads[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        //여기서 부터 idx 기준으로 번호를 작성한다.
        //0이면 1번 노드 이다. roads는 제외한다.

        //특정 노드까지 도달할 시간을 저장할 배열
        //문제 상 최대 값보다 높은 숫자로 초기화
        //시작 노드는 0으로 초기화한다.
        int[] elapsedTime = new int[N];
        Arrays.fill(elapsedTime, 500001);
        elapsedTime[0] = 0;

        //방문했는지 저장하는 노드, 방문하면 true로 바꾼다.
        boolean[] visited = new boolean[N];

        //마을의 개수만큼 루프를 돈다.
        for (int k = 0; k < N; k++) {

            //최소 시간과 그 시간을 가지는 기준 노드를 position에 저장한다.
            int leastTime = 50001;
            int position = 0;
            //leastTime보다 적은 비용으로 갈 수 있는 노드만 파악한다. 없다면 시작노드가 기준이 된다.
            for (int i = 1; i < visited.length; i++) {
                if (visited[i] == false && elapsedTime[i] < leastTime) {
                    leastTime = elapsedTime[i];
                    position = i;
                }
            }

            //기준 노드까지 걸리는 시간을 저장한다.
            int baseTime = elapsedTime[position];

            //기준노드 에서 갈 수 있는 길들(0이상의 비용을 가진 roads의 원소) 중에서
            //길들을 통해 갈 수 있는 노드의 비용이 현재 비용보다 적은 경우에는 바꿔주고 아니면 냅둔다.
            for (int i = 1; i < N; i++) {
                if (roads[position + 1][i + 1] > 0 && roads[position + 1][i + 1] + baseTime < elapsedTime[i]) {
                    elapsedTime[i] = roads[position + 1][i + 1] + baseTime;
                }
            }
            //방문한거를 체크한다.
            visited[position] = true;

        }

        // 경과시간을 파악하여 정답 개수를 뽑아낸다.
        for (int i = 0; i < elapsedTime.length; i++) {
            if (elapsedTime[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}

//플로이드 워셜
class Solution_0074_2 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //거리 비용을 2차원 배열에 정리
        int[][] costs = new int[N][N];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i], 500001);
            costs[i][i] = 0;
        }

        //노드 간 거리를 입력해준다.
        for (int i = 0; i < road.length; i++) {
            if (costs[road[i][0] - 1][road[i][1] - 1] > road[i][2]) {
                costs[road[i][0] - 1][road[i][1] - 1] = road[i][2];
                costs[road[i][1] - 1][road[i][0] - 1] = road[i][2];
            }
        }

        //플로이드 와샬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // jk를 바로 가는 것과 i를 거쳐서 가는 것 중 비교한다.
                    costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                }
            }
        }

        //기준 노드에서 다른 노드들까지 가는데 K 이하의 비용으로 가는 경우 계산
        for (int i = 0; i < N; i++) {
            if (costs[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}


//문제 : 줄 서는 방법
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12936
class Solution_0075 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        if (n == 1) {
            return new int[]{1};
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        long a = factorial(n - 1);
        long b = k / a;

        answer[0] = list.get((int) b);
        list.remove((int) b);
        k--;
        k = k % a;

        for (int i = 1; i < n; i++) {
            a = factorial(n - i - 1);
            b = k / a;

            answer[i] = list.get((int) b);
            list.remove((int) b);
            if (i == 0) {
                k--;
            }

            k = k % a;
        }
        return answer;
    }

    public long factorial(int n) {
        long ans = 1;
        for (int i = 1; i < n + 1; i++) {
            ans *= i;
        }
        return ans;
    }
}

//문제 : 숫자 카드 나누기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/135807
class Solution_0076 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        if (arrayA[0] == 1) {

        } else {
            A:
            for (int i = 2; i <= arrayA[0]; i++) {
                for (int j = 0; j < arrayA.length; j++) {
                    if (arrayA[j] % i != 0) {
                        continue A;
                    }
                }
                listA.add(i);
            }
        }

        if (arrayB[0] == 1) {

        } else {
            B:
            for (int i = 2; i <= arrayB[0]; i++) {
                for (int j = 0; j < arrayB.length; j++) {
                    if (arrayB[j] % i != 0) {
                        continue B;
                    }
                }
                listB.add(i);
            }
        }

        AA:
        for (int i = listA.size() - 1; i >= 0; i--) {
            int n = listA.get(i);
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % n == 0) {
                    continue AA;
                }
            }

            if (answer < n) {
                answer = n;
            }
            break;
        }

        BB:
        for (int i = listB.size() - 1; i >= 0; i--) {
            int n = listB.get(i);
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % n == 0) {
                    continue BB;
                }
            }

            if (answer < n) {
                answer = n;
            }
            break;
        }

        System.out.println("listA = " + listA);
        System.out.println("listB = " + listB);

        return answer;
    }
}


//문제 : 벌집 피자
//url : https://school.programmers.co.kr/learn/courses/30/lessons/135807
class Solution_0077 {
    static public int[] solution(int n) {

        int N = 1;

        for (int i = 1; i < n; i++) {
            N += 6 * i;
        }
        int answer[] = new int[N];

        int[][] temp = new int[2 * n - 1][n * 4 - 3];

        int w = n - 1;
        int c = 0;
        boolean wRight = true;
        boolean cDown = true;

        for (int i = 1; i <= N; i++) {

            System.out.println("w = " + w);
            System.out.println("c = " + c);
            if (w >= 2 * n - 1) {
                temp[2 * n - 2][c] = i;
            } else if (w < 0) {
                temp[0][c] = i;
            } else {
                temp[w][c] = i;
            }

            if (wRight) {
                w++;
                if (w == 2 * n) {
                    wRight = false;
                }
            } else {
                w--;
                if (w == -n + 1) {
                    wRight = true;
                }
            }

            if (!cDown && c == 0) {
                cDown = true;
            } else if (c == n * 4 - 3 - 1 && cDown) {
                cDown = false;
            }

            if (cDown) {
                c++;
            } else {
                c--;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}

//문제 : 테이블 해시 함수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/147354
class Solution_0078 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

//        Arrays.sort(data, Comparator.comparingInt(row -> row[col]).thenComparingInt(row -> row[0]));
        Arrays.sort(data, Comparator.comparingInt((int[] row) -> row[col])
                .thenComparingInt((int[] row) -> row[0]).reversed());

        List<Integer> ans = new ArrayList<>();

        System.out.println(Arrays.deepToString(data));

        for (int i = row_begin - 1; i < row_end; i++) {
            int t = 0;
            for (int j = 0; j < data[i].length; j++) {
                t += data[i][j] % (i + 1);
            }
            ans.add(t);
        }

        System.out.println(ans);

        int answer = ans.get(0);
        for (int i = 1; i < ans.size(); i++) {
            answer = answer ^ ans.get(i);
        }

        return answer;
    }
}























