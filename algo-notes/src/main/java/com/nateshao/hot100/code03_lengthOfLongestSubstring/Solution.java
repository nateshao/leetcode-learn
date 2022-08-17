package com.nateshao.hot100.code03_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2022/4/20 15:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 滑动窗口
     * 暴力解法时间复杂度较高，会达到 O(n2)，故而采取滑动窗口的方法降低时间复杂度
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 left，结束位置为 right
     * 随着 right 不断遍历向后，会遇到与 [left, right] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 left，此时 [left, right] 区间内不存在重复字符
     * 无论是否更新 left，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char alpha = s.charAt(right);
            if (map.containsKey(alpha)) {
                left = Math.max(map.get(alpha), left);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return ans;
    }

    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
    public int lengthOfLongestSubstring2(String s) {
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
     * 这题比其他滑动窗口的题目简单，连 need 和 valid 都不需要，而且更新窗口内数据也只需要简单的更新计数器 window 即可。
     * <p>
     * 当 window[c] 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 left 缩小窗口了。
     * <p>
     * 另外，要在收缩窗口完成后更新 res，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }


}
