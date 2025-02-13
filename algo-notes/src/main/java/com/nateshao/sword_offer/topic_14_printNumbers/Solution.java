package com.nateshao.sword_offer.topic_14_printNumbers;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2021/11/21 16:22
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {

    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

}
