package reactivejava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;

public class FirstExample {

	public static void main(String[] args) {
			AsyncSubject<String> subject = AsyncSubject.create();
			subject.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			subject.onNext("hany");
			subject.onNext("end");
//			subject.onComplete();	// Observable과 마찬가지로 호출 이후엔 onNext()를 무시한다.
			subject.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			subject.subscribe(data -> System.out.println("Subscriber #3 => "+data));
			
			
			BehaviorSubject<String> behavior = BehaviorSubject.createDefault("default");
			behavior.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			behavior.onNext("1");
			behavior.onNext("2");
//			behavior.onComplete(); 이 아래부터 무시된다. AsyncSubject와 다르게 onComplete를 하지않아도 구독자에게 데이터가 변경되면 이벤트를 보낸다.
									//Hot Observable 이므로 당연한것인거 같다 'ㅅ')/
			behavior.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			behavior.onNext("5");
			
	}
}
