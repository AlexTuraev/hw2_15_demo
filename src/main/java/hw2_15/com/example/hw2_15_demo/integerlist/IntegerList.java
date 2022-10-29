package hw2_15.com.example.hw2_15_demo.integerlist;

import java.util.Arrays;

// Заменить String на Integer
public interface IntegerList {

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(Integer item);

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(int index, Integer item);

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    Integer set(int index, Integer item);

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    //Integer remove(Integer item);

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    //Integer remove(int index);

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(Integer item);

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(Integer item);

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(Integer item);

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    Integer get(int index);

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(IntegerList otherList);

    // Вернуть фактическое количество элементов.
    int size();

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty();

    // Удалить все элементы из списка.
    void clear();

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    Integer [] toArray();

    // ---------------
    public void printArray();
    public void shiftArrayElements(int index1, int index2, int step);
    public int getCountElements();
    //public String[] getArray();
    Integer removeByValue(Integer item);
    Integer removeByIndex(int index);

    // Заполнение массива случайными элементами
    public static IntegerList generateRandomArray(int size){
        java.util.Random random = new java.util.Random();
        IntegerList newArray = new IntegerListImpl(size);
        for (int i = 0; i < size; i++) {
            newArray.add(random.nextInt(100_000) + 100_000);
        }
        return newArray;
    }

    public static void swapElements(Integer [] a, int idx1, int idx2) {
        Integer temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // Вывод в консоль элементов массива
    public static void staticPrintArray(Integer [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
        }
    }

    // Сортировка методом пузырька
    public static Integer [] sortBubble(Integer [] arrForSort) {
        System.out.println("Старт сортировки sortBubble. Идет сортировка...");
        Integer [] arr = Arrays.copyOf(arrForSort, arrForSort.length);
        for (int i = 0; i < arr.length-2; i++) {
            for(int j=0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j+1);
                    //System.out.println("Swapping a["+j+"] with a["+(j+1)+"]");
                }
            }
        }
        return arr;
    }

    // Сортировка выбором
    public static Integer[] sortSelection(Integer[] arrForSort) {
        System.out.println("Старт сортировки sortSelection. Идет сортировка...");
        Integer [] arr = Arrays.copyOf(arrForSort, arrForSort.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
            //System.out.println("Swapping a["+i+"] with a["+minElementIndex+"]");
        }
        return arr;
    }

    // Сортировка вставкой
    public static Integer[] sortInsertion(Integer[] arrForSort) {
        System.out.println("Старт сортировки sortInsertion. Идет сортировка...");
        Integer [] arr = Arrays.copyOf(arrForSort, arrForSort.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

}