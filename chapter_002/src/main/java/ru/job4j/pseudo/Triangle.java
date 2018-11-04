package ru.job4j.pseudo;

import java.util.StringJoiner;

/**
 * @author Ilya Arkhipov
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape{
    @Override
    public String draw() {
        return new StringJoiner(
                System.lineSeparator())
                .add("  ^  ")
                .add(" ^ ^ ")
                .add("^^^^^")
                .toString();
    }
}
