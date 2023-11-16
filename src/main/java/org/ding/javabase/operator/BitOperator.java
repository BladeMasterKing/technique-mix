package org.ding.javabase.operator;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
public class BitOperator {
    public static void main(String[] args) {
        // 二进制补码
        notOperate();
        xorOperate();
    }

    public static void notOperate(){
        int a = 0b1000_0001,b = 0b1000_0000;
        System.out.println("源码值:" + a + " 非运算:" + ~a);
        System.out.println("源码值:" + b + " 非运算:" + ~b);
    }

    public static void xorOperate(){
        int a = 0b1000_0001, b = 0b1000_0000;
        System.out.println("源码A值:" + a +"源码B值:" + b + " 异或运算:" + (a^b));
    }
}
