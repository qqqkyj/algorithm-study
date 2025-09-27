# 9. **나머지 구하기**

https://school.programmers.co.kr/learn/courses/30/lessons/120810

---

**💡문제 풀이**

```java
class Solution {
    public int solution(int num1, int num2) {
        int answer = num1%num2;
        return answer;
    }
}
```

# 10. 중앙값 구하기(버블 정렬)

https://school.programmers.co.kr/learn/courses/30/lessons/120811

---

**💡문제 풀이**

```java
class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for(int i=0; i < array.length-1; i++){
            for(int j=i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }

        return array[(int)(array.length/2)];
    }
}
```

# 11. **최빈값 구하기(HashMap)**

https://school.programmers.co.kr/learn/courses/30/lessons/120812

---

**💡문제 풀이**

```java
import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++)
        {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1 );
            // array[i]의 key가 있다면 value+1, 없다면 map에 (array[i],1)을 추가
        }

        int maxFreqKey = 0;
        int maxFreqValue = 0;
        for(int a : map.keySet())
        {
            //map의 value들 중 가장 큰 값을 가지는 key,value 구하기
            if(maxFreqValue < map.get(a))
            {
                maxFreqKey = a;
                maxFreqValue = map.get(a);
            }
        }

        int cnt=0;
        for(int value : map.values())
        {
            //maxFreqValue가 value인 개수 구하기
            if(value == maxFreqValue)
                cnt++;
        }

        return cnt == 1 ? maxFreqKey : -1;
    }
}
```

# 12. 짝수는 싫어요(단순 수열 생성)

https://school.programmers.co.kr/learn/courses/30/lessons/120813

---

**💡문제 풀이**

```java
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];// 1~n까지의 홀수의 개수
        for(int i = 1 ; i <= n; i++){
            if(i % 2 != 0)//홀수
                answer[(i-1)/2] = i;//홀수만 배열에 저장
        }

        return answer;
    }
}
```
