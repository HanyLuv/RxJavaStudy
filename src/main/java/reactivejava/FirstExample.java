package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FirstExample {

	public static void main(String[] args) {
		
		
		Function<String, String> getDiamond = ball-> ball +"<>";
		
		String[] balls = {"1","2","3","5"};
		Observable<String> source = Observable.fromArray(balls).map(getDiamond);
		
		source.subscribe(new Consumer<String>() {
		public void accept(String t) throws Exception {
			System.out.println(t);
		};
		});
		
		
	}
}
