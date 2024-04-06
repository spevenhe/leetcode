import java.util.Arrays;
import java.util.TreeMap;

public class advantageCount870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        TreeMap<Integer[],Integer> map = new TreeMap<>((o1, o2)->{return o2[0]-o1[0];});
        for(int i = 0;i<nums2.length;i++){
            Integer[] key = new Integer[1];
            key[0] = nums2[i];
            map.put(key,i);
        }
        int left = 0;
        int right = nums1.length-1;
        int[] res = new int[nums1.length];
        for(Integer[] value : map.keySet()){
            int tmp = value[0].intValue();
            if(value[0]<nums1[right]){

                res[map.get(value[0])] = nums1[right];
                right--;
            }
            else {
                res[map.get(value[0])] = nums1[left];
                left++;

            }
        }
        return res;
    }
}
