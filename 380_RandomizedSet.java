public class RandomizedSet {
    
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> numPos;
    

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        numPos = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numPos.containsKey(val)) return false;
        int pos = nums.size();
        numPos.put(val, pos);
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!numPos.containsKey(val)) return false;
        int pos = numPos.get(val);
        if(pos < nums.size()-1){
            int last = nums.get(nums.size()-1);
            nums.set(pos, last); //Attention, here is set!!! it is updating!!!!!
            numPos.put(last, pos);
        }
        nums.remove(nums.size()-1);
        numPos.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */