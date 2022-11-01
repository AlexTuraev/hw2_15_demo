package hw2_15.com.example.hw2_15_demo.integerlist;

import hw2_15.com.example.hw2_15_demo.exceptions.NotFoundException;
import hw2_15.com.example.hw2_15_demo.exceptions.NullParameterException;
import hw2_15.com.example.hw2_15_demo.exceptions.OutOfArrayException;
import hw2_15.com.example.hw2_15_demo.exceptions.OverflowArrayException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{
    private int maxSize; // емкость массива максимальная, до которой можно доавлять элементы

    private final int COUNT_100_000 = 100_000;
    private int countElements=0; // текущая длина массива, заполненная добавленными элементами

    private Integer[] array; // массив на базе которого построен наш расширенный "массив"
    private final int DEFAULT_SIZE = 100; // максимальный размер массива по умолчанию

    public IntegerListImpl() {
        this.maxSize = DEFAULT_SIZE;
        generateArray(maxSize);
    }

    public IntegerListImpl(int maxSize) {
        this.maxSize = maxSize;
        generateArray(maxSize);
    }

    // Создает массив размера size в поле array класса
    private void generateArray(int size) {
        array = new Integer[size];
    }

    public int getMaxSize() {
        return maxSize;
    }

    private boolean testOverflowArray() {
        if (countElements == maxSize) {
            return true;
        } else {
            return false;
        }
    }

    // расширение размера массива с переносом элементов
    private void grow() {
        Integer [] tempArray = Arrays.copyOf(array, countElements);
        if(maxSize * (double)1.5 > Integer.MAX_VALUE){
            throw new OverflowArrayException("Нельзя расширить массив");
        }

        maxSize = (int)Math.round(maxSize * 1.5);
        generateArray(maxSize);
        for (int i = 0; i < countElements; i++) {
            array[i] = tempArray[i];
        }
    }

    public void printArray() {
        for (int i = 0; i < countElements; i++) {
            System.out.println("array["+i+"] = " + array[i]);
        }
    }

    // Сдвиг элементов на step, начиная с index1 до (не включая) index2
    public void shiftArrayElements(int index1, int index2, int step) {
        if (step < 0) {
            for (int i = index1; i < index2; i++) {
                array[i+step] = array[i];
            }
        }else {
            for (int i = index2 - 1; i >= index1; i--) {
                array[i+step] = array[i];
            }
        }
    }

    public int getCountElements() {
        return countElements;
    }

    private void testOutOfArrayWithException(int index) {
        if (index >= countElements || index < 0) {
            throw new OutOfArrayException("Выход индекса " + index + " за пределы массива");
        }
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullParameterException("Параметр не должен быть равен null");
        }
        if (testOverflowArray()) {
            //throw new OverflowArrayException("Переполнение при попытке добавить элемент");
            grow(); // расширить массив
        }
        array[countElements] = item;
        countElements++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (testOverflowArray()) {
            //throw new OverflowArrayException("Переполнение при попытке вставить элемент по индексу "+index);
            grow(); // расширить массив
        }
        countElements++;
        for (int i = countElements-1; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index > countElements-1) {
            throw new OverflowArrayException("Выход за пределы массива");
        }
        array[index] = item;
        return item;
    }

    @Override
    public Integer removeByValue(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new NotFoundException("Строка <<" + item + ">> не найдена");
        } else {
            shiftArrayElements(index+1, countElements, -1);
            countElements--;
            return item;
        }
    }

    @Override
    public Integer removeByIndex(int index) {
        testOutOfArrayWithException(index);

        shiftArrayElements(index+1, countElements, -1);
        countElements--;
        return array[index];
    }

    @Override
    public boolean contains(Integer item) {
       /* if (indexOf(item) == -1) {
            return false;
        }else {
            return true;
        }*/
        //Integer [] arr = IntegerList.sortSelection(toArray()); // toArray(), чтобы передать с актуальным размером массив, где есть элементы
        Integer [] arr = IntegerList.quickSort(toArray(), 0, countElements-1); // toArray(), чтобы передать с актуальным размером массив, где есть элементы

        //IntegerList.staticPrintArray(arr);
        int index = Arrays.binarySearch(arr, item);
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int indexOf(Integer item) {
        int index = -1;
        for (int i=0; i < countElements; i++) {
            if (array[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index; // -1, если не найдена строка item, или index найденного элемента
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = -1;
        for (int i=countElements-1; i > 0; i--) {
            if (array[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        testOutOfArrayWithException(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullParameterException("Передан null");
        }
        if (countElements != otherList.size()) {
            return false;
        }
        return Arrays.equals(array, 0, countElements, otherList.toArray(), 0, countElements);
    }

    @Override
    public int size() {
        return countElements;
    }

    @Override
    public boolean isEmpty() {
        if (countElements <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        countElements = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, countElements);
    }
}