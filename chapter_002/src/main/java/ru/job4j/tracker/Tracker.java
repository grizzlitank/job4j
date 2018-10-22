package ru.job4j.tracker;

import java.time.LocalTime;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return new StringBuilder().append(LocalTime.now()).append(Math.random() * 1000).toString();
    }

    /**
     * Метод возвращает массив всех значений
     * @return Массив.
     */
    public Item[] getAll(){
        return this.items;
    }

    /**
     * Метод заменяет ячейку в массиве.
     */
    public void replace(String id, Item item){
        Item[] itemsWithoutNull;
        for (int i = 0; i < this.getAll().length; i++) {
            if (getAll()[i] != null && getAll()[i].getId().equals(id)) {
                getAll()[i] = item;
            }
        }
    }

    /**
     * Метод возвращает элемент из массива по id
     * @return заявку.
     */
    public Item findById(String id) {
        for (int i = 0; i < this.getAll().length; i++) {
            if (getAll()[i].getId().equals(id)) {
                return getAll()[i];
            }
        }
        return null;
    }

    /**
     * Метод удаляет элемент из массива по id
     */
    public void delete(String id) {
        for (int i = 0; i < this.getAll().length; i++) {
            if (getAll()[i] != null && getAll()[i].getId().equals(id)) {
                System.arraycopy(getAll(), i + 1, getAll(), i, getAll().length - i - 1);
                getAll()[getAll().length - 1] = null;
            }
        }
    }

    /**
     * Метод копирует массив без null
     * * @return массив без null
     */
    public Item[] findAll() {
        int position = 0;
        for (int i = 0; i < this.getAll().length; i++) {
            if (getAll()[i] == null) {
                position = i;
                break;
            }
        }
        Item[] itemsWithoutNull = new Item[position];
        System.arraycopy(getAll(), 0, itemsWithoutNull, 0, position);
        return itemsWithoutNull;
    }

    /**
     * Метод создает массив с одинаковыми именами
     * * @return массив
     */
    public Item[] findByName(String key) {
        Tracker testTracker = new Tracker();
        for (int i = 0; i < this.getAll().length; i++) {
            if (getAll()[i] != null && getAll()[i].getName().equals(key)) {
                testTracker.add(getAll()[i]);
            }
        }
        return testTracker.findAll();
    }

}
