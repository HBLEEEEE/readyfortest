package lv1;


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
