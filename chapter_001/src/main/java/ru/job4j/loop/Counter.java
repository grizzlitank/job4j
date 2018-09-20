package ru.job4j.loop;
/**
 * Счетчик.
 */
public class Counter {
    /**
     * Считаем сумму четных чисел от одного числа до другого.
     * @param start Начальное число.
     * @param finish Конечно число.
     * @return Сумма.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
