package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    /**
     * Устраняет дупликаты слов, при условии, что у одного слова не более одного дупликата.
     * @param array массив слов.
     * @return массив без дупликатов.
     */
    public String[] remove(String[] array) {
        int counter = 0;
        for (int i = 0; i < array.length - counter; i++) {
            for (int j = 0; j < array.length - counter; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    String in = array[array.length - 1 - counter];
                    array[array.length - 1 - counter] = array[j];
                    array[j] = in;
                    j--;
                    counter++;
                }
            }
        }

        return Arrays.copyOf(array, array.length - counter);
    }
}
