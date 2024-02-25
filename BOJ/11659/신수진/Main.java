package backjoon_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // BufferedReaader 선언 : Enter를 기준으로 구분 (한 문장 단위로 받는다.)
    // 버퍼 공간에 저장해두었다가 한 번에 내보낸다. (속도 UP)
    // 입력 받은 값을 나눠줘야 하므로 코드가 길어지는 단점이 존재한다.
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    // StringTokenizer 선언
    // BufferedReader를 통해 입력 받은 한 문장을 공백 기준으로 문자 단위로 분리한다.
    static StringTokenizer st;

    static int N, M; // 배열 원소 개수 N, 구간 합 내 원소 개수 M

    static int[] nums;

    // BufferedReader 사용 시, main 함수에서 IOException 처리 필수!
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 Enter까지의 한 문장을 받는다.
        // 한 줄에 들어온 문자열을 StringTokenizer를 이용해 공백 기준으로 나눈다.
        // 배열 원소 개수(N)와 구간합 내 원소 개수(M)이 공백으로 구분하여 입력된다.
        st = new StringTokenizer(br.readLine());

        // 공백 기준으로 나눈 문자 중 처음 들어온 문자(배열 원소 개수)를 저장한다.
        // 문자 형태이므로 정수형으로 변환한다.
        N = Integer.parseInt(st.nextToken());

        // 공백 기준으로 나눈 문자 중 두 번째로 들어온 문자(구간합 내 원소 개수)를 저장한다.
        // 문자 형태이므로 정수형으로 변환한다.
        M = Integer.parseInt(st.nextToken());

        // 한 줄로 입력 받은 문자열을 정수형 배열로 만든다.
        // 1) 입력 받은 문자열 한 줄을 공백 기준으로 나눠 문자열 배열을 만든다.
        // 2) 배열 속 문자열을 정수로 변환한다. => mapToInt(Integer:parseInt)
        // 3) toArray() 메서드를 사용하여 최종적으로 정수형 배열을 만든다.
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        // 배열에 대한 누적 합 배열을 생성한다.
        // nums = [5, 4, 3, 2, 1]일 경우,
        // 누적 합 배열 nums = [5, 9, 12, 14, 15]
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        //
        for (int i = 0; i < M; i++) {
            // 입력 받은 값으로 i번 째 수와 j번 째 수를 지정한다.
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 특정 구간에 해당되는 구간합을 구한다.
            System.out.println(nums[end-1] - (start == 1? 0 : nums[start-2]));
        }
    }
}
