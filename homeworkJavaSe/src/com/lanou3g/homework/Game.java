package com.lanou3g.homework;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    public static void handSpeedGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("请选择游戏难度：1，简单(10个字符包含字母和数字)    2，适中（20个字符含有大小写字母的变化）    3，困难（30个字符含有字符：~！@#￥%^&*（）{}[]\\/.,<>?_-+=）");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                Game.timer();
                long start = System.currentTimeMillis();
                simple();
                long end = System.currentTimeMillis();
                System.out.println("打完花费的时间：" + (end - start) + "毫秒");
                break;
            case 2:
                long start1 = System.currentTimeMillis();
                moderate();
                long end1 = System.currentTimeMillis();
                System.out.println("打完花费的时间：" + (end1 - start1) + "毫秒");
                break;
            case 3:
                long start2 = System.currentTimeMillis();
                difficulty();
                long end2 = System.currentTimeMillis();
                System.out.println("打完花费的时间：" + (end2 - start2 ) + "毫秒");
                break;
                default:
                    break;
        }
    }
    public static void timer(){
        for (int i = 3; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("倒计时"+ i + "秒钟后开始");
        }
        System.out.println("开始");
    }
    public static void simple(){
        Math.random();
//        String str = input.next();
//        String regex = "[0-9a-z]{10}";
//        if (str.matches(regex) == true){
//            System.out.println(str);
//        }else {
//            System.out.println("你输入的不满足条件，游戏结束");
//        }
    }

    public static void moderate(){
        String str = input.next();
        String regex = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{20}$";
        if (str.matches(regex) == true){
            System.out.println(str);
        }
    }

    public static void difficulty(){
        String str = input.next();
        String regex = "^[~！@#￥%^&*（）{}.,<>?+-=].{30}$";
        if (str.matches(regex) == true){
            System.out.println(str);
        }
    }
}
