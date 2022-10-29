package hw2_15.com.example.hw2_15_demo.integerlist;

import hw2_15.com.example.hw2_15_demo.exceptions.NullParameterException;
import hw2_15.com.example.hw2_15_demo.exceptions.OutOfArrayException;
import hw2_15.com.example.hw2_15_demo.exceptions.OverflowArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {

    private IntegerList integerList = new IntegerListImpl(5);
    static Integer [] sortArray;

    @BeforeEach
    private void generateStartCondition() {
        integerList = new IntegerListImpl(5);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
    }

    @Test
    void add() {
        assertThrows(NullParameterException.class, ()-> integerList.add(null));
        assertEquals(5, integerList.add(5));
        assertThrows(OverflowArrayException.class, ()->integerList.add(6));
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void removeByValue() {
        integerList.add(5);
        integerList.removeByValue(2);

        IntegerList stringList1 = new IntegerListImpl(4);
        stringList1.add(1);
        stringList1.add(3);
        stringList1.add(4);
        stringList1.add(5);

        assertThat(Arrays.equals(integerList.toArray(), 0, integerList.size(), stringList1.toArray(), 0, stringList1.size())).isTrue();

    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
        assertThat(integerList.contains(1)).isTrue();
        assertThat(integerList.contains(10)).isFalse();
    }

    @Test
    void indexOf() {
        assertThat(integerList.indexOf(2)).isEqualTo(1);
        assertThat(integerList.indexOf(1)).isEqualTo(0);
        assertThat(integerList.indexOf(15)).isEqualTo(-1);
    }

    @Test
    void lastIndexOf() {
        assertThat(integerList.lastIndexOf(2)).isEqualTo(1);
        integerList.add(1);
        assertThat(integerList.lastIndexOf(1)).isEqualTo(4);
        assertThat(integerList.lastIndexOf(10)).isEqualTo(-1);
    }

    @Test
    void get() {
        assertThat(integerList.get(0)).isEqualTo(1);
        assertThat(integerList.get(3)).isEqualTo(4);
        assertThrows(OutOfArrayException.class, ()->integerList.get(10));
    }

    @Test
    void testEquals() {
        IntegerList stringList1 = new IntegerListImpl(4);
        stringList1.add(1);
        stringList1.add(2);
        stringList1.add(3);
        stringList1.add(4);

        assertThat(integerList.equals(stringList1)).isTrue();
    }

    @Test
    void size() {
        assertThat(integerList.size()).isEqualTo(4);
    }

    @Test
    void isEmpty() {
        assertThat(integerList.isEmpty()).isFalse();
    }

    @Test
    void clear() {
        integerList.clear();
        assertThat(integerList.size()).isEqualTo(0);
    }


    //Проверен в remove опосредованно
    /*@Test
    void toArray() {

    }*/

    @ParameterizedTest
    @MethodSource("generateArrayForSort")
    void sortBubble(Integer [] arr, Integer [] expected) {
        assertThat(IntegerList.sortBubble(arr)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateArrayForSort")
    void sortSelection(Integer [] arr, Integer [] expected) {
        assertThat(IntegerList.sortSelection(arr)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateArrayForSort")
    void sortInsertion(Integer [] arr, Integer [] expected) {
        assertThat(IntegerList.sortInsertion(arr)).isEqualTo(expected);
    }


    public static Stream<Arguments> generateArrayForSort() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 3, 6, 2, 0, 10, 15, 20}, new Integer[]{0, 1, 2, 3, 6, 10, 15, 20}),
                Arguments.of(new Integer[]{2, 4, 50, 20}, new Integer[]{2, 4, 20, 50}),
                Arguments.of(new Integer[]{7, 10, 25, 70, 10, 20}, new Integer[]{7, 10, 10, 20, 25, 70})
        );
    }
}