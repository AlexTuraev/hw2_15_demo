package hw2_15.com.example.hw2_15_demo;

import hw2_15.com.example.hw2_15_demo.integerlist.IntegerList;
import hw2_15.com.example.hw2_15_demo.integerlist.IntegerListImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Hw215DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(Hw215DemoApplication.class, args);

		// -------------------------------------------------------
		IntegerList integerList = IntegerList.generateRandomArray(100);
		//IntegerList integerList = IntegerList.generateRandomArray(100_000); // раскомментировать для вычисления для массива размером 100_000


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

		// Замер метода quickSort
		long start4 = System.currentTimeMillis();
		Integer arr[] = integerList.toArray();
		a = IntegerList.quickSort(arr, 0, arr.length-1);
		long time4 = System.currentTimeMillis() - start4;
		System.out.println("Отсортированный массив методом quickSort():");
		IntegerList.staticPrintArray(a);

		System.out.println("Время выполнения сортировки sortSelection(): " + time1);
		System.out.println("Время выполнения сортировки sortBubble(): " + time2);
		System.out.println("Время выполнения сортировки sortInsertion(): " + time3);
		System.out.println("Время выполнения сортировки quickSort(): " + time4);

		System.out.println("integerList.contains(198150) = " + integerList.contains(198150));
		System.out.println("integerList.indexOf(198150) = " + integerList.indexOf(198150));

		/*System.out.println("Изначально сортируемый массив");
		integerList.printArray();*/

		IntegerList integerList1 = new IntegerListImpl(5);
		integerList1.add(1);
		integerList1.add(3);
		integerList1.add(2);
		integerList1.add(5);
		integerList1.add(8);
		System.out.println("integerList1.contains(2) = " + integerList1.contains(2));
		System.out.println("integerList1.contains(150) = " + integerList1.contains(150));

		// ------------------------------------------------------------------------------------------
		// HomeWork 2.16

		System.out.println("\nДля HomeWork 2.16 создаем IntegerList с array размером 3, потом смотрим как увеличивается массив");
		IntegerList integerList2 = new IntegerListImpl(3);
		System.out.println("Размер maxSize перед добавлением элементов = " + integerList2.getMaxSize());
		integerList2.add(1);
		integerList2.add(2);
		integerList2.add(3);
		integerList2.add(33);
		integerList2.add(34);
		integerList2.add(35);
		integerList2.add(35);
		integerList2.add(38);
		integerList2.add(45);
		integerList2.add(15);
		integerList2.add(35);
		integerList2.add(17);
		integerList2.add(35);
		integerList2.add(16);
		integerList2.add(18);
		integerList2.printArray();
		System.out.println("Размер maxSize после добавления элементов = " + integerList2.getMaxSize());


	} // main()

}
