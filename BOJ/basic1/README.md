# 📚 알고리즘 기초 정리

알고리즘 문제 해결을 위해 자주 사용되는 **시간 복잡도, 자료구조, 수학 알고리즘, 문자열 처리, 다이나믹 프로그래밍** 등을 정리한 문서입니다.

---

# 📖 주요 학습 내용

- 시간 복잡도 (Time Complexity)
- 자료구조
  - Stack
  - Queue
  - Deque
- 문자열 처리
- 최대공약수 (GCD)
- 최소공배수 (LCM)
- 소수
- 에라토스테네스의 체
- 진법 변환
- 조합
- 다이나믹 프로그래밍 (DP)

---

# ⏱ 시간 복잡도 (Time Complexity)

시간 복잡도는 **입력 크기 n이 증가할 때 알고리즘의 연산 횟수가 얼마나 증가하는지**를 나타낸다.

일반적으로 **Big-O 표기법**을 사용한다.

## Big-O 표기법

| 시간 복잡도 | 의미      |
| ----------- | --------- |
| O(1)        | 상수 시간 |
| O(log n)    | 로그 시간 |
| O(n)        | 선형 시간 |
| O(n log n)  | 선형 로그 |
| O(n²)       | 이차 시간 |
| O(2ⁿ)       | 지수 시간 |

---

## 시간 복잡도 예시 (1부터 n까지의 합)

### 반복문 사용

```java
int sum = 0;
for(int i = 1; i <= n; i++){
    sum += i;
}

```

연산 횟수

```
1 + 2 + ... + n
```

시간 복잡도

```
O(n)
```

---

### 수학 공식 사용

공식

```
1 + 2 + ... + n = n(n+1)/2
```

```java
int sum = n*(n+1)/2;
```

시간 복잡도

```
O(1)
```

👉 같은 문제라도 **알고리즘에 따라 시간 복잡도가 크게 달라질 수 있다.**

---

# 📦 자료구조

자료구조는 **데이터를 효율적으로 저장하고 관리하기 위한 구조**이다.

알고리즘 문제에서 자주 사용하는 자료구조

- Stack
- Queue
- Deque

---

# 📚 Stack

## 특징

- **LIFO (Last In First Out)**
- 후입선출 구조

## 주요 연산

| 연산    | 설명                 |
| ------- | -------------------- |
| push    | 데이터 삽입          |
| pop     | 데이터 제거          |
| peek    | top 값 확인          |
| isEmpty | 스택 비어있는지 확인 |

## 시간 복잡도

| 연산 | 시간 복잡도 |
| ---- | ----------- |
| push | O(1)        |
| pop  | O(1)        |
| peek | O(1)        |

## 활용

- 괄호 검사
- 후위 표기식 계산
- DFS
- 재귀 구조

---

# 📚 Queue

## 특징

- **FIFO (First In First Out)**
- 선입선출 구조

## 주요 연산

| 연산            | 설명              |
| --------------- | ----------------- |
| offer / enqueue | 데이터 삽입       |
| poll / dequeue  | 데이터 제거       |
| peek            | 맨 앞 데이터 확인 |

## 시간 복잡도

| 연산    | 시간 복잡도 |
| ------- | ----------- |
| enqueue | O(1)        |
| dequeue | O(1)        |
| peek    | O(1)        |

## 활용

- BFS (너비 우선 탐색)
- 작업 스케줄링
- 프린터 대기열

---

# 📚 Deque

## 특징

- **Double Ended Queue**
- 양쪽에서 삽입 / 삭제 가능

## 주요 연산

| 연산        | 설명        |
| ----------- | ----------- |
| addFirst    | 앞에 삽입   |
| addLast     | 뒤에 삽입   |
| removeFirst | 앞에서 삭제 |
| removeLast  | 뒤에서 삭제 |

시간 복잡도

```
O(1)
```

## 활용

- 슬라이딩 윈도우
- BFS 최적화
- 양방향 탐색

---

# 🔤 문자열 처리

알고리즘 문제에서 **문자열 처리**는 매우 자주 등장한다.

## 문자열 뒤집기

```java
StringBuilder sb=new StringBuilder(str);
sb.reverse();
```

## 문자 개수 세기

```java
int[] arr = new int[26];

for(char c :str.toCharArray()){
	arr[c-'a']++;
}
```

---

# 🔢 최대공약수 (GCD)

두 수의 **공통 약수 중 가장 큰 수**

예

```
GCD(12,18) = 6
```

## 유클리드 호제법

```
GCD(a,b) = GCD(b, a % b)
```

### Java 구현

```java
static int gcd(inta,intb){
	while(b!=0){
		int r=a%b;
		a=b;
		b=r;
		    }
	return a;
}
```

시간 복잡도

```
O(log n)
```

---

# 🔢 최소공배수 (LCM)

두 수의 **공통 배수 중 가장 작은 수**

공식

```
LCM(a,b) = a × b / GCD(a,b)
```

---

# 🔢 소수 (Prime Number)

**1과 자기 자신만 약수로 가지는 수**

예

```
2 3 5 7 11 13 ...
```

소수 판별 방법

```
2 ~ √n 까지만 나누어 보면 된다.
```

```java
static boolean isPrime(intn){

	if(n<2)return false;

	for(int i=2; i*i<=n; i++){
		if(n%i==0)return false;
		    }

	return true;
}
```

시간 복잡도

```
O(√n)
```

---

# 🔢 에라토스테네스의 체

**1부터 N까지 모든 소수를 구하는 알고리즘**

아이디어

1. 2부터 시작
2. 해당 수의 배수를 제거
3. 남은 수가 소수

```java
static boolean[] sieve(intn){

	boolean[] prime = new boolean[n+1];
	Arrays.fill(prime,true);

	prime[0]=prime[1]=false;

	for(int i=2; i*i<=n; i++){

		if(prime[i]){

			for(int j=i*i; j<=n; j+=i){
			prime[j]=false;
			            }

		        }

	    }

	return prime;
}
```

시간 복잡도

```
O(n log log n)
```

---

# 🔢 진법 변환

컴퓨터에서는 **다양한 진법 변환**이 사용된다.

| 진법   | 설명        |
| ------ | ----------- |
| 2진수  | Binary      |
| 8진수  | Octal       |
| 10진수 | Decimal     |
| 16진수 | Hexadecimal |

## 진법 변환 방법

나눗셈을 반복하여 나머지를 역순으로 읽는다.

예

```
10 / 2 = 5 ... 0
5 / 2 = 2 ... 1
2 / 2 = 1 ... 0
1 / 2 = 0 ... 1
```

결과

```
1010
```

---

# 🔢 조합 (Combination)

n개 중 r개를 선택하는 경우의 수

공식

```
nCr = n! / (r! (n-r)!)
```

예

```
5C2 = 10
```

---

# 🧠 다이나믹 프로그래밍 (DP)

큰 문제를 **작은 문제로 나누어 해결하고
이미 계산한 결과를 저장하여 재사용하는 알고리즘 기법**

즉

```
중복 계산을 제거하여 시간 복잡도를 줄이는 방법
```

---

## DP 조건

### 1️⃣ Overlapping Subproblem

같은 작은 문제가 **반복 등장**

예

```java
F(n) = F(n-1) + F(n-2)
```

---

### 2️⃣ Optimal Substructure

큰 문제의 최적 해가 **작은 문제의 최적 해로 구성**

---

## 구현 방식

### Top-Down (메모이제이션)

```java
static int[] dp=new int[100];

static int fib(intn){

	if(n<=2) return 1;

	if(dp[n]!=0) return dp[n];

	return dp[n] = fib(n-1) + fib(n-2);
}
```

---

### Bottom-Up

```java
static int fib(intn){

	int[] dp = new int[n+1];

	dp[1]=1;
	dp[2]=1;

	for(int i=3; i<=n; i++){
		dp[i]=dp[i-1]+dp[i-2];
		    }

	return dp[n];
}
```

---

# 📌 정리

| 분야          | 핵심 개념             |
| ------------- | --------------------- |
| 시간 복잡도   | Big-O                 |
| 자료구조      | Stack / Queue / Deque |
| 문자열        | 문자열 처리           |
| 수학          | GCD / LCM / 소수      |
| 소수 알고리즘 | 에라토스테네스의 체   |
| 진법          | Base Conversion       |
| 조합          | nCr                   |
| DP            | 중복 계산 제거        |
