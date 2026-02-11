class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
           int c=0;
           for(j=0;j<n;j++){
            if(nums[i]==nums[j]){
                c++;
            }
           }
           if(c==1){
            return nums[i];
           }
        }
        return -1;
    }
}