class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int p=0;
        int q=1;
        while (q<nums.length){
            if(nums[p]==nums[q]){
                q++;
            }
            else {
                nums[p+1]=nums[q];
                p++;
            }
        }
        return p+1;

    }
}
