//
//  LowerBound.swift
//  Yejin
//
//  Created by Yejin Hong on 2/10/25.
//

// LowerBound : Target 이상의 값이 최초로 나오는 위치

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
