package reactivejava;

import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FirstExample {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.println("구구단 Input:");
		int dan = Integer.parseInt(in.nextLine());
		for(int row = 1, end = 9 ;row <=end ; ++row) {
			System.out.println(dan+ " * "+ row  + " = " + dan * row);
		}
		
		//값이 들어오면 곱해서 저장해야해
		//map은 들어온값을 원하는 형태로 가공할수있다 ㅇㅁㅇ 
		//flatMap()으로 변경해보자
				
		
		Function<Integer, Observable<String>> funGugudan = value -> {
			return Observable.just(value + " * "+ 1  + " = " + value * 1,
					value + " * "+ 2  + " = " + value * 2,
					value + " * "+ 3  + " = " + value * 3,
					value + " * "+ 4  + " = " + value * 4,
					value + " * "+ 5  + " = " + value * 5,
					value + " * "+ 6  + " = " + value * 6,
					value + " * "+ 7  + " = " + value * 7,
					value + " * "+ 8  + " = " + value * 8,
					value + " * "+ 9  + " = " + value * 9
					);
		};
				

		Observable<String> observable = Observable.just(dan).flatMap(funGugudan);
		observable.subscribe(System.out::println);
				
		
		
		
	}
}
