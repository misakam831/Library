class Solution {
    public void rotate(int[] nums, int k) {
        int right=nums.length-1;

        for(int i=0;i<k;i++){
            int q=nums[right];
            for (int j=right;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=q;
        }


    }
}
