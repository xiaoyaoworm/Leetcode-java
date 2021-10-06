class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(accounts == null || accounts.size() == 0) return res;
        
        int size = accounts.size();
        UF uf = new UF(size);
        
        Map<String, Integer> mailToIndex = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(mailToIndex.containsKey(email)){
                    uf.union(i, mailToIndex.get(email));
                } else{
                    mailToIndex.put(email, i);
                }
            }
        }
        
        Map<Integer, Set<String>> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            int id = uf.find(i);
            map.putIfAbsent(id, new HashSet<String>());
            Set<String> curSet = map.get(id);
            for(int j = 1; j < accounts.get(i).size(); j++){
                curSet.add(accounts.get(i).get(j));
            }
            map.put(id, curSet);
        }
        
        for(int index: map.keySet()){
            List<String> list = new ArrayList<String>();
            list.addAll(map.get(index));
            Collections.sort(list);
            list.add(0, accounts.get(index).get(0));
            res.add(list);
        }
        
        return res;
    }

    
    public class UF{
        int[] parents;
        int count;
        public UF(int n){
            this.count = n;
            parents = new int[n];
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }
        }
        
        public void union(int x, int y){
            int p = find(x);
            int q = find(y);
            if(p == q) return;
            parents[p] = q;
            count--;
        }
        
        public int find(int x){
            while(parents[x]!=x){
                x = find(parents[x]);
            }
            return x;
        }
    }
}