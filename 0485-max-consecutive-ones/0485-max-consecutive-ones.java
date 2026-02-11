class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int count=0;
        int m=0;
        for(int i=0;i<n;i++){
           if(nums[i]==1){
            count++;
            m=Math.max(m,count);
           }else{
            count=0;
           }
        }
        return m;
    }
}