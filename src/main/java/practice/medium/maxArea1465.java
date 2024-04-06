package practice.medium;

import java.util.Arrays;

public class maxArea1465 {

    public static void main(String[] args) {

    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        double mod = 1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hstart = horizontalCuts[0];
        int hend = h - horizontalCuts[horizontalCuts.length - 1];
        int vstart = verticalCuts[0];
        int vend = w - verticalCuts[verticalCuts.length - 1];
        int hmax = Math.max(hstart, hend);
        int vmax = Math.max(vstart, vend);
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            hmax = Math.max(hmax, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            vmax = Math.max(vmax, verticalCuts[i + 1] - verticalCuts[i]);
        }
        System.out.println(vmax);
        System.out.println(hmax);
        return (int) (hmax * vmax % mod);
    }

}
