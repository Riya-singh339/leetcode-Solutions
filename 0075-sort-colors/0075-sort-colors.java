class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int c=0;
        int c1=0;
        int c2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                c++;
            }else if(nums[i]==1){
                c1++;
            }else{
                c2++;
            }
        }
        int idx=0;
        for(int i=0;i<c;i++)
        nums[idx++]=0;
        for(int i=0;i<c1;i++)
        nums[idx++]=1;
        for(int i=0;i<c2;i++)
        nums[idx++]=2;
    }
 
}