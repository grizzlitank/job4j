package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith5Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Чармандер", "Пикачу", "Бульбазавр", "Бульбазавр", "Чармандер", "Чармандер", "Чармандер"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith2Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Пикачу", "Чармандер", "Пикачу"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith1Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Чармандер", "Бульбазавр", "Чармандер"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        assertThat(result, is(expect));
    }
}
