package reactivejava;

import io.reactivex.Observable;


public class FirstExample {
	
	public static void main(String[] args) {
				Integer[] arr= {100,200,300};
				Observable<Integer> source = Observable.fromArray(arr);
				source.subscribe(System.out::println);
		
	}

}
