package main.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * isDoneExample 클래스는 Java의 Future 인터페이스의 isDone 메서드를 사용하여 비동기 작업의 완료 여부를 확인하는
 * 방법을 보여주는 예제입니다.
 * Executors.newCachedThreadPool()을 사용하여 새로운 스레드 풀을 생성하고, submit 메서드로 비동기 작업을
 * 실행합니다.
 * 이 예제에서 비동기 작업은 2초간 대기 후 "Hello" 문자열을 반환합니다.
 * 메인 스레드는 isDone 메서드를 호출하여 작업의 완료 여부를 확인하고, 결과를 기다린 후 출력합니다.
 * 이 클래스는 Future 인터페이스의 기능을 활용하여 비동기 작업의 상태를 모니터링하는 방법을 설명합니다.
 */
public class isDoneExample {

    private static final Logger log = LoggerFactory.getLogger(isDoneExample.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // ExecutorService를 이용해 새로운 스레드 풀 생성
        ExecutorService es = Executors.newCachedThreadPool();

        // submit 메서드로 비동기 작업 실행 및 Future 객체 획득
        Future<String> f = es.submit(() -> {
            Thread.sleep(2000);
            log.info("Async");
            return "Hello";
        });

        log.info(String.valueOf(f.isDone())); // 작업 완료 여부 확인
        Thread.sleep(2000); // 메인 스레드 대기
        log.info("Exit");
        log.info(String.valueOf(f.isDone())); // 작업 완료 여부 재확인
        log.info(f.get()); // 결과 가져오기
    }
}
