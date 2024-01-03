package main.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FutureTaskExample 클래스는 FutureTask를 사용하여 비동기 작업을 정의하고 실행하는 방법을 보여주는 예제입니다.
 * FutureTask는 Runnable과 Future 인터페이스를 모두 구현하며, 비동기 작업의 정의와 실행을 분리할 수 있게 해줍니다.
 * 이 예제에서는 Callable을 이용하여 2초간 대기 후 문자열 "Hello"를 반환하는 간단한 비동기 작업을 정의합니다.
 * 정의된 FutureTask는 ExecutorService를 통해 실행되며, 작업의 완료 여부를 확인하고 결과를 가져올 수 있습니다.
 * 이 클래스는 FutureTask의 사용법과 비동기 작업의 실행, 결과 처리 방법을 보여줍니다.
 */
public class FutureTaskExample {

    private static final Logger log = LoggerFactory.getLogger(FutureTaskExample.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newCachedThreadPool();

        // 비동기 작업 정의 - FutureTask 생성자에 Callable을 전달하여 비동기 작업을 정의한다.
        FutureTask<String> f = new FutureTask<>(() -> {
            Thread.sleep(2000);
            log.info("Async");
            return "Hello";
        });

        // 작업 실행 분리 - ExecutorService의 execute 메서드로 FutureTask를 실행한다.
        // 작업 정의(인스턴스 생성)와 실행 분리
        es.execute(f);

        // 작업 상태 확인 및 결과 가져오기
        log.info(String.valueOf(f.isDone())); // 작업 완료 여부 확인
        Thread.sleep(2000); // 메인 스레드 대기
        log.info("Exit");
        log.info(String.valueOf(f.isDone())); // 작업 완료 여부 재확인
        log.info(f.get()); // 결과 가져오기
    }
}