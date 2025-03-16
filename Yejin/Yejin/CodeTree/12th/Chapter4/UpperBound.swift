//
//  UpperBound.swift
//  Yejin
//
//  Created by Yejin Hong on 2/10/25.
//

// UpperBound : Target을 초과하는 값이 최초로 나오는 위치

func upperBound(array: [Int], target: Int) { // target을 초과하는 값이 제일 처음 나오는 위치
    var left = 0
    var right = array.count - 1
    var min_idx = array.count
    
    while left <= right {
        let mid = (left + right) / 2
        
        if array[mid] > target {
            right = mid - 1
            min_idx = min(min_idx, mid)
        } else {
            left = mid + 1
        }
    }
    
    print(min_idx)
}
