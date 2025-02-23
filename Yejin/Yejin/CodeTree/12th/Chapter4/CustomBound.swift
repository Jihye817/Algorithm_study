//
//  CustomBound.swift
//  Yejin
//
//  Created by Yejin Hong on 2/11/25.
//

// CustomBound : Target 보다 같거나 작은 값 중 가장 큰 Index

func customBound(array: [Int], target: Int) {
    var left = 0
    var right = array.count - 1
    var max_idx = -1 // 답이 될 수 없는 최솟값
    
    while left <= right {
        var mid = (left + right) / 2
        
        if array[mid] <= target {
            left = mid + 1
            max_idx = max(max_idx, mid) // 해당 되는 값 중 제일 큰 값
        } else {
            right = mid - 1
        }
    }
    
    print(max_idx)
}
