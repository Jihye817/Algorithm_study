//
//  BubbleSort.swift
//  Yejin
//
//  Created by Yejin Hong on 11/10/24.
//

func bubbleSort(input: [Int]) {
    var array = input
    for _ in 0 ..< array.count - 1 {
        for i in 0 ..< array.count - 1 {
            if array[i] > array[i + 1] {
                let temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
    }
    print(array)
}

//func BubbleSort() {
//    let n = Int(readLine()!)!
//    var array = readLine()!.split(separator: " ").map { Int($0)! }.sorted()
//
//    let result = array.map { String($0) }.joined(separator: " ")
//    print(result)
//}
