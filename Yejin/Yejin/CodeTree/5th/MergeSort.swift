//
//  MergeSort.swift
//  Yejin
//
//  Created by Yejin Hong on 2/3/25.
//

func mergeSort(_ array: inout [Int], _ low: Int, _ high: Int) {
    if low < high {
        let mid = (low + high) / 2 // 배열을 반으로 자르기 위해 mid 값 추출
        mergeSort(&array, low, mid) // 왼쪽 배열 정렬 후 병합(길이가 1인 경우에는 실행 안됨)
        mergeSort(&array, mid + 1, high) // 오른쪽 배열 정렬 후 병합(길이가 1인 경우에는 실행 안됨)
        merge(array, low, mid, high) // 정렬된 두 배열 병합
    }
}

var mergedArray: [Int] = Array.init(repeating: 0, count: 10)

func merge(_ array: [Int], _ low: Int, _ mid: Int, _ high: Int) {
    
}

//func merge(_ array: inout [Int], _ low: Int, _ mid: Int, _ high: Int) {
//    var i = low
//    var j = mid + 1
//    
//    var k = low
//    
//    while i <= mid && j <= high { // 왼쪽 배열의 시작점, 오른쪽 배열의 시작점
//        if array[i] <= array[j] { // 배열의 첫번째 값들 끼리 비교
//            mergedArray[k] = array[i]
//            k += 1
//            i += 1
//        } else {
//            mergedArray[k] = array[j]
//            k += 1
//            j += 1
//        }
//    }
//    
//    while i <= mid {
//        mergedArray[k] = array[i]
//        k += 1
//        i += 1
//    }
//
//    while j <= high {
//        mergedArray[k] = array[j]
//        k += 1
//        j += 1
//    }
//    
//    for k in low ..< high {
//        array[k] = mergedArray[k]
//    }
//    
//    print("Merged Array = \(mergedArray)")
//}

