import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    private Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.offer(t);

        // Remove requests that are outside the time frame
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }
}

// Test the RecentCounter class
public class PPT174 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));    // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}
