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
        assertThat(result, is(expect)); //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith3Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Чармандер", "Пикачу", "Бульбазавр", "Бульбазавр", "Чармандер"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        assertThat(result, is(expect)); //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith2Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Пикачу", "Пикачу", "Пикачу"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу"};
        assertThat(result, is(expect)); //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWith1Duplicate() {
        ArrayDuplicate word = new ArrayDuplicate();
        String[] input = new String[] {"Пикачу", "Чармандер", "Бульбазавр", "Чармандер"};
        String[] result = word.remove(input);
        String[] expect = new String[] {"Пикачу", "Чармандер", "Бульбазавр"};
        assertThat(result, is(expect)); //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
    }
}
