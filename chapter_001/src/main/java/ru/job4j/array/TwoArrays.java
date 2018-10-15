package ru.job4j.array;

public class TwoArrays {

    public int[] getSortArray(int[] arrayX, int[] arrayY) {
        int counterX = 0;
        int counterY = 0;
        int counterSum = 0;
        int[] arraySum = new int[arrayX.length + arrayY.length];
        while (counterX < arrayX.length || counterY < arrayY.length) {
            if (counterY == arrayY.length || counterX < arrayX.length && arrayX[counterX] <= arrayY[counterY]) {
                arraySum[counterSum++] = arrayX[counterX++];
            } else if (counterX == arrayX.length || arrayX[counterX] > arrayY[counterY]) {
                arraySum[counterSum++] = arrayY[counterY++];
            }
        }
        return arraySum;
    }

}
