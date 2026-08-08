class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, int k, int target,List<Integer> ds,
                                List<List<Integer>> ans){
                                    if(k == 0 && target == 0){
                                         ans.add(new ArrayList<>(ds));
                                    }
                                    if(k == 0 || target <= 0){
                                        return;
                                    }

                                    for(int i=start;i<=9;i++){
                                        ds.add(i);

                                        backtrack(i+1,k-1,target-i,ds,ans);

                                        ds.remove(ds.size() - 1);
                                    }
                                }
}