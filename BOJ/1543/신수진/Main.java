package backjoon_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static int i = 0;          // doc 포인터의 시작 지점 결정
    static String doc, words; // 전체 문자열 doc, 검색하려는 단어 words
    static int count = 0;     // 중복 제외 최대 단어 등장 횟수

    public static void main(String[] args) throws IOException {
        // 전체 문자열과 검색 단어는 공백을 포함하여 한 문장으로 읽는다.
        doc = br.readLine();
        words =  br.readLine();

        int d = doc.length();   // 전체 문자열 길이
        int w = words.length(); // 검색 단어 길이


        // doc 길이 - words 길이 + 1 = 전체 문자열 순회 횟수 (고정)
        // 두 개의 포인터를 doc, words에 두고 반복문을 실행한다.

        // while문 : doc 포인터에 관여
        while (i < d-w+1) {
            // i는 전체 문자열 길이의 시작 인덱스를 결정하는 역할을 한다.
            int start = i;

            // 반복 중단 여부 판단 플래그
            boolean flag = false;

            // for문 : words 포인터에 관여
            for (int j = 0; j < w; j++) {
                // 각 포인터가 가리키는 첫 문자가 동일하지 않으면
                if (doc.charAt(start) != words.charAt(j)) {
                    // 곧바로 반복을 중단하고, 다음 구간으로 이동한다.
                    i += 1; // 시작 인덱스 + 1 (다음 구간으로 이동)

                    // 반복 중단 시, true로 변경
                    flag = true;

                    // 해당 구간에서의 탐색을 중단한다.
                    break;
                } else {
                    // 각 포인터가 가리키는 첫 문자가 동일하다면
                    // doc의 시작 지점만 +1 처리한 후, 다시 words와 비교한다.
                    start += 1;
                }
            }

            // 반복을 중단한 적이 없다면? 일치 구간이 존재한다는 의미
            if (!flag) {
                count += 1; // 일치 횟수 집계

                // doc 시작 지점을 중복을 고려하여 words 길이만큼 증가시킨다.
                i += w;
            }
        }

        System.out.println(count);
    }
}
