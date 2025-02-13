package com.nateshao.test.test_07_25;


/**
 * @date Created by 邵桐杰 on 2022/7/25 20:18
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 实现一个单例类
 */
public class Singletence {
    /**
     * 1，创建类型变量
     * 2，构造方法
     * 3，单例实现
     */
    private static Singletence singletence = null;

    //1,2,34,
    private Singletence() {
    }

    synchronized public static Singletence getSingletence() {
        if (singletence == null) {
            singletence = new Singletence();
        }
        return singletence;
    }

}
