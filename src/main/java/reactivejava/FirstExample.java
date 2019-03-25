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

		
		//Java5 ���� �߰��� ���ü� API Callable �������̽�..
		Callable<String> callable = ()->{ //�񵿱� ������ ����� ��ȯ�ϴ� call() �޼ҵ� ����.
			Thread.sleep(1000);
			return "Hello Callable"; //������ ����
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		
		
		
		//�񵿱� ����� ����� ���Ҷ� ���.
		// 1. Executor �������̽��� ������ Ŭ������ (�̰�� newSingleThreadExecutor()�� ExecutorService�� ������.)
		// 2. Callable���ڸ� �־�
		// 3. Future ��ȯ. (submit())
		Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
			Thread.sleep(1000);
			return "Hello future";
		});
		Observable<String> futureSource = Observable.fromFuture(future);
		futureSource.subscribe(System.out::println);
		
	}
}
