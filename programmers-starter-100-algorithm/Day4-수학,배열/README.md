# 13. 피자 나눠 먹기 (1) (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120814

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int n) {
            int answer = n%7==0 ? n/7 : n/7 + 1;
            return answer;
        }
    }
```

# 14. 피자 나눠 먹기 (2) (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120815

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int n) {
            int answer = n%6==0 ? n/6 : n%3==0 ? n/3 : n%2==0 ? n/2 : n;
            return answer;
        }
    }
```

# 15. **피자 나눠 먹기 (3)** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120816

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int slice, int n) {
            int answer = n%slice == 0 ? n/slice : (n/slice) + 1;
            return answer;
        }
    }
```

# 16. **배열의 평균값** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120817

---

**💡문제 풀이**

```java
    class Solution {
        public double solution(int[] numbers) {
            double answer = 0;
            for(int num : numbers){
                answer+=num;
            }
            return answer/numbers.length;
        }
    }
```
