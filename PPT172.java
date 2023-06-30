public class PPT172 {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // Case 1: Maximum subarray sum without wrapping
        int maxSum = kadane(nums);

        // Case 2: Maximum subarray sum involving wrapping
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; // Invert the sign
        }
        int minSum = kadane(nums); // Find the minimum sum (maximum sum with inverted sign)
        int circularSum = totalSum + minSum; // Maximum sum involving wrapping

        // Return the maximum of the two sums
        return Math.max(maxSum, circularSum);
    }

    // Kadane's algorithm to find the maximum subarray sum in a linear array
    private static int kadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum circular subarray sum: " + maxSum);
    }
}
