public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor((long)nums[ind] + (long)t);
            final Long ceil = values.ceiling((long)nums[ind] - (long)t);
            if ( floor != null && ceil != null && ceil <= floor ) {
                return true;
            } 

            values.add((long)nums[ind]);
            if (ind >= k) {
                values.remove((long)nums[ind - k]);
            }
        }

        return false;
    }
}
