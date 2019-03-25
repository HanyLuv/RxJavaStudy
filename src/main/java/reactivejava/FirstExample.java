package reactivejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Observable;


public class FirstExample {
	
	public static void main(String[] args) {

		
		//Java5 에서 추가된 동시성 API Callable 인터페이스..
		Callable<String> callable = ()->{ //비동기 싱행후 결과를 반환하는 call() 메소드 정의.
			Thread.sleep(1000);
			return "Hello Callable"; //실행결과 리턴
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		
		
		
		//비동기 계산의 결과를 구할때 사용.
		// 1. Executor 인터페이스를 구현한 클래스에 (이경우 newSingleThreadExecutor()는 ExecutorService를 리턴함.)
		// 2. Callable인자를 넣어
		// 3. Future 반환. (submit())
		Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
			Thread.sleep(1000);
			return "Hello future";
		});
		Observable<String> futureSource = Observable.fromFuture(future);
		futureSource.subscribe(System.out::println);
		
	}
}
