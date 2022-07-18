/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(startUrl);
        Set<String> set = new HashSet<>();
        set.add(startUrl);
        String hostName = getHostName(startUrl);
        
        while(!queue.isEmpty()){
            String current = queue.remove();
            res.add(current);
            List<String> list = htmlParser.getUrls(current);
            for(String url: list){
                if(!set.contains(url) && getHostName(url).equals(hostName)){
                    queue.add(url);
                    set.add(url);
                }
            }
        }
        return res;
    }
    
    private String getHostName(String url){
        return url.split("/")[2];
    }
}