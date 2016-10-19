public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	HashMap<String, ArrayList<String>> pairMap = new HashMap<String, ArrayList<String>>();
    	HashMap<String, ArrayList<Double>> valueMap = new HashMap<String, ArrayList<Double>>();
    	
        for(int i = 0; i < equations.length; i++){
        	String[] equation = equations[i];
        	if(!pairMap.containsKey(equation[0])){
        	    pairMap.put(equation[0], new ArrayList<String>());
        	    valueMap.put(equation[0], new ArrayList<Double>());
        	}
        	if(!pairMap.containsKey(equation[1])){
        	    pairMap.put(equation[1], new ArrayList<String>());
        	    valueMap.put(equation[1], new ArrayList<Double>());
        	}
        	pairMap.get(equation[0]).add(equation[1]);
        	pairMap.get(equation[1]).add(equation[0]);
        	valueMap.get(equation[0]).add(values[i]);
        	valueMap.get(equation[1]).add(1.0/values[i]);
        	
        }

        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
        	res[i] = dfs(pairMap, valueMap, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        	if(res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }   


    public double dfs(HashMap<String, ArrayList<String>> pairMap, HashMap<String, ArrayList<Double>> valueMap, String start, String end, HashSet<String> set, double value){	
        if(set.contains(start)) return 0.0;
        if(!pairMap.containsKey(start)) return 0.0;
        if(start.equals(end)) return value;
        double res = 0.0;
        
        set.add(start);
        ArrayList<String> pairs = pairMap.get(start);
        ArrayList<Double> values = valueMap.get(start);
        for(int i = 0; i < pairs.size(); i++){
            String pair = pairs.get(i);
            res = dfs(pairMap, valueMap, pair, end, set, value*values.get(i));
            if(res!=0.0) break;
        }
        set.remove(start);
        return res;
    }
}