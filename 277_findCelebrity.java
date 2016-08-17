/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        
        for(int j = 0; j < n; j++){
            if(j == candidate) continue;
            if(!knows(j, candidate) || knows(candidate, j)) return -1;
        }
        return candidate;
    }
}