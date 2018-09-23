package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Пирамида.
 */
public class Paint {
    /**
     * Рисуем правый треугольник.
     * @param height высота.
     * @return треугольник.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Рисуем левый треугольник.
     * @param height высота.
     * @return треугольник.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Рисуем пирамиду.
     * @param height высота.
     * @return пирамида.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    /**
     * Универсальный метод для пирамиды.
     * @param height высота.
     * @param weight высота.
     * @param predict предикаты.
     * @return пирамида.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
