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
            String answer = this.showMenu();
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FIND_ALL.equals(answer)) {
                this.findAllItem();
            } else if (REPLACE.equals(answer)) {
                this.setItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByIdItem();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод находит все заявки.
     */
    private void findAllItem() {
        for (Item entry : this.tracker.findAll()) {
            System.out.println(entry);
        }
    }
    /**
     * Метод находит заявку по id в хранилище.
     */
    private void findByNameItem() {
        String name = this.input.ask("Введите имя заявки, которую хотите найти");
        for (Item entry : this.tracker.findByName(name)) {
            System.out.println(entry);
        }
    }
    /**
     * Метод находит заявку по id в хранилище.
     */
    private void findByIdItem() {
        String id = this.input.ask("Введите id заявки, которую хотите найти");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("По данному id заявка не найдена");
        }

    }
    /**
     * Метод удаляет заявки в хранилище.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите id заявки, которую хотите удалить");
        if (this.tracker.delete(id)) {
            System.out.println("Запись удалена");
        } else {
            System.out.println("Запись не найдена");
        }
    }
    /**
     * Метод реализует замены заявки в хранилище.
     */
    private void setItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите id заявки, которую хотите заменить :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Запись изменена");
        } else {
            System.out.println("Запись не найдена");
        }
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

    private String showMenu() {
        System.out.println("Меню.");
        System.out.println("Введите пункт меню :");
        System.lineSeparator();
        System.out.println("0. Add new Item");
        System.lineSeparator();
        System.out.println("1. Show all items");
        System.lineSeparator();
        System.out.println("2. Edit item");
        System.lineSeparator();
        System.out.println("3. Delete item");
        System.lineSeparator();
        System.out.println("4. Find item by Id");
        System.lineSeparator();
        System.out.println("5. Find items by name");
        System.lineSeparator();
        System.out.println("6. Exit Program");
        System.lineSeparator();
        String answer = this.input.ask("Select: ");
        return answer;
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
