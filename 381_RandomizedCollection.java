public class RandomizedCollection {
    int count;
    HashMap<Integer, HashSet<Integer>> numPos;
    ArrayList<Integer> nums;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.count = 0;
        this.numPos = new HashMap<Integer, HashSet<Integer>>();
        this.nums = new ArrayList<Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        HashSet<Integer> set = null;
        if(numPos.containsKey(val)){
            set = numPos.get(val);
        } else{
            set = new HashSet<Integer>();
            res = true;
        }
        set.add(count);
        numPos.put(val, set);
        nums.add(val);
        count++;
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = false;
        if(numPos.containsKey(val)) {
            res = true;
            HashSet set = numPos.get(val);
            Iterator<Integer> iterator = set.iterator();
            int index = iterator.next();
            set.remove(index); 
            if(set.size()!=0) numPos.put(val, set);
            else numPos.remove(val);

            int last = nums.get(count-1);
            nums.set(index, last);
            HashSet lastSet = numPos.get(last);
            if(lastSet!=null){ //update last value's set, be careful it maybe null! because we remove some val above.
                lastSet.add(index);
                lastSet.remove(count-1);
            }

            nums.remove(count-1);
            count--;
        }
        return res;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(count);
        return nums.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */