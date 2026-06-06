class Solution {
    public int majorityElement(int[] nums) {
        int m=0,c=0;
        for(int num : nums){
            if(c==0){
                m=num;
            }
            if(num==m){
                c++;
            }
            else{
                c--;
            }
        }
        return m;
    }
}