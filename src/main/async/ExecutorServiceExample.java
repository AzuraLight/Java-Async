package main.async;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * ExecutorServiceExample 클래스는 Java의 ExecutorService를 사용하여 비동기 작업을 실행하는 방법을 보여주는
 * 예제입니다.
 * ExecutorService를 사용하여 단일 스레드 실행자를 생성하고, submit 메서드를 통해 비동기 작업을 실행합니다.
 * 이 예제에서는 덧셈 연산을 수행한 후 5초간 대기하는 간단한 비동기 작업을 제출합니다.
 * 작업 결과는 Future 객체를 통해 관리되며, get 메서드를 사용하여 비동기 작업의 결과를 동기적으로 가져옵니다.
 * 이 클래스는 ExecutorService를 활용한 비동기 작업 실행과 Future 인터페이스를 이용한 결과 관리 방법을 설명합니다.
 */
public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // ExecutorService를 이용해 단일 스레드 실행자 생성
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // submit 메서드를 사용하여 비동기 작업 실행 및 Future 객체 획득
        Future<Integer> future = executor.submit(() -> {
            System.out.println(LocalTime.now() + " Starting runnable");
            Integer sum = 1 + 1;
            Thread.sleep(5000); // 5초 대기
            return sum;
        });

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result = future.get(); // 작업 결과 기다리기
        System.out.println(LocalTime.now() + " Result : " + result);
    }
}
