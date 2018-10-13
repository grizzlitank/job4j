package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int reset = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                reset = index;
                break;
            }
        }
        return reset;
    }
}
