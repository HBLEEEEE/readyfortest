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

    public int Fibonacci(int n){
        int[] D = new int[n+1];
        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i < n+1; i++) {
            D[i] = (D[i-1]+D[i-2])%1234567;
        }
        return D[n];
    }

    public int Fibo(int n){
        double sf = Math.sqrt(5);
        int ans = (int)(((Math.pow((1+sf),n)-Math.pow((1-sf),n))/(Math.pow(2,n)*sf))%1234567);
        return ans;
    }

    public double dFibo(int n){
        double sf = Math.sqrt(5);
        double ans = ((Math.pow((1+sf),n)-Math.pow((1-sf),n))/(Math.pow(2,n)*sf));
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
            if(yellow%i==0){
                width = yellow/i;
                hight = yellow/width;
                if ((width+hight)*2+4==brown){
                    answer[0] = width+2;
                    answer[1] = hight+2;
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
            if(s.charAt(i)=='('){
                cnt +=1;
            }else {
                cnt -=1;
            }
            if (cnt<0){
                return false;
            }
        }

        if (cnt>0){
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

    public long count_now(long n){
        if(n==1){
            return 1;
        } else if (n==2) {
            return 2;
        }
        return count_now(n-1)+count_now(n-2);
    }
}

class Solution_0004_1 {
    public static long solution(int n) {
        if (n==1){
            return 1;
        }

        long[] arr = new long[n];
        arr[0]=1;
        arr[1]=2;

        for (int i = 2; i < n; i++) {
            arr[i]=(arr[i-1]+arr[i-2])%1234567;
        }

        return arr[n-1];
    }
}

//문제 : 괄호 회전하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/76502

class Solution_0005 {
    public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        String k = s+s;
        for (int i = 0; i < len; i++) {
            System.out.println(k.substring(i,i+s.length()));
            if (CheckPossible(k.substring(i,i+s.length()))){
                answer +=1;
            }
        }
        return answer;
    }

    public static boolean CheckPossible(String s){
        char now;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if(res.length()==0&&(now==']'||now=='}'||now==')')){
                return false;
            }
            switch (now){
                case '[' : res += '[';
                    break;
                case ']' : if (res.charAt(res.length()-1)=='['){
                    res = res.substring(0,res.length()-1);
                }else {
                    return false;
                }
                    break;
                case '{' :res += '{';
                    break;
                case '}' : if (res.charAt(res.length()-1)=='{'){
                    res = res.substring(0,res.length()-1);
                }else {
                    return false;
                }
                    break;
                case '(' : res += '(';
                    break;
                case ')' : if (res.charAt(res.length()-1)=='('){
                    res = res.substring(0,res.length()-1);
                }else {
                    return false;
                }
                    break;
            }
        }
        if (res.length() != 0){
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
        if (cacheSize ==0){
            return 5*cities.length;
        }

        int answer = 0;
        List<String> cashlist = new ArrayList<>(cacheSize);
        String now = "";
        for (int i = 0; i < cities.length; i++) {
            now = cities[i].toLowerCase();
            if(cashlist.contains(now)){
                answer += 1;
                cashlist.remove(now);
                cashlist.add(now);
            }else {
                answer += 5;
                if(cashlist.size()>=cacheSize) {
                    cashlist.remove(0);
                }
                cashlist.add(now);
            }
            System.out.println(i + "번째 : "+now );
            System.out.println("answer : "+answer);

        }
        return answer;
    }

    public static void main(String[] args) {
        String[] strs = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(0,strs));
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
        for (int i = 0; i < str1.length()-1; i++) {
            temp = str1.substring(i,i+2);
            if(temp.matches("^[a-z]*$")){
                list1.add(temp);
                totallist.add(temp);
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            temp = str2.substring(i,i+2);
            if(temp.matches("^[a-z]*$")){
                list2.add(temp);
                totallist.add(temp);
            }
        }

        if (list1.size()==0&&list2.size()==0){
            return 65536;
        } else if (list1.size()==0&&list2.size()>0) {
            return 0;
        } else if (list2.size()==0&&list1.size()>0) {
            return 0;
        }

        int A = list1.size();
        int B = list2.size();

        for (String i : list1){
            if(list2.contains(i)){
                list2.remove(i);
                totallist.remove(i);
            }
        }


        int ApB = totallist.size();
        int AmB = A+B-ApB;

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("totallist = " + totallist);
        System.out.println(ApB);
        System.out.println(AmB);

        return (int)(AmB/(double)ApB*65536);
    }

    public static void main(String[] args) {
        String str1 = "AAA AAAA";
        String str2 = "aaa aaa";

        System.out.println(solution(str1,str2));
    }
}

//문제 : 튜플
//url : https://school.programmers.co.kr/learn/courses/30/lessons/64065

class Solution_0009 {
    public List<Integer> solution(String s) {
        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> temparrr = new ArrayList<>();
        String temp = "";
        String[] all = s.substring(2,s.length()-2).split("},\\{");
        List<Integer> sizes = new ArrayList<>();

        for (String now : all){
//            System.out.println("now : " + now);
            for (int i = 0; i < now.length()+1; i++) {
//                System.out.println(i + " : "+temp);
                if (i==now.length()){
                    temparrr.add(Integer.parseInt(temp));
                    temp = "";
                } else if (now.charAt(i)== ','){
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

        for (List i : arr){
            System.out.print(i.size() + " : ");
            System.out.println(i);
        }
        System.out.println(arr.size());
        System.out.println(sizes);

        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < sizes.size(); i++) {
            for (int a : arr.get(sizes.indexOf(i + 1))){
                if (!res.contains(a)){
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
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});

        System.out.println(Arrays.toString(arr));
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
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
    public  List<Integer> solution(int[] progresses, int[] speeds) {


        Stack<Integer[]> stack = new Stack<>();
        for (int i = progresses.length-1; i >=0 ; i--) {
            stack.push(new Integer[]{progresses[i],speeds[i]});
        }


        int cnt = 0;
        int tempres = 0;
        List<Integer> res = new ArrayList<>();
        while (!stack.empty()){
            if(stack.peek()[0]+cnt*stack.peek()[1]>=100){
                stack.pop();
                tempres +=1;
            }else {
                cnt ++;
                if (tempres>0){
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
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : tangerine) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }

        System.out.println(map);
        System.out.println(map.values());

        Collection<Integer> arr = map.values();
        Integer[] qqq = arr.toArray(new Integer[0]);
        Arrays.sort(qqq);
        System.out.println(Arrays.toString(qqq));
        for (int i = qqq.length-1 ; i>=0; i--){
            k -= qqq[i];
            answer +=1;
            if (k<=0){
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k =6;
        int[] arr= {1, 3, 2, 5, 4, 5, 2, 3};
        solution(k,arr);
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
        all : while(true){
            for (int i = 0; i < Math.pow(n,cnt); i++) {
                max_number += 1;
                total_need += cnt;
                if(total_need>=m*t){
                    break all;
                }
            }
            cnt +=1;
        }

        String fullnums = "";
        //max_number까지 n진법으로 변화시키고 쭉 이어버리기
        for (int i = 0; i < max_number+1; i++) {
            fullnums += ChangeToNstep(n,i);
        }

        //다 이어붙인 fullnums에서 필요한 위치만 가져다 붙이기
        for (int i = 0; i < t; i++) {
            answer += fullnums.charAt(p-1+m*i);
        }

        return answer;
    }

    public static String ChangeToNstep(int n, int number){
        String res = "";
        String[] overten = {"0","1","2","3","4","5","6","7","8","9",
                "A","B","C","D","E","F"};
        if (number == 0){
            return "0";
        }


        while (number>0){

            res += overten[number%n];
            number /= n;
        }

        String res2 = new StringBuilder(res).reverse().toString();

        return res2;
    }

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        System.out.println(solution(16,988,50,24));
        long afterTime = System.currentTimeMillis();
        long msDiffTime = afterTime-beforeTime;
        System.out.println("msDiffTime = " + msDiffTime);
    }





}

//문제 : 전화번호 목록
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42577

class Solution_0013 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        TreeSet<String> nums = new TreeSet<>();
        for (String i : phone_book){
            i = i.replaceAll(" ", "");
            nums.add(i);
        }
        Iterator<String> iter = nums.iterator();

        String before = iter.next();
        String now = "";
        while (iter.hasNext()){
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
            if (now.startsWith(before)){
                return false;
            }else {
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
            char alphabet = (char) ('A'+i);
            dictionary.put(Character.toString(alphabet), i+1);
        }

        int alphabetNumber = 27;
        int count = 1;
        int temp = 0;
        String tempWord = "";
        List<Integer> arr = new ArrayList<>();

        while (msg.length()>0){
            tempWord = msg.substring(0,count);
            System.out.println(tempWord);

            if (dictionary.containsKey(tempWord)){
                System.out.println("이게있네");
                temp = dictionary.get(tempWord);
                count += 1;
            }else {
                System.out.println("이게없네");
                dictionary.put(tempWord,alphabetNumber++);
                arr.add(temp);
                msg = msg.substring(count-1);
                count = 1;
            }

            if (count>msg.length()){
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
        int temp1= 0;
        int temp2 = 0;

        while (iter.hasNext()){
            temp1 = priorityQueue.poll();
            System.out.println(temp1);
            if (temp1>=K){
                break;
            }
            if (!iter.hasNext()){
                return -1;
            }
            temp2 = priorityQueue.poll();
            priorityQueue.add(temp1+temp2*2);
            count ++;

        }
        return count;

    }

    public static void main(String[] args) {

        int[] sc = {1, 2, 3, 4,5,6,79, 10, 12};
        System.out.println(solution(sc,7));
    }
}











