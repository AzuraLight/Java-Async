package main.async;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * CompletableFutureExample 클래스는 Java의 CompletableFuture를 활용하여 비동기 프로그래밍을 구현한
 * 예제입니다.
 * 이 예제에서는 Executors 클래스를 사용하여 캐시된 스레드 풀을 생성하고, CompletableFuture 인스턴스를 통해 비동기
 * 작업을 수행합니다.
 * 비동기 작업은 덧셈 연산 후 3초간 대기하는 간단한 작업으로, 이를 CompletableFuture 객체로 완료시킵니다.
 * 메인 스레드는 future.get()을 호출하여 비동기 작업의 결과를 기다리고, 결과가 준비되면 출력합니다.
 * 이 클래스는 비동기 작업의 실행과 결과 처리 방법을 보여주며, CompletableFuture의 기본 사용법을 설명합니다.
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // CompletableFuture 인스턴스 생성
        CompletableFuture<Integer> future = new CompletableFuture<>();

        // 새로운 스레드에서 비동기 작업 수행
        Executors.newCachedThreadPool().submit(() -> {
            System.out.println(LocalTime.now() + " Doing something...");
            Integer sum = 1 + 1;

            try {
                Thread.sleep(3000); // 3초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            future.complete(sum); // 비동기 작업 완료 및 결과 설정
            return null;
        });

        System.out.println(LocalTime.now() + " Waiting the task done...");
        Integer result = future.get(); // 작업 결과 기다리기
        System.out.println(LocalTime.now() + " Result: " + result);

    }

}
