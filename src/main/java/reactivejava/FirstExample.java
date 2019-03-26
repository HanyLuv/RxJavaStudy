package reactivejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class FirstExample {

	public static void main(String[] args) {
		
		//1. ���� Observable���� Single��ü�� ��ȯ�ϱ�
		Observable<String> source = Observable.just("Hello Single!");
		Single.fromObservable(source).subscribe(data->
		 System.out.println(data)
		);
		
		
		//2. Single �Լ��� ȣ���� Single ��ü �����ϱ�
		Observable.just("Hello Single~","������")
		.single("default item") //���� ������� �������� �ش簪�� �־� ��������
		.subscribe(System.out::println);
		
		
		//3. First() �Լ��� ȣ���� Single ��ü �����ϱ�
		//�������� �����͸� ���� �� �� �ִ� Observable��Single��ü�� ��ȯ�Ѱ�.
		String[] color = {"red",
				"orenge",
				"green"
		};
		
		Observable.fromArray(color)
		.first("default value")
		.subscribe(System.out::println);
		
		
		
		//4. empty Observable���� Single ��ü �����ϱ�
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		
		
		//5. take()�Լ����� Single��ü �����ϱ�
		Observable.just(new User("hany"), new User("mongmang")).take(1)
		.single(new User("default name"))
		.subscribe(System.out::println);
		
		/**!! Single�� ������ �Ѱ��� ����!! */
		}
}
