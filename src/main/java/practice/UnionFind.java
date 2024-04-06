package practice;

public class UnionFind {
    private int[] parent;
    private int count;

    public UnionFind(int number) {
        this.count = number;
        parent = new int[number];
        for(int i = 0; i< number;i++){
            parent[i] = i;
        }
    }

    public void connect(int a, int b){
        int a_p = find_parent(a);
        int b_p = find_parent(b);
        if(a_p == b_p){
            return;
        }
        count --;
        parent[a_p] = b_p;
    }

    public int find_parent(int i){
        if(parent[i]!=i){
            parent[i] = find_parent(parent[i]);
        }
        return parent[i];
    }

    public boolean isConnected(int a, int b){
        int a_p = find_parent(a);
        int b_p = find_parent(b);
        if(a_p == b_p){
            return true;
        }
        return false;
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{0,2},{3,4}};
        UnionFind uf = new UnionFind(n);
        for(int[] edge :edges){
            uf.connect(edge[0],edge[1]);
        }
        System.out.println(uf.getCount());
    }
}
