package hw2_15.com.example.hw2_15_demo;

import hw2_15.com.example.hw2_15_demo.integerlist.IntegerList;
import hw2_15.com.example.hw2_15_demo.integerlist.IntegerListImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw215DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(Hw215DemoApplication.class, args);

		// -------------------------------------------------------
		IntegerList integerList = IntegerList.generateRandomArray(100);

		// Замер сортировки выбора
		long start1 = System.currentTimeMillis();
		Integer [] a = IntegerList.sortSelection(integerList.toArray());
		System.out.print("Время выполнения sortSelection(): ");
		long time1 = System.currentTimeMillis() - start1;
		System.out.println("Отсортированный массив методом sortSelection():");
		IntegerList.staticPrintArray(a);

		// Замер метода пузырька
		long start2 = System.currentTimeMillis();
		a = IntegerList.sortBubble(integerList.toArray());
		long time2 = System.currentTimeMillis() - start2;
		System.out.println("Отсортированный массив методом sortBubble():");
		IntegerList.staticPrintArray(a);

		// Замер метода пузырька
		long start3 = System.currentTimeMillis();
		a = IntegerList.sortInsertion(integerList.toArray());
		long time3 = System.currentTimeMillis() - start3;
		System.out.println("Отсортированный массив методом sortInsertion():");
		IntegerList.staticPrintArray(a);

		System.out.println("Время выполнения сортировки sortSelection(): " + time1);
		System.out.println("Время выполнения сортировки sortBubble(): " + time2);
		System.out.println("Время выполнения сортировки sortInsertion(): " + time3);

		System.out.println("integerList.contains(198150) = " + integerList.contains(198150));
		System.out.println("integerList.indexOf(198150) = " + integerList.indexOf(198150));

		integerList.printArray();

	}

}
