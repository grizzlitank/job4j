package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(item);
        tracker.add(next);
        tracker.delete(item.getId());
        assertThat(tracker.findAll()[0], is(next));
    }

    @Test
    public void whenFindAllItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(item);
        tracker.add(next);
        Item[] items = new Item[2];
        items[0] = item;
        items[1] = next;
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenFindByIdItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(item);
        tracker.add(next);
        String id = item.getId();
        assertThat(tracker.findById(id), is(item));
    }

    @Test
    public void whenFindByNameItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item next = new Item("test1", "testDescription2", 1234L);
        Item next2 = new Item("test2", "testDescription3", 1224L);
        tracker.add(item);
        tracker.add(next);
        tracker.add(next2);
        Item[] items = new Item[2];
        items[0] = item;
        items[1] = next;
        assertThat(tracker.findByName("test1"), is(items));
    }

}
