package lv1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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




