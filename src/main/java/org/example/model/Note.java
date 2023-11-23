package org.example.model;

import java.util.Objects;

/**
 * Класс представляет собой модель записи в записной книжке.
 */
public class Note {
    private String topic;   // Тема записи
    private String content; // Текстовое содержание записи
    private String date;    // Дата записи (в формате "гггг-мм-дд")
    private String time;    // Время записи (в формате "чч:мм")

    public Note() {
    }

    /**
     * Конструктор для создания новой записи.
     *
     * @param topic   Тема записи.
     * @param content Текстовое содержание записи.
     * @param date    Дата записи.
     * @param time    Время записи.
     */

    public Note(String topic, String content, String date, String time) {
        this.topic = topic;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    /**
     * Получает тему записи.
     *
     * @return Тема записи.
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Получает текстовое содержание записи.
     *
     * @return Текстовое содержание записи.
     */
    public String getContent() {
        return content;
    }

    /**
     * Получает дату записи.
     *
     * @return Дата записи.
     */
    public String getDate() {
        return date;
    }

    /**
     * Получает время записи.
     *
     * @return Время записи.
     */
    public String getTime() {
        return time;
    }

    /**
     * Переопределение метода equals для сравнения двух объектов Note.
     *
     * @param o Объект для сравнения.
     * @return true, если объекты равны, и false в противном случае.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(topic, note.topic) &&
                Objects.equals(content, note.content) &&
                Objects.equals(date, note.date) &&
                Objects.equals(time, note.time);
    }

    /**
     * Переопределение метода hashCode для корректной работы с коллекциями.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(topic, content, date, time);
    }

    /**
     * Переопределение метода toString для представления объекта в виде строки.
     *
     * @return Строковое представление объекта Note.
     */
    @Override
    public String toString() {
        return "Note{" +
                "topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
