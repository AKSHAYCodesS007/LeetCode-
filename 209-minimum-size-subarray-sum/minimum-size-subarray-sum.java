class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlength=Integer.MAX_VALUE;
        int left=0;
        int currentsum=0;
        for(int right=0;right<nums.length;right++){
            currentsum+=nums[right];
            while(currentsum>=target){
                minlength=Math.min(minlength,right-left+1);
                currentsum-=nums[left];
                left++;
            }
        }
        if(minlength==Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minlength;
        }
    }
}