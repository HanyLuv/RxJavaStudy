package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FirstExample {

	public static void main(String[] args) {
		
		
		//인자로 전달받는값, 반환값
		Function<String, Integer> ballToIndex = ball-> {
			switch (ball) {
			case "RED":	return 1;
			case "YELLOW":	return 2;
			case "GREEN":	return 3;
			case "BLUE":	return 5;
			default: return -1;
			}
		}; //람다 표현의 몸체는 {}안에 있어야하나, 문장이 한개면 생략가능 'ㅅ')
		
		String[] balls = {"RED","YELLOW","GREEN","BLUE"};
		Observable<Integer> source = Observable.fromArray(balls).map(ballToIndex);
		
		source.subscribe(new Consumer<Integer>() {
		public void accept(Integer t) throws Exception {
			System.out.println(t);
		};
		});
		
		
	}
}
