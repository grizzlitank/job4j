package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "0. Add program"));
        this.actions.add(new ShowItems(1, "1. Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "2. Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(5, "5. Find items by name"));
        this.actions.add(new ExitProgram(6, "6. Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public class AddItem implements UserAction {

        private final int ADD;
        private final String MESSAGE;

        public AddItem(int constanta, String message) {
            ADD = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public class ShowItems implements UserAction {

        private final int FIND_ALL;
        private final String MESSAGE;

        public ShowItems(int constanta, String message) {
            FIND_ALL = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return FIND_ALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item entry : tracker.findAll()) {
                System.out.println(entry);
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public static class EditItem implements UserAction {

        private final int REPLACE;
        private final String MESSAGE;

        public EditItem(int constanta, String message) {
            REPLACE = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return REPLACE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки --------------");
            String id = input.ask("Введите id заявки, которую хотите заменить :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Запись изменена");
            } else {
                System.out.println("Запись не найдена");
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public static class DeleteItem implements UserAction {

        private final int DELETE;
        private final String MESSAGE;

        public DeleteItem(int constanta, String message) {
            DELETE = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую хотите удалить");
            if (tracker.delete(id)) {
                System.out.println("Запись удалена");
            } else {
                System.out.println("Запись не найдена");
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public class FindItemById implements UserAction {

        private final int FIND_BY_ID;
        private final String MESSAGE;

        public FindItemById(int constanta, String message) {
            FIND_BY_ID = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return FIND_BY_ID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую хотите найти");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("По данному id заявка не найдена");
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public class FindItemsByName implements UserAction {

        private final int FIND_BY_NAME;
        private final String MESSAGE;

        public FindItemsByName(int constanta, String message) {
            FIND_BY_NAME = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return FIND_BY_NAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки, которую хотите найти");
            for (Item entry : tracker.findByName(name)) {
                System.out.println(entry);
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }

    public class ExitProgram implements UserAction {

        private final int EXIT;
        private final String MESSAGE;

        public ExitProgram(int constanta, String message) {
            EXIT = constanta;
            MESSAGE = message;
        }

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки, которую хотите найти");
            for (Item entry : tracker.findByName(name)) {
                System.out.println(entry);
            }
        }

        @Override
        public String info() {
            return MESSAGE;
        }
    }
}
