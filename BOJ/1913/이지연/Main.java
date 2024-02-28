package Bj_1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] rows = {1, 0, -1, 0};  // 아래, 오른쪽, 위, 왼쪽
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] result = new int[n][n];
        int r = 0, c = 0, last = n*n + 1, dir = 0, newR, newC, resultR, resultC;
        while(true){
            if(r == n/2 && c == n/2){   // 중앙
                resultR = r;
                resultC = c;
                break;
            }



            result[r][c] = last - 1;

            if(result[r][c] == num){  // 찾음
                resultR = r;
                resultC = c;
            }

            // 좌표 이동
            newR = r + rows[dir];
            newC = c + cols[dir];
            if(newR < 0 || newR >= n || newC < 0 || newC >= n) {   // 범위에서 벗어나게 되면 방향을 바꿔야 한다.
                dir = (dir + 1) % 4;
            }
            r += rows[dir];
            c += cols[dir];
        }
    }
}
