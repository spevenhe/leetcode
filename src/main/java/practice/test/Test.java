package practice.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for(char c : input.toCharArray()){
                if("AEIOUaeiou".indexOf(c)!=-1){
                    sb.append(Character.toUpperCase(c));
                }
                else if(c ==' '){
                    sb.append(c);
                }else{
                    sb.append(Character.toLowerCase(c));
                }
            }
            System.out.println(sb.toString());

        }
    }

    public static void test1(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int bottle = in.nextInt();
            int res = 0;
            while (bottle / 3 >= 1) {
                int tmp = bottle / 3;
                res += tmp;
                bottle = tmp + bottle % 3;
            }
            if (bottle == 2) {
                res += 1;
            }
            if (res > 0) {
                System.out.println(res);
            }
        }
    }

    public static void test2(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0;i<n;i++){

                int tmp = in.nextInt();
                set.add(tmp);
            }
            for(int value: set){
                System.out.println(value);
            }

        }
    }

    public static void test3(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            int decimal = 0;
            for (int i = 2; i < input.length(); i++) {
                char c = input.charAt(i);
                int value = Character.digit(c, 16); // 将十六进制字符转换为对应的十进制值
                if (value == -1) {
                    throw new NumberFormatException("输入包含非十六进制字符：" + c);
                }
                decimal = decimal * 16 + value; // 根据十六进制的基数进行转换
            }
            System.out.println(decimal);
        }
    }



}
