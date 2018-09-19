package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenSecondMoreFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 6, 1);
        assertThat(result, is(6));
    }

    @Test
    public void whenThirdMoreFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 6, 7);
        assertThat(result, is(7));
    }
}
