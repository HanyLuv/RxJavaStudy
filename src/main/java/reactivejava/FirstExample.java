package reactivejava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class FirstExample {
	
	public void emit() {
		Observable.just("Hello!",3)
		.subscribe(System.out::println);
		
	}
	
	public static void main(String[] args) {

		Observable<Integer> source = Observable.create(
				(ObservableEmitter<Integer> emitter) ->{
					emitter.onNext(1);
					emitter.onNext(2);
					emitter.onNext(3);
					emitter.onComplete();
		}
		);
		
		source.subscribe(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) throws Exception {
				System.out.println(t);
				
			}
		});
	}

	
	
}
