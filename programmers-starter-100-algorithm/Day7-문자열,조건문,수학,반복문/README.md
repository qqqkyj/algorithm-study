# 25. **특정 문자 제거하기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120826

**💡문제 풀이**

```java
    class Solution {
        public String solution(String my_string, String letter) {
            String[] str = my_string.split("");
            StringBuffer answer = new StringBuffer();

            for(String s : str)
            {
                answer.append(s.equals(letter) ? "" : s);
            }

            return answer.toString();
        }
    }
```

# 26. **각도기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120829

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int angle) {
            return angle == 180 ? 4 : angle > 90 ? 3 : angle == 90 ? 2 : 1;
        }
    }
```

# 27. **양꼬치** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120830

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int n, int k) {
            return 12000 * n + 2000 * (k - n/10);
        }
    }
```

# 28. **짝수의 합** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120831

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=1; i<=n ; i++)
            {
                if(i%2==0)
                    answer+=i;
            }
            return answer;
        }
    }
```
