package practice.easy;

public class matrixReshape566 {

    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        int[][] rs = matrixReshape(a,r,c);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }

        int[][] res = new int[r][c];
        for(int i = 0;i<r*c;i++){
            int matR = i/n;
            int matC = i%n;
            int value = mat[matR][matC];
            int resR = i/c;
            int resC = i%c;
            res[resR][resC] = value;
        }
        return res;
    }
}
