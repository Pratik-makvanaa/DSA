class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target,new ArrayList<>(), ans);

        return ans;
    }


    public void backtrack(int start, int[] candidates, int target, 
                            List<Integer> ds, List<List<Integer>> ans)
                            {
                                    if(target == 0){
                                        ans.add(new ArrayList<>(ds));
                                        return;
                                    }

                                    for(int i=start; i<candidates.length;i++){
                                        if(i > start && candidates[i] == candidates[i-1]){
                                            continue;
                                        }

                                        if(candidates[i] > target){
                                            break;
                                        }
                                        //pick
                                        ds.add(candidates[i]);
                                        //for skip currect and go to next element 
                                        backtrack(i+1,candidates, target - candidates[i], ds, ans);

                                        ds.remove(ds.size() - 1);  //backtrack
                                    }
                            }

}