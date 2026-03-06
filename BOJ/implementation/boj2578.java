import java.util.*;
import java.io.*;

public class boj2578{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] arr = new int[5][5];

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        int call = Integer.parseInt(st.nextToken());
        cnt++;

        //동일한 숫자를 불렀다면 0으로 변경
        for (int x = 0; x < 5; x++) {
          boolean flag = false;
          for (int y = 0; y < 5; y++) {
            if (call == arr[x][y]) {
              flag = true;
              arr[x][y] = 0;
              // System.out.println(call + "=" + Arrays.deepToString(arr));
              break;
            }
          }
          if (flag)
            break;
        }
        if (cnt >= 12 & isBinggo(arr)) {
          System.out.println(cnt);
          return;
        }
      }
    }
  }
  
  //빙고 여부
  public static boolean isBinggo(int[][] arr) {
    int cnt = 0;
    boolean flag = true;

    //가로 빙고 체크
    for (int i = 0; i < 5; i++) {
      flag = true;
      for (int j = 0; j < 5; j++) {
        if (arr[i][j] != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        cnt++;
    }

    //세로 빙고 체크
    for (int i = 0; i < 5; i++) {
      flag = true;
      for (int j = 0; j < 5; j++) {
        if (arr[j][i] != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        cnt++;
    }

    //왼쪽 대각선 체크
    for (int i = 0; i < 5; i++) {
      flag = true;
      if (arr[i][i] != 0) {
        flag = false;
        break;
      }
    }
    if (flag)
      cnt++;

    //오른쪽 대각선 체크
    for (int i = 0; i < 5; i++) {
      flag = true;
      if (arr[i][4-i] != 0) {
        flag = false;
        break;
      }
    }
    if (flag)
      cnt++;

    return cnt >= 3 ? true : false;
  }

}