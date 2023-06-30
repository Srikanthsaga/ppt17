import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PPT173 {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int n = students.length;

        // Initialize the queue and stack
        for (int i = 0; i < n; i++) {
            queue.offer(students[i]);
            stack.push(sandwiches[i]);
        }

        int unableToEat = 0;

        // Simulate students taking sandwiches
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int student = queue.poll();
            int sandwich = stack.peek();

            if (student == sandwich) {
                stack.pop();
                unableToEat = 0; // Reset the count of unable to eat students
            } else {
                queue.offer(student);
                unableToEat++;
            }

            // If all students are unable to eat, exit the loop
            if (unableToEat == n)
                break;
        }

        return queue.size();
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int unableToEat = countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat: " + unableToEat);
    }
}
