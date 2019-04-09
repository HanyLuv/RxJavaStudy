package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FirstExample {

	public static void main(String[] args) {
	
			//flatMap() 결과값이 Observable 이므로 여러개의 데이터를 발행 할수있음 !!
		
		Function<String, Observable<String>> getDiamonds = ball -> Observable.just(ball+"<>",ball+"<>");
		
		String[] balls = {"1","3","5"};
//		Observable<String> source = Observable.fromArray(balls).flatMap(getDiamonds);
		Observable<String> source = Observable.fromArray(balls).flatMap(ball -> Observable.just(ball+"<>",ball+"<>")); //인라인
		source.subscribe(System.out::println);
		
		
	}
}
