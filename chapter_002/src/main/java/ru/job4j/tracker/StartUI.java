package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    private static final String FIND_ALL = "1";

    private static final String REPLACE = "2";

    private static final String DELETE = "3";

    private static final String FIND_BY_ID = "4";

    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню :" +
                    "0. Add new Item\n" +
                    "1. Show all items\n" +
                    "2. Edit item\n" +
                    "3. Delete item\n" +
                    "4. Find item by Id\n" +
                    "5. Find items by name\n" +
                    "6. Exit Program\n" +
                    "Select: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FIND_ALL.equals(answer)) {
                for (Item entry : this.tracker.findAll()) {
                    System.out.println(entry);
                }
            } else if (REPLACE.equals(answer)) {
                this.setItem();
            } else if (DELETE.equals(answer)) {
                String id = this.input.ask("Введите id заявки, которую хотите удалить");
                this.tracker.delete(id);
            } else if (FIND_BY_ID.equals(answer)) {
                String id = this.input.ask("Введите id заявки, которую хотите найти");
                System.out.println(this.tracker.findById(id));
            } else if (FIND_BY_NAME.equals(answer)) {
                String name = this.input.ask("Введите имя заявки, которую хотите найти");
                System.out.println(this.tracker.findByName(name));
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    /**
     * Метод реализует замены заявки в хранилище.
     */
    private void setItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        String id = this.input.ask("Введите id заявки, которую хотите заменить :");
        this.tracker.replace(id, item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
