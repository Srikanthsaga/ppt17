import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PPT176 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck); // Sort the deck in increasing order
        
        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indices.offer(i);
        }
        
        int[] result = new int[n];
        for (int card : deck) {
            result[indices.poll()] = card;
            if (!indices.isEmpty()) {
                indices.offer(indices.poll());
            }
        }
        
        return result;
    }
}
