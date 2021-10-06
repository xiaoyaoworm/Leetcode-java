//Union Find经典题目！

class Solution {
    public boolean equationsPossible(String[] equations) {
        if(equations == null) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(String equation: equations){
            char a = equation.charAt(0);
            if(!map.containsKey(a)) {
                map.put(a, index);
                index++;
            }
            char b = equation.charAt(3);
            if(!map.containsKey(b)) {
                map.put(b, index);
                index++;
            }
        }
        UF uf = new UF(index);
        
        for(String equation: equations){
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            char c = equation.charAt(1);
            if(c == '='){
                uf.union(map.get(a), map.get(b));
            }
        }
        
        for(String equation: equations){
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            char c = equation.charAt(1);
            if(c == '!'){
                int x = uf.find(map.get(a));
                int y = uf.find(map.get(b));
                if(x==y) return false;
            }
        }
        return true;
    }
    
    public class UF{
        private int count;
        private int[] parent;
        public UF(int n){
            this.count = n;
            parent = new int[n];
            for(int i = 0; i <n; i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            while(x != parent[x]){
                x = find(parent[x]);
            }
            return x;
        }
        
        public void union(int x, int y){
            int p = find(x);
            int q = find(y);
            if(p == q) return;
            parent[p] = parent[q];
            count--;
        }
    }
}