package reactivejava;

import io.reactivex.subjects.AsyncSubject;

public class FirstExample {

	public static void main(String[] args) {
			AsyncSubject<String> subject = AsyncSubject.create();
			subject.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			subject.onNext("hany");
			subject.onNext("end");
			subject.onComplete();	// Observable과 마찬가지로 호출 이후엔 onNext()를 무시한다.
			subject.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			subject.subscribe(data -> System.out.println("Subscriber #3 => "+data));
	}
}
