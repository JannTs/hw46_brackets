package priority_queue_lesson;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Comparator<String> descendingLengthComparator = (s1, s2) -> Integer.compare(s2.length(), s1.length());
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(descendingLengthComparator);

        priorityQueue.add("apple");
        priorityQueue.add("banana");
        priorityQueue.add("cherry");
        priorityQueue.add("date");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
