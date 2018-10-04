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
            for (int j = 0 + i; j < array.length; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    String in = array[array.length - 1 - counter];
                    array[array.length - 1 - counter] = array[j];
                    array[j] = in;
                    counter++;
                    break;
                }
            }
        }
        String[] newArray = Arrays.copyOf(array, array.length - counter);
        return newArray;
    }
}
