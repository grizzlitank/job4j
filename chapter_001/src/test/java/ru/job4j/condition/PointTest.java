package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void when60RubleToDollarThen1() {
        Point one = new Point(1, 2);
        Point two = new Point(1, 3);
        double distance = one.distanceTo(two);
        assertThat(distance, is(1.0));
    }
}
