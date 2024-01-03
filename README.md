# Java Async Programming Examples

이 프로젝트는 자바에서 비동기 프로그래밍을 다루는 여러 가지 방법을 보여주는 예제들을 포함합니다.

## 기능

- CompletableFuture를 사용한 비동기 프로그래밍
- ExecutorService와 Future를 사용한 비동기 작업 실행
- FutureTask를 활용한 비동기 작업 관리
- Future 인터페이스의 isDone 메서드를 사용한 작업 완료 여부 확인
- Future 인터페이스와 타임아웃 설정

## 사용 방법

### CompletableFuture 예제

`CompletableFutureExample` 클래스는 CompletableFuture를 활용하여 비동기 작업을 수행하는 방법을 보여줍니다.

```java
CompletableFuture<Integer> future = new CompletableFuture<>();
Executors.newCachedThreadPool().submit(() -> {
    Integer sum = 1 + 1;
    Thread.sleep(3000);
    future.complete(sum);
    return null;
});
```

### ExecutorService 예제

`ExecutorServiceExample` 클래스는 ExecutorService와 Future를 사용하여 비동기 작업을 실행하는 방법을 보여줍니다.

```java
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(() -> {
    Integer sum = 1 + 1;
    Thread.sleep(5000);
    return sum;
});
```

### FutureTask 예제

`FutureTaskExample` 클래스는 FutureTask를 사용하여 비동기 작업을 정의하고 실행하는 방법을 보여줍니다.

```java
FutureTask<String> futureTask = new FutureTask<>(() -> {
    Thread.sleep(2000);
    return "Hello";
});
es.execute(futureTask);
```

### isDone 예제

`isDoneExample` 클래스는 Future 인터페이스의 isDone 메서드를 사용하여 비동기 작업의 완료 여부를 확인하는 방법을 보여줍니다.

```java
Future<String> future = es.submit(() -> {
    Thread.sleep(2000);
    return "Hello";
});
future.isDone(); // 작업 완료 여부 확인
```

### 타임아웃 예제

`TimeoutExample` 클래스는 Future 인터페이스를 사용하여 비동기 작업에 타임아웃을 설정하는 방법을 보여줍니다.

```java
Future<Integer> future = executor.submit(() -> {
    Thread.sleep(4000);
    return 1 + 1;
});
future.get(2000, TimeUnit.MILLISECONDS); // 2초 타임아웃 설정
```

## 설치

이 프로젝트를 사용하기 위해서는 Java 8 이상이 필요합니다.

## 라이센스

이 프로젝트는 MIT 라이센스 하에 배포됩니다.
