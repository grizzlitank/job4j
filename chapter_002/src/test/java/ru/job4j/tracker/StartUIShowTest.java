package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUIShowTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker;
    private Item item;
    StartUI startUI;

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
        this.tracker = new Tracker();
        this.item = tracker.add(new Item("test name", "desc"));

    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserShowAll() {
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(new StartUI(input, tracker).getMenu())
                .append(item.toString())
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenUserFindItemById() {
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(new StartUI(input, tracker).getMenu())
                .append(item.toString())
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenUserFindItemByName() {
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append(new StartUI(input, tracker).getMenu())
                .append(item.toString())
                .append(System.lineSeparator())
                .toString()));
    }
}
