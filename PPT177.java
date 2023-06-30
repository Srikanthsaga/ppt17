import java.util.ArrayDeque;
import java.util.Deque;

public class PPT177 {
    private Deque<Integer> frontDeque;
    private Deque<Integer> backDeque;

    public PPT177() {
        frontDeque = new ArrayDeque<>();
        backDeque = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        frontDeque.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() > backDeque.size()) {
            backDeque.offerFirst(frontDeque.pollLast());
        }
        frontDeque.offerLast(val);
    }

    public void pushBack(int val) {
        backDeque.offerLast(val);
        balance();
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        if (!frontDeque.isEmpty()) {
            return frontDeque.pollFirst();
        }
        int val = backDeque.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }
        if (frontDeque.size() == backDeque.size()) {
            return frontDeque.pollLast();
        }
        return backDeque.pollFirst();
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        if (!backDeque.isEmpty()) {
            return backDeque.pollLast();
        }
        int val = frontDeque.pollLast();
        balance();
        return val;
    }

    private void balance() {
        if (frontDeque.size() > backDeque.size() + 1) {
            backDeque.offerFirst(frontDeque.pollLast());
        } else if (backDeque.size() > frontDeque.size()) {
            frontDeque.offerLast(backDeque.pollFirst());
        }
    }

    private boolean isEmpty() {
        return frontDeque.isEmpty() && backDeque.isEmpty();
    }
}
