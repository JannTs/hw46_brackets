package queue_lesson;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Создаем PriorityQueue с элементами Integer
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Добавляем элементы с произвольным приоритетом
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(8);

        // Извлекаем элементы в порядке возрастания приоритета
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()); // Выводим и удаляем элементы
        }
    }
}

