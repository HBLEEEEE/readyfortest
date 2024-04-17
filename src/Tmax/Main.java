package Tmax;

import java.util.Arrays;

class Solution001 {
    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            answer[i] = calCredit(score[i]);
        }

        return answer;
    }

    public static int calCredit(int[] personal) {

        Arrays.sort(personal);

        float sum = 0;
        for (int i = 1; i < personal.length - 1; i++) {
            sum += personal[i];
        }

        sum /= (personal.length - 2);

        if (sum > 900) {
            return 1;
        } else if (sum > 800) {
            return 2;
        } else if (sum > 700) {
            return 3;
        } else if (sum > 600) {
            return 4;
        } else if (sum > 500) {
            return 5;
        } else if (sum > 400) {
            return 6;
        } else if (sum > 300) {
            return 7;
        } else if (sum > 200) {
            return 8;
        } else {
            return 9;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{200, 300, 300, 300, 400};
        System.out.println(calCredit(arr));
    }
}

class Solution02 {
    public int solution(int[][] dice) {
        int answer = 0;

        //0~9까지 개수를 담기
        int[] nums = new int[10];

        for (int i = 0; i < dice.length; i++) {
            Arrays.sort(dice[i]);
            for (int j = 0; j < dice[0].length; j++) {

                if (j == 0) {
                    nums[dice[i][j]] += 1;
                } else {
                    if (dice[i][j] != dice[i][j - 1]) {
                        nums[dice[i][j]] += 1;
                    }
                }
            }
        }

        for (int i = 1; i <= 10000; i++) {
            int[] copiedNums = Arrays.copyOf(nums, nums.length);

            if (i < 10) {
                if (nums[i] == 0) {
                    return i;
                }
            } else if (i < 100) {
                int a = i / 10;
                int b = i % 10;
                copiedNums[a] -= 1;
                copiedNums[b] -= 1;
                if (checkMinus(copiedNums)) {
                    return i;
                }
            } else if (i < 1000) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;
                copiedNums[a] -= 1;
                copiedNums[b] -= 1;
                copiedNums[c] -= 1;
                if (checkMinus(copiedNums)) {
                    return i;
                }
            } else if (i < 10000) {
                int a = i / 1000;
                int b = (i % 1000) / 100;
                int c = (i % 100) / 10;
                int d = i % 10;
                copiedNums[a] -= 1;
                copiedNums[b] -= 1;
                copiedNums[c] -= 1;
                copiedNums[d] -= 1;
                if (checkMinus(copiedNums)) {
                    return i;
                }
            } else {
                return 1000;
            }

        }

        return answer;
    }

    public boolean checkMinus(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                return true;
            }
        }
        return false;
    }
}

class Solution03 {

    static int[][] globalDiet;
    static int answer = 0;
    static int total;
    static int maxCnt;

    public static int solution(int[][] diet) {
        globalDiet = diet;
        maxCnt = diet.length;

        for (int i = 0; i < diet.length; i++) {
            answer += diet[i][0];
        }

        for (int i = 0; i < 3; i++) {
            int cnt = 1;
            total = diet[0][i];
            eat(i, total, cnt, i);

        }

        return answer;
    }

    public static void eat(int n, int total, int c, int raw) {
        if (c == maxCnt) {
            if (total < answer) {
                answer = total;
                return;
            } else {
                return;
            }
        }
        if (total > answer) {
            return;
        }

        if (raw == 0) {

            eat(n + 3, total + globalDiet[(n + 3) / 3][0], c + 1, raw);
        } else if (raw == 1) {
            for (int i = 2; i <= 3; i++) {

                eat(n + i, total + globalDiet[(n + i) / 3][(n + i) % 3], c + 1, (raw + i) % 3);
            }
        } else if (raw == 2) {
            for (int i = 1; i <= 3; i++) {
                eat(n + i, total + globalDiet[(n + i) / 3][(n + i) % 3], c + 1, (raw + i) % 3);
            }
        }

    }
}













































