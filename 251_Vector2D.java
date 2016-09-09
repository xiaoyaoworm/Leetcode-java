public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    int x;
    int y;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.x = 0;
        this.y = 0;
        while(x < vec2d.size() && (vec2d.get(x) == null || vec2d.get(x).size() == 0)){
            x++;
        }
    }

    @Override
    public Integer next() {
        List<Integer> cur = vec2d.get(x);
        int res = cur.get(y);
        if(y == cur.size()-1){
            x++;
            y = 0;
            while(x < vec2d.size() && (vec2d.get(x) == null || vec2d.get(x).size() == 0)){
                x++;
            }
        } else{
            y++;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if(x == vec2d.size()) return false;
        else return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */