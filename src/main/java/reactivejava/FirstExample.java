package reactivejava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class FirstExample {

	public static void main(String[] args) {
			
		PublishSubject<String> publishSubject = PublishSubject.create();
		publishSubject.subscribe(data-> System.out.println("Subscribe #1 => "+ data)); //해당함수 호출해야 값을 발행하기 시작함.
		publishSubject.onNext("1");

		publishSubject.subscribe(data-> System.out.println("Subscribe #2 => "+ data)); 
		publishSubject.onNext("2");
		publishSubject.onComplete();

	}
}
