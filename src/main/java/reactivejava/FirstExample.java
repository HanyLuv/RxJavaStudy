package reactivejava;

import io.reactivex.subjects.AsyncSubject;

public class FirstExample {

	public static void main(String[] args) {
		
			AsyncSubject<String> subject = AsyncSubject.create();
			subject.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			subject.onNext("hany");
			subject.onNext("luv");
			subject.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			subject.onNext("end");
			subject.onComplete();	
	}
}
