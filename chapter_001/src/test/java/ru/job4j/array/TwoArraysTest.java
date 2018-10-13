package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysTest {
    @Test
    public void whenStartWithTwoArrays() {
        TwoArrays twoArrays = new TwoArrays();
        int[] arrayX = new int[]{1, 2, 4};
        int[] arrayY = new int[]{3, 5, 6, 10};
        int[] result = twoArrays.getSortArray(arrayX, arrayY);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenStartWithTwoIdenticalArrays() {
        TwoArrays twoArrays = new TwoArrays();
        int[] arrayX = new int[]{1, 2, 3};
        int[] arrayY = new int[]{1, 2, 3};
        int[] result = twoArrays.getSortArray(arrayX, arrayY);
        int[] expect = new int[]{1, 1, 2, 2, 3, 3};
        assertThat(result, is(expect));
    }
    @Test
    public void test1() {
        TwoArrays twoArrays = new TwoArrays();
        int[] arrayX = new int[]{3, 5, 6, 10};
        int[] arrayY = new int[]{1, 2, 4};
        int[] result = twoArrays.getSortArray(arrayX, arrayY);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void test() {
        TwoArrays twoArrays = new TwoArrays();
        int[] arrayX = new int[]{1, 2, 3};
        int[] arrayY = new int[]{};
        int[] result = twoArrays.getSortArray(arrayX, arrayY);
        int[] expect = new int[]{1, 2, 3};
        assertThat(result, is(expect));
    }
    @Test
    public void test2() {
        TwoArrays twoArrays = new TwoArrays();
        int[] arrayX = new int[]{};
        int[] arrayY = new int[]{};
        int[] result = twoArrays.getSortArray(arrayX, arrayY);
        int[] expect = new int[]{};
        assertThat(result, is(expect));
    }


}
