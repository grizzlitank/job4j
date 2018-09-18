package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenDistanceFirstPointToSecondPoint1() {
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(1, 3);
        double distance = firstPoint.distanceTo(secondPoint);
        assertThat(distance, is(1.0));
    }
}
