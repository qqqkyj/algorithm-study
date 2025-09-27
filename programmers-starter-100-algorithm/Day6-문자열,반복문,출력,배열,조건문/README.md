# 21. **뒤집힌 문자열** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120822

---

**💡문제 풀이**

```java
    class Solution {
        public String solution(String my_string) {
            String answer = "";
            String[] str = my_string.split("");

            for(int i = 0 ; i < str.length ; i++){
                answer += str[str.length - i - 1];
            }

            return answer;
        }
    }
```

# 22. **직각삼각형 출력하기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120823

---

**💡문제 풀이**

```java
    import java.util.Scanner;

    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String str="";

            for(int i=1 ; i <= n ; i++)
            {
                for(int j=1 ; j <= i ; j++)
                {
                    str += "*";
                }
                str += "\n";
            }

            System.out.println(str);
        }
    }
```

# 23. **짝수 홀수 개수** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120824

---

**💡문제 풀이**

```java
    class Solution {
        public int[] solution(int[] num_list) {
            int[] answer = new int[2];

            for(int num : num_list){
                answer[num % 2 == 0 ? 0 : 1]++;
            }

            return answer;
        }
    }
```

# 24. **문자 반복 출력하기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120825

---

**💡문제 풀이**

```java
    class Solution {
        public String solution(String my_string, int n) {
            String[] str = my_string.split("");
            StringBuffer answer = new StringBuffer();

            for(int i=0; i<str.length; i++){
                answer.append(str[i].repeat(n));
            }

            return answer.toString();
        }
    }
```
