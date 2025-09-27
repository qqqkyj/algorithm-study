# 17. **옷가게 할인 받기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120818

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int price) {
            double answer = price >= 500000 ? 0.8*price : price >= 300000 ? 0.9*price : price >= 100000 ? 0.95*price :price;
             return (int)answer;
        }
    }
```

# 18. **아이스 아메리카노** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120819

---

**💡문제 풀이**

```java
    class Solution {
        public int[] solution(int money) {
            int[] answer = {money/5500, money%5500};
            return answer;
        }
    }
```

# 19. **나이 출력** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120820

---

**💡문제 풀이**

```java
    class Solution {
        public int solution(int age) {
            int answer = 2023-age;
            return answer;
        }
    }
```

# 20. **배열 뒤집기** (Lv.0)

https://school.programmers.co.kr/learn/courses/30/lessons/120821

---

**💡문제 풀이**

```java
    class Solution {
        public int[] solution(int[] num_list) {
            int[] answer = new int[num_list.length];
            for(int i = 0; i < num_list.length; i++){
                answer[i] = num_list[num_list.length-1-i];
            }
            return answer;
        }
    }
```
