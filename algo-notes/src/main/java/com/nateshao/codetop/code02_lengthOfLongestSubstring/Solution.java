package com.nateshao.codetop.code02_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/8/11 23:49
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    /**
     * 滑动窗口+hashSet
     * 1. 定义双指针
     * 2. 在s.length遍历，
     * 当set不含有重复元素。右指针向右移动，不重复就添加进去，右指针++
     * 如果含有重复元素，右指针不动，左指针向右移动，删除左指针经过的重复元素，left++;
     * 3. res = 每次记录set的大小
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) { //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            } else {
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());//每一次计算当前set子串的长度
        }
        return res;
    }
}
