package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class FirstExample {

	public static void main(String[] args) {
		
		
		String[] balls = {"1","2","3","5"};
		Observable<String> source = Observable.fromArray(balls).map(ball-> ball +"<>");
		
		source.subscribe(new Consumer<String>() {
		public void accept(String t) throws Exception {
			System.out.println(t);
		};
		});
		
		
	}
}
