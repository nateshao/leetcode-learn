package com.nateshao.source.code.java_base.base;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2023/2/21 13:52
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Scanner_jishu_oushu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int res = sc.nextInt();
        if (res % 2 == 0) System.out.println(res + "是偶数");
        else System.out.println(res + "是奇数");
    }
}
