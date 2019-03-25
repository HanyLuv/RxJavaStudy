package reactivejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import io.reactivex.Observable;


public class FirstExample {
	
	public static void main(String[] args) {
		
		//1. List에서 Observable만들기.
		List<String> name = new ArrayList<String>();
		name.add("HANY");
		name.add("ANNA");
		name.add("MONMANG");
		
		Observable<String> source = Observable.fromIterable(name);
		source.subscribe(System.out::println);

		
		//2. Set에서 Observable 만들기
		Set<String> cities = new HashSet<String>();
		cities.add("Seoul!");
		cities.add("London~!");
		
		Observable<String> citiesSource = Observable.fromIterable(cities);
		citiesSource.subscribe(System.out::println);

		// BlockingQueue에서 만들기
		BlockingQueue<User>  queue = new ArrayBlockingQueue<User>(100); // 최대 대기행렬수 100
		queue.add(new User("Lone"));
		queue.add(new User("Roma"));
		queue.add(new User("PAPAPAP"));
		
		Observable<User> observable = Observable.fromIterable(queue);
		observable.subscribe(data->{
			System.out.println(data.getName());
		});

	}
}
