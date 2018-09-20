package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenStart10AndFinish15() {
        Counter counter = new Counter();
        int result = counter.add(10, 15);
        assertThat(result, is(36));
    }
}
