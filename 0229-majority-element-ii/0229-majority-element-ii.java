class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int count = 0;
            if(ans.contains(nums[i]))
             continue;
            for(int j=0;j<n;j++){
                if(nums[j] == nums[i]){
                    count++;
                }
            } 
            if (count > n/3){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}