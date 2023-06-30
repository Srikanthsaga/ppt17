import java.util.HashMap;

public class PPT171 {
    public static int firstNonRepeatingCharacter(String s) {
        // Count the frequency of each character
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No non-repeating character found
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstNonRepeatingCharacter(s);
        System.out.println("Index of the first non-repeating character: " + index);
    }
}
