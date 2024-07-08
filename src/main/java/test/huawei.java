package test;

import java.util.Scanner;

public class huawei {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            int n = line.length();
            String[] binarys = new String[n/2];
            boolean breakFlag = false;
            for(int i = 0; i < n; i++){
                char c = line.charAt(i);
                int val = (c >= '0' && c <= '9')? (c - '0') : (c+10) - 'A';
                String binary = Integer.toBinaryString(val);
                while (binary.length() <4){
                    binary = "0" + binary;
                }
//                System.out.println(binary);
                if(binarys[i/2]!=null){
                    binarys[i/2] += binary;
                }else {
                    binarys[i/2] = binary;
                }

            }
//            for(String binary : binarys){
//                System.out.println(binary);
//            }
            if(n==2){
                if(binarys[0].charAt(0)=='0'){
                    int res = Integer.parseInt(binarys[0].substring(1),2);
                    System.out.println(res);
                }else{
                    System.out.println(-1);
                }
                continue;
            }
            int oneCount = 0;
            String head = binarys[0];
            for(int i = 0; i < head.length(); i++){
                if(head.charAt(i)=='1'){
                    oneCount++;
                }else {
                    break;
                }
            }
            if(oneCount != n/2){
                System.out.println(-1);
                continue;
            }
            String stringRes = head.substring(oneCount);
            for(int i = 1; i < n/2; i++){
                String tmp = binarys[i];
                if(tmp.charAt(0)!='1' || tmp.charAt(1)!='0'){
                    System.out.println(-1);
                    breakFlag = true;
                    break;
                }else {
                    String tmpFromHead = tmp.substring(2);
                    stringRes = stringRes + tmpFromHead;
                }


            }
            if(breakFlag){
                continue;
            }
//            System.out.println(stringRes);
            System.out.println(Integer.parseInt(stringRes,2));

        }
    }


}
