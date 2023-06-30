public class PPT178 {
    private int[] buffer;
    private int value;
    private int k;
    private int count;

    public PPT178(int value, int k) {
        this.buffer = new int[k];
        this.value = value;
        this.k = k;
        this.count = 0;
    }

    public boolean consec(int num) {
        buffer[count % k] = num;
        count++;
        if (count < k) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            if (buffer[i] != value) {
                return false;
            }
        }
        return true;
    }
}
