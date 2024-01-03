package main.async;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TimeoutExample 클래스는 Java의 Future 인터페이스를 사용하여 비동기 작업에 타임아웃을 설정하는 방법을 보여주는
 * 예제입니다.
 * ExecutorService를 이용하여 단일 스레드 실행자를 생성하고, 비동기 작업으로 덧셈 연산 후 4초간 대기하는 작업을 실행합니다.
 * Future 객체의 get 메서드에 타임아웃을 지정하여, 지정된 시간 내에 작업이 완료되지 않으면 TimeoutException을
 * 발생시킵니다.
 * 이 클래스는 비동기 작업의 실행, 타임아웃 설정, 예외 처리 방법을 보여주며, 타임아웃을 통한 비동기 작업 관리 방법을 설명합니다.
 */
public class TimeoutExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ExecutorService를 이용해 단일 스레드 실행자 생성
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // submit 메서드로 비동기 작업 실행 및 Future 객체 획득
        Future<Integer> future = executor.submit(() -> {
            System.out.println(LocalTime.now() + " Starting runnable");
            Integer sum = 1 + 1;
            Thread.sleep(4000); // 4초 대기
            System.out.println(LocalTime.now() + " Exiting runnable");
            return sum;
        });

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result = null;
        try {
            // 결과를 2초 안에 가져오기를 시도, 실패 시 TimeoutException 발생
            result = future.get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println(LocalTime.now() + " Timed out");
            result = 0; // 타임아웃 시 결과를 0으로 설정
        }
        System.out.println(LocalTime.now() + " Result : " + result);
    }
}
