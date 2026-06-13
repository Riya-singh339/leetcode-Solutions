class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n=numRows;
        int[][]ans=new int[n][];
        for (int i = 0; i < n; i++) {
            //ith row has i+1 cols
            ans[i]=new int[i+1];
            //1st and last element of every row is 1
            ans[i][0]=ans[i][i] = 1;

            for(int j=1;j<i;j++){
                ans[i][j]=ans[i-1][j] + ans[i-1][j-1];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<ans[i].length;j++){
                row.add(ans[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}