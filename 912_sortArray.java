class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = sortArray(nums, 0, nums.length -1);
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    
    public List<Integer> sortArray(int[] nums, int start, int end){
        List<Integer> res = new ArrayList<Integer>();
        if(start > end) return res;
        if(start == end) {
            res.add(nums[start]);
            return res;
        }
        int mid = start + (end-start)/2;
        List<Integer> left = sortArray(nums, start, mid);
        List<Integer> right = sortArray(nums, mid+1, end);
        return merge(left, right);
    }
    
    public List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> res = new ArrayList<Integer>();
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()){
            if(left.get(l) >= right.get(r)){
                res.add(right.get(r));
                    r++;
            } else{
                res.add(left.get(l));
                l++;
            }
        }
        while(l < left.size()){
            res.add(left.get(l));
            l++;
        }
        while(r < right.size()){
            res.add(right.get(r));
            r++;
        }
        return res;
    }
}