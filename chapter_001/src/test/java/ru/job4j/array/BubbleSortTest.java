package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = {1, 2, 3, 5, 7};
        int[] expect = {5, 3, 1, 2, 7};
        assertThat(result, is(bubbleSort.sort(expect)));
    }

}
