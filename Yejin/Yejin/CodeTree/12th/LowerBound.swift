//
//  LowerBound.swift
//  Yejin
//
//  Created by Yejin Hong on 2/10/25.
//
// 0  1  2  3  4  5  6  7  8  9  10
//[1, 3, 4, 6, 6, 6, 6, 7, 9, 11, 15] -> 11

func lowerBound(array: [Int], target: Int) {
    var left = 0 // 처음
    var right = array.count - 1 // 끝
    var min_idx = array.count
    
    while left <= right {
        let mid = (left + right) / 2
        if array[mid] >= target {
            right = mid - 1
            min_idx = min(min_idx, mid)
        } else {
            left = mid + 1
        }
    }
    
    print(min_idx)
}
