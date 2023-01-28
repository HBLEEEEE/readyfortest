package lv1;
import java.security.KeyStore;
import java.time.LocalDate;
import java.util.*;


//문제 : 핸드폰 번호 가리기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12948

class Solution_0001 {
    public String solution(String phone_number) {
        String answer = "";
        int dis = phone_number.length();
        for (int i=0; i<dis-4;i++){
            answer += "*";
        }
        for (int i = dis-4;i<dis;i++){
            answer += phone_number.charAt(i);
        }
        return answer;
    }
}


//문제 : 서울에서 김서방 찾기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12919

class Solution_0002 {
    public String solution(String[] seoul) {
        int i =0;
        while (true){
            if (seoul[i].equals("Kim")){
                return "김서방은 "+i+"에 있다";
            }
            i++;
        }
    }
}

//문제 : 2016년
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12901
//import java.time.LocalDate;

class Solution_0003{
    public String solution(int a, int b) {
        String answer = "";

        LocalDate day = LocalDate.of(2016,a,b);
        answer = day.getDayOfWeek().toString();
        answer = answer.substring(0,3);

        return answer;
    }
}


//문제 : 나누어 떨어지는 숫자 배열
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12910
class Solution_0004 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        int index=0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                cnt += 1;
            }
        }
        if (cnt != 0){
            answer = new int[cnt];
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index++] = arr[i];
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}

//문제 : 수박수박수박수박수박수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12922
class Solution_0005_0 {
    public String solution(int n) {
        String answer = "";

        if (n % 2 == 0) {
            answer = "수박".repeat(n / 2);
        } else {
            answer = "수박".repeat(n / 2) + "수";
        }

        return answer;
    }
}
class Solution_0005_1 {
    public String solution(int n) {
        // char타입 기본값은 \0 또는 \u0000
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }
}


//import java.util.Arrays;
//문제 : 완주하지 못한 선수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42576
class Solution_0006_1 {
    public String solution(String[] participant, String[] completion) {

        List<String> list= new ArrayList<>(Arrays.asList(participant));


        for (String str : completion) {
            list.remove(str);
        }

        return list.get(0);
    }
}
class Solution_0006_2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (String str : participant) {
            if (map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else {
                map.put(str,1);
            }
        }
        for (String str: completion) {
            map.put(str, map.get(str)-1);
        }
        for (String str: participant){
            if (map.get(str)==1){
                return str;
            }
        }
        return answer;
    }
}


//import java.util.Arrays;
//문제 : 이상한 문자 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12930
class Solution_0007 {
    public String solution(String s) {
        String answer = "";
        String [] strArr = s.split(" ");
        for(String str: strArr){
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                if (i%2==0){
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                    str = sb.toString();
                }else {
                    sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                    str = sb.toString();
                }
            }
            answer += str + " ";
        }

        answer = answer.substring(0,answer.length()-1);
        int count = s.length() - answer.length();
        return answer + " ".repeat(count);
    }

    public String solution_0007_2(String s) {
        String answer = "";
        int index = 0;          // 가상으로 index 저장
        for (int i=0; i<s.length(); i++){
            System.out.print(index);
            if (s.charAt(i) == 32) {    // i번째 문자가 공백일 경우
                answer += " ";  //단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다. //answer에 공백 더하기
                index = 0;      //첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.     //공백 => index는 다시 0으로 저장
            } else if (index == 0 || index % 2 == 0) {          // index 0이거나 짝수면
                answer += Character.toUpperCase(s.charAt(i));   // 대문자를 더하고
                index++;                                        // index에 +1
            } else if (index%2 != 0){                            // index 홀수면
                answer += Character.toLowerCase(s.charAt(i));    // 소문자를 더하고
                index++;                                         // index에 +1
            }
        }
        return answer;
    }
}



//문제 : 자릿수 더하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12931
class Solution_0008 {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            answer += number.charAt(i)-'0';
        }
        return answer;
    }
}

//문제 : 자연수 뒤집어 배열로 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12932
class Solution_0009 {
    public long[] solution(long n) {

        ArrayList list = new ArrayList(10);
        while (n > 0) {
            list.add(new Long(n % 10));
            n /= 10;
        }
        long[] arr = list.stream().mapToLong(i -> (long) i).toArray();
        return arr;
    }
}

//문제 : 정수 내림차순으로 배치하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12933
class Solution_0010 {
    public static long solution(long n) {
        long answer = 0;
        String number = ""+n;
        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i)-'0';
        }
        Arrays.sort(arr);
        String temp = "";
        for (int i = arr.length-1; i >=0; i--) {
            temp += arr[i];
        }
        answer = Long.parseLong(temp);
        return answer;
    }
}

//문제 : 정수 제곱근 판별
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12934
class Solution_0011 {
    public long solution(long n) {

        if(Math.sqrt(n)%1==0){
            return (long)Math.pow(((long)(Math.sqrt(n))+1),2);
        } else {
            return -1;
        }
    }
}

//문제 : 제일 작은 수 제거하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12935
class Solution_0012 {
    public static int[] solution(int[] arr) {
        if (arr.length==1){
            return new int[]{-1};
        }
        int min = 99999999;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
                index = i;
            }
        }
        int[] answer = new int[arr.length-1];
        int j =0;
        for (int i = 0; i < answer.length; i++,j++) {
            if (i==index){
                j++;
            }
            answer[i] = arr[j];
        }
        return answer;
    }
}

//문제 : 콜라츠 추측
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12943
class Solution_0013 {
    public int solution(int num) {
        int cnt = 0;

        if (num == 1) {
            return 0;
        }

        return collatz(num,cnt);
    }

    public int collatz(long num, int cnt) {
        if (num == 1) {
            return cnt;
        }


        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }
        cnt++;

        if (cnt >= 500) {
            return -1;
        }

        return collatz(num, cnt);
    }
}

//문제 : 하샤드 수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12947
class Solution_0014 {
    public boolean solution(int x) {
        int num = x;
        int h = 0;
        while (num > 0){
            h += num%10;
            num /= 10;
        }
        if (x%h==0){
            return true;
        }else {
            return false;
        }
    }
}


//문제 : 3진법 뒤집기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/68935
class Solution_0015 {
    public int solution(int n) {
        int answer = 0;
        String third = "";
        while (n>0){
            third += Integer.toString(n%3);
            n = n/3;
        }
        int j=0;
        for (int i = third.length()-1; i >=0; i--,j++) {
            answer += (third.charAt(i)-'0')*Math.pow(3,j);
        }

        return answer;
    }
}

//문제 : 최소직사각형
//url : https://school.programmers.co.kr/learn/courses/30/lessons/86491
class Solution_0016 {
    public int solution(int[][] sizes) {

        int ll = 0;
        int ss = 0;
        int lmax = 0;
        int smax = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0]>=sizes[i][1]){
                ll = sizes[i][0];
                ss = sizes[i][1];
            } else {
                ss = sizes[i][0];
                ll = sizes[i][1];
            }

            lmax = ll>lmax? ll:lmax;
            smax = ss>smax? ss:smax;
        }


        return lmax*smax;

    }
}


//문제 : 같은 숫자는 싫어
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12906
class Solution_0017 {
    public int[] solution(int []arr) {


        ArrayList list = new ArrayList(10);

        if (arr.length==1){
            return arr;
        }

        int now = -1;
        for (int i = 0; i < arr.length; i++) {
            if (now != arr[i]){
                list.add(arr[i]);
                now = arr[i];
            }
        }
        int[] answer = list.stream().mapToInt(i ->(int)i).toArray();

        return answer;
    }
// 2배빠른 바닐라 코드
    public int[] solution_2(int []arr) {
        int[] answer ;
        int count = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i])
                count++;
        }
        answer = new int[count];

        count=1;

        answer[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                answer[count] = arr[i];
                count++;
            }
        }


        return answer;
    }
}


//문제 : 두 개 뽑아서 더하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/68644
class Solution_0018 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length*numbers.length];
        int d = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i==j){
                    answer[i+j+d] = -1;
                    continue;
                }
                answer[i+j+d] = numbers[i]+numbers[j];
            }
            d+= numbers.length-1;
        }

        answer = Arrays.stream(answer).distinct().toArray();
        Arrays.sort(answer);
        answer=Arrays.copyOfRange(answer,1,answer.length);
        return answer;
    }

    public int[] solution_01(int[] numbers) {  //정답을 담을 ArrayList 생성

        HashSet<Integer> set = new HashSet<Integer>();   //중복값을 지워줄 HashSet 생성

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);  //HashSet에 두 수의 합을 저장
            }
        }
        Integer[] answerInt = set.toArray(new Integer[0]);      // set -> Integer 배열로 전환하는거
        int[] answer = Arrays.stream(answerInt).mapToInt(Integer::intValue).toArray();      // Integer -> int배열 전환    //mapToInt올바른 동작을 유지   mapToInt(Integer::intValue)
        Arrays.sort(answer);
        //ArrayList<Integer>list=new ArrayList<>(set);  //Set은 순서가 없기때문에 ArrayList로 변환
        //list.sort(null);  // collrection.sort가 아닌 ArrayList의 sort를 사용

        return answer;
    }
}

//문제 : 로또의 최고 순위와 최저 순위
//url : https://school.programmers.co.kr/learn/courses/30/lessons/77484
class Solution_0019 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeros = 0;
        int[] answer = new int[2];
        for (int pick : lottos){
            if(pick == 0){
                zeros +=1;
            }
            for (int luck : win_nums){
                if (pick ==luck){
                    cnt +=1;
                }
            }
        }
        if (zeros==6){
            answer[0] = 1;
            answer[1] = 6;
        }else {
            answer[0]=7-zeros-cnt;
            answer[1]=7-cnt;
            if (cnt==0){
                answer[1]=6;
                if (zeros==0){
                    answer[0]=6;
                }
            }
        }
        return answer;
    }
}

//문제 : 모의고사
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42840
//import java.util.Arrays;
class Solution_0020 {
    public int[] solution(int[] answers) {
        int[] res = new int[3];
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == stu1[i%5]){
                res[0] += 1;
            }
            if(answers[i] == stu2[i%8]){
                res[1] += 1;
            }
            if(answers[i] == stu3[i%10]){
                res[2] += 1;
            }
        }
        System.out.println(Arrays.toString(res));
        int max = 0;
        int cnt = 0;
        for(int i:res){
            max = i>max? i:max;
        }
        System.out.println(max);
        int[] total = {0,0,0};
        for (int i = 0; i < 3; i++) {
            if (res[i]==max){
                total[cnt] = i+1;
                cnt +=1;
            }
        }
        System.out.println(Arrays.toString(total));
        total=Arrays.copyOfRange(total,0,cnt);

        return total;
    }
}

//문제 : 문자열 내 마음대로 정렬하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12915
//import java.util.Arrays;
//import java.util.HashMap;
class Solution_0021 {
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length-1; j++) {
                if(ChangeForSort(strings[j],strings[j+1],n)){
                    String temp = strings[j];
                    strings[j]=strings[j+1];
                    strings[j+1] = temp;
                }
            }
        }

        return strings;
    }



    public static boolean ChangeForSort(String str1, String str2, int num){

        str1 = str1.substring(num,num+1);
        str2 = str2.substring(num,num+1);
        String[] arr = {str1,str2};
        Arrays.sort(arr);
        if (arr[0].equals(str1)){
            return false;
        } else {
            return true;
        }

    }


    public static void main(String[] args) {
        String[] quiz = {"xawdasdz", "awdqwbcd", "cdawdasdx","abdasd","aadasd","acdasd"};
        System.out.println(Arrays.toString(solution(quiz,3)));


    }

    public String[] solution__2(String[] strings, int n) {
        String[] answer = new String[strings.length];

        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i].substring(n),i);
        }

        String[] check = new String[strings.length];
        for (int i = 0; i < check.length; i++) {
            check[i] = strings[i].substring(n);
        }

        Arrays.sort(check);
        for (int i = 0; i < check.length; i++) {
            answer[i] = strings[map.get(check[i])];
        }

        return answer;
    }



}

//문제 : 문자열 내림차순으로 배치하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12917
//import java.util.Arrays;
class Solution_0022 {
    public String solution(String s) {
        String answer = "";

        String[] res = s.split("");
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        for (int i = res.length-1; i >= 0 ; i--) {
            answer += res[i];
        }
        return answer;
    }
}

//문제 : 소수 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12977
//import java.util.Arrays;
class Solution_0023 {
    public int solution(int[] nums) {
        int answer = -1;
        int[] sums = new int[nums.length*(nums.length-1)*(nums.length-2)/6+1];
        int cnt = 1;
        int input = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                lastfor : for (int k = j+1; k < nums.length; k++) {
                    input = nums[i]+nums[j]+nums[k];
                    for (int l = 2; l <= Math.sqrt(input) ; l++) {
                        if(input%l==0){
                            continue lastfor;
                        }
                    }
                    sums[cnt]=input;
                    cnt++;
                }
            }
        }
        sums = Arrays.copyOfRange(sums,1,cnt);
        answer = sums.length;
        return answer;
    }
}

//문제 : 숫자 문자열과 영단어
//url : https://school.programmers.co.kr/learn/courses/30/lessons/81301
//import java.util.Arrays;
//import java.util.List;
//import java.util.ArrayList;
class Solution_0024 {
    public int solution(String s) {
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> numbers = new ArrayList<>(Arrays.asList(arr));
        String newans = "";
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='9'){
                newans += String.valueOf(s.charAt(i));

            }else {
                temp += String.valueOf(s.charAt(i));
                if (numbers.contains(temp)){
                    newans += numbers.indexOf(temp);
                    temp = "";
                }
            }
        }
        answer = Integer.parseInt(newans);

        return answer;
    }
}

//문제 : 시저 암호
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12926
class Solution_0025 {
    public static String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==32){
                answer += " ";
            } else if (64<s.charAt(i)&&s.charAt(i)<91){
                answer += Character.toString((s.charAt(i)-65+n)%26+65);
            } else if (96<s.charAt(i)&&s.charAt(i)<123) {
                answer += Character.toString((s.charAt(i)-97+n)%26+97);
            }
        }
        return answer;
    }
}

//문제 : 신규 아이디 추천
//url : https://school.programmers.co.kr/learn/courses/30/lessons/72410
class Solution_0026 {
    public static String solution(String new_id) {
        String answer = "";

        //1단계
        new_id = new_id.toLowerCase();

        System.out.println("1단계 통과 후 : "+ new_id);

        //2단계  - _ .

        String check = "~!@#$%^&*()=+[{]}:?,<>/";
        for (int i = 0; i < new_id.length(); i++) {

            if (!check.contains(Character.toString(new_id.charAt(i)))) {
                answer+=Character.toString(new_id.charAt(i));
            }
        }

        System.out.println("2단계 통과 후 : "+ answer);

        //3단계
        new_id = "";
        int cnt = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i)=='.'){
                if (cnt<1){
                    new_id += Character.toString(answer.charAt(i));
                    cnt +=1;
                }
            }else {
                cnt = 0;
                new_id += Character.toString(answer.charAt(i));
            }
        }
        System.out.println("3단계 통과 후 : "+ new_id);

        //4단계
        if (new_id.charAt(0)=='.'){
            new_id = new_id.substring(1);
        }
        try{
            if (new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }catch (Exception e){

        }

        System.out.println("4단계 통과 후 : "+ new_id);

        //5단계

        if (new_id.length()==0){
            new_id += "a";
        }

        System.out.println("5단계 통과 후 : "+ new_id);

        //6단계
        if (new_id.length()>15){
            new_id=new_id.substring(0,15);
            if (new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        System.out.println("6단계 통과 후 : "+ new_id);

        //7단계
        while (new_id.length()<3){
            new_id += Character.toString(new_id.charAt(new_id.length()-1));
        }

        System.out.println("7단계 통과 후 : "+ new_id);

        return new_id;
    }


    public static void main(String[] args) {
        System.out.println(solution("=.="));


    }
}




//------------------------------------------------------------------------------------


//문제 : [1차] 다트 게임
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17682

class Solution_DartGame {
    public static int solution(String dartResult) {
        int answer = 0;
        int[] scores = {0,0,0};
        int[] bonus = {1,1,1};
        int cnt = 0;

        for (int i=0; i<3;i++) {
//            System.out.println("들어간다 : "+dartResult);
//            System.out.println(Arrays.toString(scores));
//            System.out.println(Arrays.toString(bonus));

            if (dartResult.charAt(1) > 47 && dartResult.charAt(1) < 58) {
                scores[i] = Integer.parseInt(dartResult.substring(0, 2));
                cnt += 2;
            } else {
                scores[i] = Integer.parseInt(dartResult.substring(0, 1));
                cnt += 1;
            }

            switch (dartResult.charAt(cnt)) {
                case 83:
                    scores[i] *= 1;
                    break;
                case 68:
                    scores[i] *= scores[i];
                    break;
                case 84:
                    scores[i] *= scores[i]*scores[i];
                    break;
            }
            cnt += 1;
            try {
                if (dartResult.charAt(cnt) == 42) {
                    bonus[i] *= 2;
                    cnt += 1;
                    try {
                        bonus[i - 1] *= 2;
                    } catch (Exception e) {

                    }
                } else if (dartResult.charAt(cnt) == 35) {
                    bonus[i] *= -1;
                    cnt += 1;
                }
            }catch (Exception f){

            }

            dartResult = dartResult.substring(cnt);
//            System.out.println("나온다 : "+dartResult);
//            System.out.println(Arrays.toString(scores));
//            System.out.println(Arrays.toString(bonus));
            cnt = 0;

        }

        for (int i=0; i<3;i++){
            answer += scores[i]*bonus[i];
        }


        return answer;
    }

    public static void main(String[] args) {
        String test = "1S*2T*3S";

        System.out.println(solution(test));
    }


}




