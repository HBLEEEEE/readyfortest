//Programmers 코딩 테스트 lv0



//문제 : 나머지 구하기
//문제 설명 : 정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120810
class Solutio_0001{
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