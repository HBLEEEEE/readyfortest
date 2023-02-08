package lv2;

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