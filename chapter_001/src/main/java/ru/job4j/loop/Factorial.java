package ru.job4j.loop;
/**
 * Счетчик.
 */
public class Factorial {
    /**
     * Считаем факториал натурального числа.
     * @param n Начальное число.
     * @return Факториал.
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
