package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    /**
     * Устраняет дупликаты слов, при условии, что у одного слова не более одного дупликата.
     * @param array массив слов.
     * @return массив без дупликатов.
     */
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    String in = array[array.length - 1];
                    array[array.length - 1] = array[j];
                    array[j] = in;
                    array = Arrays.copyOf(array, array.length - 1);
                }
            }
        }

        return array;
    }
}
