package practice.graph;

public class test {
    public static void main(String[] args) {
        findOrder210 test = new findOrder210();
        int num = 1;
        int[][] prerequisites = {};
        int[] rs = test.findOrder(num,prerequisites);
        for(int ri: rs){
            System.out.println(ri);
        }
    }
}
