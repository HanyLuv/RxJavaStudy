package reactivejava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;

public class FirstExample {

	public static void main(String[] args) {
			AsyncSubject<String> subject = AsyncSubject.create();
			subject.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			subject.onNext("hany");
			subject.onNext("end");
//			subject.onComplete();	// Observable�� ���������� ȣ�� ���Ŀ� onNext()�� �����Ѵ�.
			subject.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			subject.subscribe(data -> System.out.println("Subscriber #3 => "+data));
			
			
			BehaviorSubject<String> behavior = BehaviorSubject.createDefault("default");
			behavior.subscribe(data -> System.out.println("Subscriber #1 => "+data));
			behavior.onNext("1");
			behavior.onNext("2");
//			behavior.onComplete(); �� �Ʒ����� ���õȴ�. AsyncSubject�� �ٸ��� onComplete�� �����ʾƵ� �����ڿ��� �����Ͱ� ����Ǹ� �̺�Ʈ�� ������.
									//Hot Observable �̹Ƿ� �翬�Ѱ��ΰ� ���� '��')/
			behavior.subscribe(data -> System.out.println("Subscriber #2 => "+data));
			behavior.onNext("5");
			
	}
}
