package reactivejava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class FirstExample {

	public static void main(String[] args) {
			
	ReplaySubject<String> subject = ReplaySubject.create();
//	subject.subscribe(data -> System.out.println("Subscribe #1 => "+data ));
	subject.onNext("1");
	subject.subscribe(data -> System.out.println("Subscribe #1 => "+data ));
	subject.onNext("2");
	subject.subscribe(data -> System.out.println("Subscribe #2 => "+data ));
	subject.onNext("3");
	subject.subscribe(data -> System.out.println("Subscribe #3 => "+data ));
	}
}
