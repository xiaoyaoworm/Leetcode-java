//First Tradeoff:
//Add is O(1) but find is O(n)
//Here the thought is using ArrayList to save unique number to instead of using set.iterator().

public class TwoSum {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    
    public TwoSum(){
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        list.add(number);
        if(map.containsKey(number)){
            map.put(number, map.get(number)+1);
        } else{
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++){
            int first = list.get(i);
            int second = value-first;
            //Be careful fo this equal scenario.
            if(first == second && map.get(first) > 1) return true; 
            if(first!=second && map.containsKey(second)) return true;
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


//Another Tradeoff:
//This will cause TLE but the thought is directly
//making add as O(n) but find is O(1) 

public class TwoSum {
    HashSet<Integer> num;
    HashSet<Integer> sum;
    
    public TwoSum(){
        num = new HashSet<Integer>();
        sum = new HashSet<Integer>();
    }
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(num.contains(number)) {
	        sum.add(number*2);
	    } else{
    	    Iterator<Integer> iterator = num.iterator();
    	    while(iterator.hasNext()){
    	        sum.add(iterator.next()+number);
    	    }
    	    num.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sum.contains(value);
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);