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
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class FirstExample {

	public static void main(String[] args) {
		
		//1. 기존 Observable에서 Single객체로 변환하기
		Observable<String> source = Observable.just("Hello Single!");
		Single.fromObservable(source).subscribe(data->
		 System.out.println(data)
		);
		
		
		//2. Single 함수를 호출해 Single 객체 생성하기
		Observable.just("Hello Single~","ㄸㄷㄷ")
		.single("default item") //값이 발행되지 않을때에 해당값을 넣어 발행해줌
		.subscribe(System.out::println);
		
		
		//3. First() 함수를 호출해 Single 객체 생성하기
		//여러개의 데이터를 발행 할 수 있는 Observable을Single객체로 변환한것.
		String[] color = {"red",
				"orenge",
				"green"
		};
		
		Observable.fromArray(color)
		.first("default value")
		.subscribe(System.out::println);
		
		
		
		//4. empty Observable에서 Single 객체 생성하기
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		
		
		//5. take()함수에서 Single객체 생성하기
		Observable.just(new User("hany"), new User("mongmang")).take(1)
		.single(new User("default name"))
		.subscribe(System.out::println);
		
		/**!! Single은 데이터 한개만 발행!! */
		}
}
