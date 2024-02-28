package prg_255904;

class Solution {
    static int[] rows = {0, 1, 0, -1};  // 위, 오른쪽, 아래, 왼쪽
    static int[] cols = {1, 0, -1, 0};

    public int[] solution(String command) {
        int[] answer = {0, 0};
        int dir = 0;

        for(int i=0; i<command.length(); i++){
            char c = command.charAt(i);

            if(c == 'R'){
                dir = (dir + 1) % 4;
            }else if(c == 'L'){
                dir = (dir + 4 - 1) % 4;
            }else if(c == 'G'){
                answer[0] += rows[dir];
                answer[1] += cols[dir];
            }else if(c == 'B'){
                answer[0] -= rows[dir];
                answer[1] -= cols[dir];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String command = "GRGRGRB";
        int[] result = new Solution().solution(command);
        System.out.println(result[0] + " " + result[1]);
    }
}