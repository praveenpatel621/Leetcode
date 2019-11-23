package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 1200. Minimum Absolute Difference
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 * Example 1:
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2:
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 * Constraints:
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * */
public class _1200 {
    public static class Solution1 {
        /**
         * Time: O(nlogn) due to sorting
         * Space: O(k) where k is the distinct number of differences between two numbers in the given array
         * */
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                if (map.containsKey(diff)) {
                    List list = map.get(diff);
                    list.add(Arrays.asList(arr[i], arr[i + 1]));
                    map.put(diff, list);
                } else {
                    List list = new ArrayList<>();
                    list.add(Arrays.asList(arr[i], arr[i + 1]));
                    map.put(diff, list);
                }
            }
            return map.firstEntry().getValue();
        }
    }
}
