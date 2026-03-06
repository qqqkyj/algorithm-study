import java.util.*;
import java.io.*;

// 준현(x): 가능한 만큼 매수
// 성민(y): 소유한 주식이 3일간 오르면 전량 매도, 3일간 하락하면 매수(전일과 동일하면 하락X)

public class boj20546 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int money = Integer.parseInt(st.nextToken());
    int[] arr = new int[14];
    int x = money, y = money;//준현, 성민이가 현재 가진 현금
    int x_cnt = 0, y_cnt = 0;//준현, 성민이가 매수한 주식의 수
    int up_cnt = 0;//연속 상승일
    int down_cnt = 0;//연속 하락일

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i] <= x) {
        x_cnt += x / arr[i]; //준현이가 매수한 주식 수
        x = x % arr[i]; //준현이의 남은 돈
      }

      if (i > 0 && arr[i - 1] < arr[i]) {
        up_cnt++;
        down_cnt = 0;
      }

      if (i > 0 && arr[i - 1] > arr[i]) {
        down_cnt++;
        up_cnt = 0;
      }

      if (i > 0 && arr[i - 1] == arr[i]) {
        up_cnt=0;
        down_cnt=0;
      }

      if(down_cnt>=3){//3일 연속 가격 하락
        if (arr[i] <= y) {
        y_cnt += y / arr[i]; //성민이가 매수한 주식 수
        y = y % arr[i]; //성민이의 남은 돈
        }
      }
      
      if(up_cnt>=3 && y!=0){//3일 연속 가격 상승
        y+= y_cnt*arr[i];//성민이의 남은 돈(주식을 매도)
        y_cnt=0;
      }

    }
    // System.out.println(Arrays.toString(arr));

    int x_total = x + x_cnt*arr[arr.length-1];
    int y_total = y + y_cnt*arr[arr.length-1];
    System.out.println(x_total > y_total ? "BNP" : x_total == y_total ? "SAMESAME" : "TIMING");
  }
}
