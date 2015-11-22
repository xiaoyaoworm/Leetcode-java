public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(G<A ||C<E || D<F ||H <B) return (C-A)*(D-B)+(G-E)*(H-F);
        int a = Math.max(A,E);
        int b = Math.min(C,G);
        int c = Math.max(B,F);
        int d = Math.min(D,H);
        return (C-A)*(D-B)+(G-E)*(H-F) - (b-a)*(d-c);
    }
}