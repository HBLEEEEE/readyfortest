package lv1;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Scanner;

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

//문제 : 약수의 개수와 덧셈
//url : https://school.programmers.co.kr/learn/courses/30/lessons/77884
class Solution_0027 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right ; i++) {
            answer += count_division(i)*i;

        }

        return answer;
    }
    public int count_division(int num){
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if(num%i==0){
                cnt += 2;
            }
        }
        if (Math.sqrt(num)%1==0){
            cnt += 1;
        }
        if (cnt%2==0){
            return 1;
        }else {
            return -1;
        }
    }
}


//문제 : 약수의 합
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12928
class Solution_0028 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if(n%i==0){
                answer += i + n/i;
            }
        }
        if (Math.sqrt(n)%1==0){
            answer += Math.sqrt(n);
        }

        return answer;
    }
}


//문제 : 예산
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12982
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Collections;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;

class Solution_0029 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> list = IntStream.of(d).boxed().collect(Collectors.toList());
        int possible = 0;
        while (true){
            int min = Collections.min(list);
            list.remove(Integer.valueOf(min));
            if (possible+min<=budget){
                answer += 1;
                possible += min;
            }
            if(possible> budget || list.size()==0){
                break;
            }
        }
        return answer;
    }
    public int solution2(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if(sum>budget){
                break;
            }
            answer += 1;
        }
        return answer;
    }
}


//문제 : 최대공약수와 최소공배수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12940


class Solution_0030 {
    public int[] solution(int n, int m) {

        int devide = gcd(n,m);
        int multiple = n*m/devide;
        int[] answer = {devide, multiple};

        return answer;
    }
    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }



}

//문제 : K번째수
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42748
//import java.util.Arrays;

class Solution_0031 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[(commands[i][2])-1];
        }
        return answer;
    }
}

//문제 : 나머지가 1이 되는 수 찾기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/87389

class Solution_0032 {
    public int solution(int n) {

        for (int i = 1; i < n; i++) {
            if(n%i==1){
                return i;
            }
        }
        return -1;
    }
}

//문제 : 소수 찾기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12921

class Solution_0033 {
    public int solution(int n) {
        int answer = 0;
        answer = prime_check(n);
        return answer;
    }
    public int prime_check(int n){
        int ans = 0;
        if (n==2){
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            cnt : for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j==0){
                    ans -= 1;
                    break cnt;
                }
            }
            ans +=1;
        }
        return ans;
    }
}

//문제 : 실패율
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42889
class Solution_0034 {
    public int[] solution(int N, int[] stages) {
        int[] people = new int[N+1];
        double[] fail = new double[N+1];
        for (int i = 0; i < stages.length; i++) {

            people[stages[i]-1] += 1;
        }

        int down = stages.length;
        for (int i = 0; i < people.length; i++) {
            fail[i] = people[i]/(double)down;
            down -= people[i];
        }

        fail = Arrays.copyOfRange(fail,0,fail.length-1);

        return sortbyvalue_returnindex(fail);
    }

    public int[] sortbyvalue_returnindex(double[] d){
        int temp_index = -1;
        int[] res = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            res[i] = i+1;
        }
        double temp;
        for (int i = 0; i < d.length; i++) {
            for (int j = i; j < d.length; j++) {
                if(d[i]<d[j]){
                    temp_index = res[i];
                    temp = d[i];
                    res[i] = res[j];
                    res[j] = temp_index;
                    d[i] = d[j];
                    d[j] = temp;
                } else if (d[i]==d[j] && res[i]>res[j]) {
                    temp_index = res[i];
                    res[i] = res[j];
                    res[j] = temp_index;
                }
            }
        }
        return res;
    }
}

//문제 : 체육복
//url : https://school.programmers.co.kr/learn/courses/30/lessons/42862

class Solution_0035 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+2]; //편의상 학생 번호가 1부터 시작함으로 0번째랑 마지막 +1번째는 나중에 버리자
        //체육복 없으면 -1, 있으면 0, 빌려줄수있으면 1

        //잃어버린 애들 계산
        for (int no : lost){
            students[no] -= 1;
        }

        //여벌있던 애들 계산
        for (int rent : reserve){
            students[rent] += 1;
        }

        for (int i = 1; i < students.length-1; i++) {
            if (students[i]== -1){
                if(students[i-1]==1){
                    students[i]+=1;
                    students[i-1] -= 1;
                } else if (students[i+1]==1) {
                    students[i] += 1;
                    students[i+1] -= 1;
                }
            }
        }
        students[0]=-1;
        students[students.length-1]=-1;


        for (int i = 0; i < students.length; i++) {
            if(students[i]>=0){
                answer+=1;
            }
        }

        return answer;
    }
}

//문제 : 폰켓몬
//url : https://school.programmers.co.kr/learn/courses/30/lessons/1845
//import java.util.Arrays;

class Solution_0036 {
    public int solution(int[] nums) {
        int answer = nums.length/2;

        nums = Arrays.stream(nums).distinct().toArray();
        if (nums.length<answer){
            answer = nums.length;
        }

        return answer;
    }
}

//문제 : [1차] 비밀지도
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17681
//import java.util.Arrays;

class Solution_0037 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = TenToN(arr1[i],arr2[i],n);
            System.out.println(map[i]);
            map[i] = map[i].replaceAll("[12]","#");
            map[i] = map[i].replaceAll("[0]"," ");
        }
        return map;
    }
    public static String TenToN(int c1, int c2, int n){

        String res = "";
        int div = (int) Math.pow(2,n-1);
        for (int i = 0; i < n; i++) {
            res += (c1/div) + (c2/div);
            c1= c1%div;
            c2 = c2%div;
            div = div/2;
        }
        return res;
    }
}

class Solution_0038 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        // key postion 0>9
        int[][] key_position = {{1,0},{0,3},{1,3},{2,3},{0,2},{1,2},{2,2},{0,1},{1,1},{2,1}};
        //[0]은 왼손    [1]은 오른손
        int[][] now = {{0,0},{2,0}};

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                now[0] = key_position[i];
                answer += "L";
            } else if (i == 3 || i == 6 || i == 9) {
                now[1] = key_position[i];
                answer += "R";
            } else {
                if (which_hand_go(now, i, hand)) {
                    now[0] = key_position[i];
                    answer += "L";
                } else {
                    now[1] = key_position[i];
                    answer += "R";
                }
            }
            System.out.println(answer);
        }
        return answer;
    }

    public Boolean which_hand_go(int[][] before, int key, String hand){
        // key postion 0>9
        int[][] key_position = {{1,0},{0,3},{1,3},{2,3},{0,2},{1,2},{2,2},{0,1},{1,1},{2,1}};
        System.out.println(Arrays.deepToString(before));
        System.out.println(Arrays.toString(key_position[key]));

        int left_check = Math.abs(before[0][0]-key_position[key][0])+
                Math.abs(before[0][1]-key_position[key][1]);
        int right_check = Math.abs(before[1][0]-key_position[key][0])+
                Math.abs(before[1][1]-key_position[key][1]);
        if (hand.equals("right")){
            if(right_check<=left_check){
                return false;
            }else {
                return true;
            }
        } else {
            if(right_check>=left_check){
                return true;
            }else {
                return false;
            }
        }
    }
}


//문제 : [1차] 다트 게임
//url : https://school.programmers.co.kr/learn/courses/30/lessons/17682

class Solution_0039 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = {0,0,0};
        int[] bonus = {1,1,1};
        int cnt = 0;

        for (int i=0; i<3;i++) {
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
            cnt = 0;

        }
        for (int i=0; i<3;i++){
            answer += scores[i]*bonus[i];
        }
        return answer;
    }

    public int solution_2(String dartResult) {
        int index = -1;
        int[] score = new int[3];
        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);
            if(now >='0' && now <= '9'){
                index++;
                if (dartResult.charAt(i+1)>='0'&& dartResult.charAt(i+1)<= '9'){
                    score[index]= Integer.parseInt(dartResult.substring(i,i+2));
                    i++;
                }else {
                    score[index]= Character.getNumericValue(now);
                }

            } else if (now=='D') {
                score[index]*= score[index];
            } else if (now=='T') {
                score[index]*= score[index]*score[index];
            } else if (now=='*') {
                score[index]*=2;
                if (index>0){
                    score[index-1]*=2;
                }
            } else if (now=='#') {
                score[index] *= -1;
            }
        }
        return score[0]+score[1]+score[2];
    }
}



//문제 : 최댓값과 최솟값
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12939
class Solution_0040 {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int [] values = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        int max = values[0];
        int min = values[0];
        for (int i : values){
            max = Math.max(i,max);
            min = Math.min(i,min);
        }

        answer += min + " " + max;

        return answer;
    }
}

//문제 : 숫자의 표현
//url : https://school.programmers.co.kr/learn/courses/30/lessons/12924
class Solution_0041 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n/2; i++) {
            int j = 0;
            int sum = 0;
            finder : while (true){
                sum += i+j;
                if (sum==n){
                    answer+=1;
                    break finder;
                }else if (sum>n){
                    break finder;
                }
                j++;
            }
        }
        return answer+1;
    }

    public static int sol2(int n){

        int ans = 0;
        int c = 0;
        for (int i = 0; i <= n/2; i++) {
            c = i+1;
            while (true){
                if((i+c)*(c-i+1)/2==n){
                    ans += 1;
                    System.out.println(i+"    "+ c);
                    break;
                } else if ((i+c)*(c-i+1)/2>n) {
                    break;
                }
                c++;
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        sol2(15);
    }




}

//문제 : 크레인 인형뽑기 게임
//url : https://school.programmers.co.kr/learn/courses/30/lessons/64061
class Solution_0042 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] box = new int[board.length * board.length];
        int cnt = 1;

        for (int pick : moves){
            take : for (int i = 0; i < board.length; i++) {
                if(board[i][pick-1] != 0){
                    box[cnt] = board[i][pick-1];
                    board[i][pick-1] = 0;
                    if (box[cnt]==box[cnt-1]){
                        box[cnt]=0;
                        box[cnt-1]=0;
                        answer+=2;
                        cnt -= 2;
                    }
                    cnt++;
                    break take;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0, 0, 1, 0, 3}, {0, 2, 5, 0, 1},{4, 2, 4, 4, 2},{3, 5, 1, 3, 1}};
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board,move));



    }
}

//문제 : 최빈값 구하기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/120812
class Solution_0046 {
    public static int solution(int[] array) {

        Arrays.sort(array);
        int[] cnt = new int[array.length];
        int index = 0;

        cnt[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i]==array[i-1]){
                cnt[index] +=1;
            }else {
                index = i;
                cnt[index] +=1;
            }
        }

        int max_cnt = 0;
        int max_index = 0;
        int max_index_second = -1;

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]>max_cnt){
                max_cnt = cnt[i];
                max_index = i;
            } else if (cnt[i]==max_cnt) {
                max_index_second = max_index;
            }
        }
        if(max_index==max_index_second){
            return -1;
        }

        return array[max_index];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4,4,4,5};
        solution(arr);
    }
}

//문제 : 햄버거 만들기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/133502
//import java.util.Arrays
//import java.util.ArrayList;
//import java.util.stream.Stream;
//import java.util.stream.Collectors;
class Solution_0047 {
    public int solution(int[] ingredient) {
        int answer = 0;
        String hamburger= "";
        for (int i : ingredient) {
            hamburger += i;
        }
        int check = ingredient.length;
        while (true){
            hamburger = hamburger.replaceFirst("1231","");
            if (check == hamburger.length()){
                break;
            }
            answer +=1;
            check = hamburger.length();
        }
        return answer;
    }

    public int solution0_0(int[] ingredient) {
        int answer = 0;
        String hamburger= "";
        for (int i : ingredient) {
            hamburger += i;
        }
        int check = ingredient.length;
        while (true){
            hamburger = hamburger.replaceAll("1231","");
            if (check == hamburger.length()){
                break;
            }
            answer += (check - hamburger.length())/4;
            check = hamburger.length();
        }
        return answer;
    }

    public int solution1(int[] ingredient) {
        int answer = 0;
        if (ingredient.length<4){
            return 0;
        }

        String ham = "";

        for (int i = 0; i < ingredient.length; i++) {
            ham += ingredient[i];
            try {
                if (ham.substring(ham.length()-4).equals("1231")){
                    answer +=1;
                    ham = ham.substring(0,ham.length()-4);
                }
            }catch (Exception e){

            }
        }
        return answer;
    }

    public int solution2(int[] ingredient) {
        int answer = 0;
        if (ingredient.length<4){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<> (Arrays.stream(ingredient).boxed().collect(Collectors.toList()));

        for (int i = 0; i < list.size(); i++) {
            if (i>2){
                if (list.get(i)==1){
                    if(list.get(i-1)==3&&list.get(i-2)==2&&list.get(i-3)==1){
                        list.remove(i);
                        list.remove(i-1);
                        list.remove(i-2);
                        list.remove(i-3);
                        answer++;
                        i -= 3;
                    }
                }
            }
        }

        return answer;
    }
    public int solution_fastestanswer(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }

}

//문제 : 개인정보 수집 유효기간
//url : https://school.programmers.co.kr/learn/courses/30/lessons/150370
class Solution_0048 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];

        HashMap term = new HashMap();
        for (String tm : terms) {
            term.put(tm.charAt(0), Integer.parseInt(tm.substring(2)));
        }
        System.out.println(term);

        int oneul = Integer.parseInt(today.substring(0,4))*28*12+
                Integer.parseInt(today.substring(5,7))*28+
                Integer.parseInt(today.substring(8,10));

        System.out.println(oneul);


        int cnt = 0;
        int[] failday = new int[privacies.length];
        for (int i = 0; i < privacies.length; i++) {
            failday[i]= Integer.parseInt(privacies[i].substring(0,4))*28*12+
                    Integer.parseInt(privacies[i].substring(5,7))*28+
                    Integer.parseInt(privacies[i].substring(8,10))-1-oneul+
                    (int)term.get(privacies[i].charAt(11))*28;

            if (failday[i]<0){
                answer[cnt] = i+1;
                cnt++;
                System.out.println("쓰레기는 제거해야해");
            }
        }
        answer = Arrays.copyOfRange(answer,0,cnt);


        return answer;
    }
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};


        System.out.println(Arrays.toString(solution(today,terms,privacies)));

    }
}



//문제 : 문자열 나누기
//url : https://school.programmers.co.kr/learn/courses/30/lessons/140108
class Solution_0049 {
    public static int solution(String s) {
        int answer = 0;
        int cnt = 0;
        int cnt2 = 0;
        char now = '0';
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            if (cnt == 0 ){
                now = s.charAt(i);
                cnt +=1;
                res += s.charAt(i);
                System.out.println("초기화!");
            }else {
                if (s.charAt(i)== now){
                    cnt+=1;
                    System.out.println("같냐");

                }else {
                    cnt2+=1;
                    System.out.println("다르냐");
                }
                res += s.charAt(i);
            }
            if(cnt==cnt2){
                res += " ";
                cnt = 0;
                cnt2 = 0;
                System.out.println("띄어 쓰기 내보내도 되냐");
            }

        }

        System.out.println("res : " + res);
        String[] reses = res.split(" ");
        answer = reses.length;



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abracadabra"));
    }
}






//-----------------------------------------------------------------------------------------------------
//백준 : 정답 입력 양식

//import java.util.Scanner;
class Solution_input{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Hello World!");
    }
}


//import java.util.Scanner;
class Solution_1043{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int old_num= n;
        int new_num;
        int cnt = 0;



        while (true){


            new_num = (old_num%10)*10 + (old_num/10+old_num%10)%10;

            cnt++;
            if (new_num == n){
                System.out.println(cnt);
                break;
            }
            old_num = new_num;
        }

    }
}

//import java.util.Scanner;
class Solution_1045{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a ;
        a = sc.nextInt();

        int cnt = 0;

        int div_5 = a/5;
        cnt += div_5;

        int check = 0;
        for (int i = 0; i < 3; i++) {
            if((a%5+5*i)%3==0){
                if((a-5*i)<0){
                    break;
                }
                cnt -=i;
                cnt += (a%5+5*i)/3;
                check = 1;
                break;
            }
        }

        if( check == 0){
            cnt = -1;
        }

        System.out.println(cnt);
    }
}


//
//문제 : OX퀴즈
//url : https://www.acmicpc.net/problem/8958
//import java.util.Scanner;
class Solution_1046{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        String str;
        n = sc.nextInt();
        String[] arr = new String[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            str = sc.next();
            arr[i] = str;
        }

        for (int i = 0; i < n; i++) {
            int score = 0;
            int index = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j)=='O'){
                    index +=1;
                    score +=index;
                } else {
                    index =0;
                }
            }
            res[i] = score;
        }
        int i =0;
        while (i<n){
            System.out.println(res[i++]);
        }
    }
}

//문제 : 거스름돈
//url : https://www.acmicpc.net/problem/5585
//import java.util.Scanner;
class Solution_1047 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        int take = 1000-n;
        int ans = 0;
        int k = 500;
        while (true){
            ans += take/k;
            take = take%k;
            k /= 5;
            ans += take/k;
            take = take%k;
            k /= 2;
            if (take==0){
                break;
            }
        }

        System.out.println(ans);

    }
}

