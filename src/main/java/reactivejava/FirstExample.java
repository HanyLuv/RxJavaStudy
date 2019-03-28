package reactivejava;

import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;

import io.reactivex.observables.ConnectableObservable;

public class FirstExample {

	public static void main(String[] args) {
//		 System.out.println("Subscriber ");
		String[] dt = {"1","3","5"};
//		Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS) //시간, 시간단위
//		.map(Long::intValue)
//		.map(i-> dt[i])
//		.take(dt.length);
		Observable<String> balls = Observable.fromArray(dt);
		ConnectableObservable<String> source = balls.publish();
		source.subscribe(data -> System.out.println("Subscriber #1 => "+data));
		source.subscribe(data -> System.out.println("Subscriber #2 => "+data));
		source.connect();
		
		
	}
}
