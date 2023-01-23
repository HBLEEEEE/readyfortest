//Programmers 코딩 테스트 lv0


import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//문제 : 나머지 구하기
//문제 설명 : 정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120810
class Solution_0001{
    public int solution(int num1, int num2) {
        int answer = -1;
        if ((num1<=0 || num1 >100) || (num2<=0 || num2 >100)) {
            System.out.println("입력값은 0<num1,num2<=100 으로 제한됩니다.");

        }else {
            answer = num1%num2;
        }

        return answer;
    }
}

//문제 :몫구하기
//문제 설명 : 정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120805

class Solution_0002 {
    public int solution(int num1, int num2) {

        int answer = 0;

        if ((num1<=0 || num1 >100) || (num2<=0 || num2 >100)) {
            System.out.println("입력값은 0<num1,num2<=100 으로 제한됩니다.");

        }else {
            answer = num1/num2;
        }

        return answer;
    }
}

//문제 :두 수의 곱
//문제 설명 : 정수 num1, num2가 매개변수 주어집니다. num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120804

class Solution_0003 {
    public int solution(int num1, int num2) {

        int answer = 0;

        if ((num1<=0 || num1 >100) || (num2<=0 || num2 >100)) {
            System.out.println("입력값은 0<num1,num2<=100 으로 제한됩니다.");

        }else {
            answer = num1*num2;
        }

        return answer;
    }
}

//문제 :나이 출력
//문제 설명 : 머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 나이 age가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120820

class Solution_0004 {
    public int solution(int age) {
        int answer = 0;
        answer = 2022-age+1;
        return answer;
    }
}

//문제 :각도기
//문제 설명 : 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다. 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120829

class Solution_0005 {
    public int solution(int angle) {
        int answer = 0;
        switch (angle){
            case 90:
                answer = 2;
                break;
            case 180:
                answer = 4;
                break;
            default:
                if (angle<90) {
                    answer=1;
            }else {
                    answer=3;
                }
        }
        return answer;
    }
}

//문제 :숫자 비교하기
//문제 설명 : 정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 retrun하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120807
class Solution_0006 {
    public int solution(int num1, int num2) {
        int answer = 0;

        if ((num1<0)||(num1>10000)||(num2<0)||(num2>10000)){
            return answer;
        }
        if (num1 == num2) {
            answer = 1;
        } else {
            answer = -1;
        }

        return answer;
    }
}

//문제 :두 수의 차
//문제 설명 : 정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return하도록 soltuion 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120803
class Solution_0007 {
    public int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }
}

//문제 :두 수의 합
//문제 설명 : 정수 num1과 num2가 주어질 때, num1과 num2의 합을 return하도록 soltuion 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120802
class Solution_0008 {
    public int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }
}


//문제 :두 수의 나눗셈
//문제 설명 : 정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 soltuion 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120806
class Solution_0009 {
    public int solution(int num1, int num2) {
        int answer = (int)((num1/(float)num2)*1000);
        return answer;
    }
}

//문제 : 짝수의 합
//문제 설명 : 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120831
class Solution_0010 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i<=n; i++){
            if (i%2==0){
                answer += i;
            }
        }
        return answer;
    }
}

//문제 :배열의 평균값
//문제 설명 : 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120817
class Solution_0011 {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        int i;
        for (i = 0; i<numbers.length;i++) {
            sum += numbers[i];
        }
        answer = sum/(float)i;
        return answer;
    }
}

//문제 :양꼬치
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120830
class Solution_0012 {
    public int solution(int n, int k) {
        int answer = 0;
        if (n<0 || n/10>k){
            answer = -1;
        }
        answer = 12000*n+2000*(k-n/10);
        return answer;
    }
}

//문제 :점의 위치 구하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120841
class Solution_0013 {
    public int solution(int[] dot) {
        int answer = 0;
        if (dot.length != 2){
            answer = -1;
        }

        if (dot[0]==0 || dot[1]==0){
            answer = -1;
        }

        if (dot[0]>0){
            if(dot[1]>0){
                answer= 1;
            }else {
                answer=4;
            }
        } else {
            if(dot[1]>0){
                answer= 2;
            }else {
                answer=3;
            }
        }
        return answer;
    }
}

//문제 :아이스 아메리카노
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120819
class Solution_0014 {
    public int[] solution(int money) {
        int[] answer = {money/5500, money%5500};
        return answer;
    }

    public static void main(String[] args){
        int money = 100000;
        int[] answer = new int[2];
        System.out.println(money/5500);


        answer[0] = (money/5500);
        answer[1] = money%5500;

        System.out.println(answer[0]);

    }
}

//문제 : 피자 나눠 먹기(1)
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120814
class Solution_0015 {
    public int solution(int n) {
        int answer = 0;
        answer = (int)(n/7f+0.9);
        return answer;
    }
}

//문제 : 배열 뒤집기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120821
class Solution_0016 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for (int i=0;i<answer.length;i++){
            answer[i] = num_list[answer.length-1-i];
        }


        return answer;
    }
}

//문제 : 배열 원소의 길이
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120821
class Solution_0017 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i=0; i<strlist.length; i++){
            answer[i]= strlist[i].length();
        }

        return answer;
    }
}

//문제 : 삼각형의 완성조건(1)
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120889

//import java.util.Arrays;
class Solution_0018 {
    public int solution(int[] sides) {
        int answer = 2;
        int[] arr = sides;
        Arrays.sort(arr);
        if (sides[0]+sides[1]>sides[2]) {
            return 1;
        }
        return answer;
    }
}

//문제 : 문자열 뒤집기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120822
class Solution_0019 {
    public String solution(String my_string) {
        String answer = "";
        StringBuffer sb = new StringBuffer(my_string);
        answer = sb.reverse().toString();

        return answer;
    }
}

//문제 : 중복된 숫자 개수
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120583
class Solution_0020 {
    public int solution(int[] array, int n) {
        int answer = 0;
        for(int i =0; i<array.length; i++){
            if(array[i] == n){
                answer+=1;
            }
        }
        return answer;
    }
}

//문제 : 최댓값 만들기 (1)
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120847
//import java.util.Arrays;
class Solution_0021 {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = numbers;
        Arrays.sort(arr);

        return arr[arr.length-1] * arr[arr.length-2];
    }
}


//문제 : 특정 문자 제거하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120826
//풀이 : replace 기능으로 letter 를 ""로 바꿀 수 있다.
class Solution_0022 {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(int i=0; i<my_string.length();i++){
            if ( letter.charAt(0) != my_string.charAt(i)){
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}

//문제 : 중앙값 구하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120811
//import java.util.Arrays;
class Solution_0023 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        return array[array.length/2];
    }
}

//문제 : 순서쌍의 개수
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120836
class Solution_0024 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i<n+1; i++){
            if (n%i==0){
                answer +=1;
            }
        }
        return answer;
    }
}

//문제 : 제곱수 판별하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120909
class Solution_0025 {
    public int solution(int n) {
        if (Math.sqrt(n)%1==0){
            return 1;
        }
        return 2;
    }
}

//import java.util.Arrays;
//문제 : 약수 구하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120897
class Solution_0026 {
    public int[] solution(int n) {
        int[] answer = new int[n+1];
        if (n==1){
            return new int[]{1};
        }


        for (int i=1; i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                answer[i] = i;
                answer[n-1-i] = n/i;
            }
        }

        int[] hows = Arrays.stream(answer).distinct().toArray();



        return Arrays.copyOfRange(hows,1,hows.length);
    }
}


//import java.util.Arrays;
//import java.util.List;
//import java.util.ArrayList;

//문제 : 약수 구하기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120852
class Solution_0027 {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int i=2;
        while (i<=n){
            if(n%i==0){
                answer.add(i);
                n = n/i;
            } else {
                i++;
            }
        }
        int[] hows = Arrays.stream(answer.stream().mapToInt(x -> x).toArray()).distinct().toArray();
        return hows;
    }
}


//문제 : 합성수 찾기
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120846
class Solution_0028 {
    public int solution(int n) {
        int answer = 0;
        if (n < 4){
            return 0;
        }

        for (int i=4;i<n+1;i++){
            check : if (i%2 == 0){
                answer +=1;
            }else {
                for(int j=3;j<i;j++){
                    if(i%j==0){
                        answer +=1;
                        break check;
                    }
                }

            }
        }
        return answer;
    }
}


//-------------------------------------------------------------절취선-----------------------------------------





//문제 : 옹알이(1)
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120956
//import java.util.Arrays;
//중복제거 해줬더니 오답 처리하는 문제 ㅡㅡ;
class Solution_babbling {
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] how = new String[babbling.length];
        for (int i = 0; i<babbling.length;i++) {
            how[i] = check(babbling[i]);
        }

        String[] hows = Arrays.stream(how).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(hows));

        for (int i=0; i<how.length;i++){
            if (!how[i].equals("") ){
                answer +=1;
            }
        }

        return answer;
    }


    public static String check(String str){
        String res = "";

        while (true) {

            if (str.length()==0){
                System.out.println("딱잘려서 탈출");
                break;
            } else if (str.length()==1) {
                System.out.println("하나남기고 탈출");
                res = "";
                break;
            }

            String res_temp = res;
            System.out.println("와일 체크 시작 "+str+" "+res+" "+res_temp);

            try{
                if (str.substring(0,3).equals("aya")){
                    res += "aya";
                    str = str.substring(3);
                }}catch (Exception e){}

            try{
                if (str.substring(0,2).equals("ye")){
                    res += "ye";
                    str = str.substring(2);
                }}catch (Exception e){}

            try{
                if (str.substring(0,3).equals("woo")){
                    res += "woo";
                    str = str.substring(3);
                }}catch (Exception e){}

            try{
                if (str.substring(0,2).equals("ma")){
                    res += "ma";
                    str = str.substring(2);
                }}catch (Exception e){}

            System.out.println("와일 체크 끝 "+str+" "+res+" "+res_temp);
            if ((res_temp.equals(res)) && (str.length()==0)){
                break;
            } else if ((res_temp.equals(res)) && (str.length()>0)) {
                return  "";
            }
        }
        System.out.println("이게 나왔다 "+res);
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(solution(strs));
    }
}





//문제 : 다음에 올 숫자
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120924
class Solution_nextNumbers {
    public int solution(int[] common) {
        if (common[2]-common[1]==common[1]-common[0]){
           return common[common.length-1]+(common[1]-common[0]);
        } else {
           return common[common.length-1]*(common[1]/common[0]);
        }
    }
}





//문제 : 연속된 수의 합
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120923
class Solution_continuedNumbers {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        if (num%2==1){
            for(int i=0; i<num;i++){
                answer[i] = (total/num)-(num/2)+i;
            }
        }else {
            for(int j=0; j<num;j++){
                answer[j] = (total/num)-(num/2)+1+j;
            }
        }
        return answer;
    }
}


//문제 : OX퀴즈
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120907
//import java.util.Arrays;
class Solution_OXquiz{
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0 ; i< quiz.length; i++){
            answer[i] = check(quiz[i]);
        }
        return answer;
    }

    public String check(String quiz_solo){
        int first = Integer.parseInt(quiz_solo.split(" ")[0]);
        String calc = quiz_solo.split(" ")[1];
        int second = Integer.parseInt(quiz_solo.split(" ")[2]);
        int result = Integer.parseInt(quiz_solo.split(" ")[4]);
        char t = calc.charAt(0);
        //왜 char 로 받아야 할까 string =="-" 는 왜 안먹힐까

        if ((t == 43)&&(first+second==result)){
            return "O";
        }else if ((t == 45)&&(first-second==result)){
            return "O";
        }
        return "X";
    }
}


//문제 : 안전지대
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120866

class Solution_safezone {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] danger_place = new int[board.length][board.length];
//        System.out.println("시작해보자");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
//                System.out.println("이중포문 돌아가냐"+i+":"+j);
                if (board[i][j] == 1) {
                    finder(danger_place, i, j);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (danger_place[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        answer = cnt;
        return answer;
    }

    public int[][] finder(int[][] arr, int x, int y) {


        for (int xx = x - 1; xx < x + 2; xx++) {
            for (int yy = y - 1; yy < y + 2; yy++) {
                try {
                    arr[xx][yy] = 1;
                } catch (Exception e){
//                    System.out.println("범위 밖이네용 ^^"+xx+":"+yy);
                }
            }
        }
//        System.out.println("정답함 봐보자"+Arrays.deepToString(arr));
        return arr;
    }
}


//문제 : 분수의 덧셈
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120808
class Solution_AditionOfFraction {
    public int[] solution_add(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {1,1};

        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1*denom2;

        int big = 1;
        int lit = 1;
        int big_temp = 1;
        int lit_temp = 1;


        int divider = 1;
        if (numer>denom){
            big = numer;
            lit = denom;
        } else {
            big = denom;
            lit = numer;
        }
//        System.out.println(big);
//        System.out.println(lit);
        while (true){

            if (big%lit == 0){
                divider=lit;
                break;
            }else {
                big_temp = lit;
                lit_temp = big % lit;
                big = big_temp;
                lit = lit_temp;
            }
        }

//        System.out.println(divider);

        numer = numer/divider;
        denom = denom/divider;


//        System.out.println(numer);
//        System.out.println(denom);

        answer[0] = numer;
        answer[1] = denom;

//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}

//문제 : 평행
//문제 설명 : 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
//          [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
//          주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120875

class Solution_parallel {

    public int solution(int[][] dots) {
        int answer = 0;

        // case01,23
        int g1 = (dots[1][1]-dots[0][1])*(dots[3][0]-dots[2][0]);
        int g2 = (dots[3][1]-dots[2][1])*(dots[1][0]-dots[0][0]);
        // case02,13
        int k1 = (dots[2][1]-dots[0][1])*(dots[3][0]-dots[1][0]);
        int k2 = (dots[3][1]-dots[1][1])*(dots[2][0]-dots[0][0]);
        // case 03,12
        int j1 = (dots[2][1]-dots[1][1])*(dots[3][0]-dots[0][0]);
        int j2 = (dots[3][1]-dots[0][1])*(dots[2][0]-dots[1][0]);

        if ((g1==g2) || (k1==k2) || (j1==j2)){
            answer = 1;
        }

        return answer;
    }
}

//문제 : 겹치는 선분의 길이
//문제 설명 : 선분 3개가 평행하게 놓여 있습니다.
//          세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
//          두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120876


class Solution_overlaplines {

    public static void main (String[] args){

        int[][] ab = {{-1,1},{1,3},{3,9}};

        System.out.println(solution(ab));
    }


    public static int solution(int[][] lines) {
        int answer = 0;
        int[][] overlaps = new int[3][2];

        int min = -9999;
        int max = 9999;
        int[] dis = new int[3];

        min = lines[0][0] > lines[1][0] ? lines[0][0] : lines[1][0];
        max = lines[0][1] < lines[1][1] ? lines[0][1] : lines[1][1];

        if (min < max) {
            overlaps[0][0] = min;
            overlaps[0][1] = max;
            dis[0] = max-min;
        } else {
            overlaps[0][0] = -9999;
            overlaps[0][1] = 9999;
        }

        min = lines[1][0] > lines[2][0] ? lines[1][0] : lines[2][0];
        max = lines[1][1] < lines[2][1] ? lines[1][1] : lines[2][1];
        if (min < max) {
            overlaps[1][0] = min;
            overlaps[1][1] = max;
            dis[1] = max-min;
        } else {
            overlaps[1][0] = -9999;
            overlaps[1][1] = 9999;
        }

        min = lines[2][0] > lines[0][0] ? lines[2][0] : lines[0][0];
        max = lines[2][1] < lines[0][1] ? lines[2][1] : lines[0][1];
        if (min < max) {
            overlaps[2][0] = min;
            overlaps[2][1] = max;
            dis[2] = max-min;
        } else {
            overlaps[2][0] = -9999;
            overlaps[2][1] = 9999;
        }
//        System.out.println(Arrays.deepToString(overlaps));

        int total_min = -9999;
        int total_max = 9999;
        for (int i = 0; i<3;i++){
            total_min = total_min<overlaps[i][0] ? overlaps[i][0] : total_min;
            total_max = total_max>overlaps[i][1] ? overlaps[i][1] : total_max;
        }
//        System.out.println("total_min :" + total_min);
//        System.out.println("total_max :" +  total_max);


        int total_dis = dis[0]+dis[1]+dis[2];
//        System.out.println("dis만 더했을 때 :" + total_dis);
        int total_over = total_max - total_min;
        if (overlaps[0][1]+overlaps[1][1]+overlaps[2][1] >3000){

        }else {
            answer -= total_over *2;
        }
//        System.out.println(answer);
        answer += total_dis;

        return answer;
    }
}

