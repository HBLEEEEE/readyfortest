package lv2;

import java.security.PublicKey;
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


















