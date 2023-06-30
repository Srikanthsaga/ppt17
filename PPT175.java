class Node171 {
    int val;
    Node171 next;

    Node171(int val) {
        this.val = val;
    }
}

public class PPT175 {
    public int findTheWinner(int n, int k) {
        // Create a circular linked list representing the friends
        Node171 head = new Node171(1);
        Node171 prev = head;
        for (int i = 2; i <= n; i++) {
            Node171 curr = new Node171(i);
            prev.next = curr;
            prev = curr;
        }
        prev.next = head; // Connect the last friend to the first friend to form a circle

        // Start the game from friend 1
        Node171 curr = head;
        while (curr.next != curr) {
            // Count k-1 friends clockwise
            for (int i = 1; i < k - 1; i++) {
                curr = curr.next;
            }

            // Remove the friend next to curr
            curr.next = curr.next.next;

            // Move to the next friend (clockwise)
            curr = curr.next;
        }

        return curr.val; // Return the last remaining friend
    }

    public static void main(String[] args) {
        PPT175 gameWinner = new PPT175();
        System.out.println(gameWinner.findTheWinner(5, 2)); // Output: 3
    }
}
