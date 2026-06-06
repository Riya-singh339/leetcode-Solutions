class Solution {
    public int majorityElement(int[] nums) {
        int m=0,c=0;
        for(int num : nums){
            if(c==0){
                m=num;
                c=1;
            }else if(num==m){
                c++;
            }else{
                c--;
            }
        }
        return m;
    }
}