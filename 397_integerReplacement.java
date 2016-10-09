//Using BFS, be careful, there may have integer overflow problem because there has one +1

public class Solution {
    public int integerReplacement(int n) {
        if(n <= 1) return 0;
        Queue<Entity> queue = new LinkedList<Entity>();
        queue.add(new Entity(n, 0));
        while(!queue.isEmpty()){
            Entity temp = queue.remove();
            if(temp.number == 1) return temp.step;
            if(temp.number%2 == 0){
                queue.add(new Entity(temp.number/2, temp.step+1));
            } else{
                queue.add(new Entity(temp.number+1, temp.step+1)); 
                //using long can get rid of overflow problem, because temp.number could Integer.MAX_VALUE
                queue.add(new Entity(temp.number-1, temp.step+1));
            }
        }
        return 0;
    }
    
    public class Entity{
        public long number; 
        public int step;
        
        public Entity(long number, int step){
            this.step = step;
            this.number = number;
        }
    }
}