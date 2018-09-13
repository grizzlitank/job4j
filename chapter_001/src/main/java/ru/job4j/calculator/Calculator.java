package ru.job4j.calculator;

/**
 *Calculator
 *@author Ilya Arkhipov (ilya.arkhipov.89@mail.ru)
 */
public class Calculator {
    private double result;

    /**
     * Method add.
     * @param first First number.
     * @param second Second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method getResult.
     * @return result of action
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Method substract.
     * @param first First number.
     * @param second Second number.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * @param first First number.
     * @param second Second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     * @param first First number.
     * @param second Second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
