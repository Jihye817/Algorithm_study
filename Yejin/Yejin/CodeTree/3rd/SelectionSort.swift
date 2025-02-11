//
//  SelectionSort.swift
//  Yejin
//
//  Created by Yejin Hong on 11/19/24.
//

func selectionSort(input: [Int]) {
    var array = input
    for i in 0 ..< array.count - 1 {
        var min = i
        for j in i + 1 ..< array.count {
            if array[j] < array[min] {
                min = j
            }
        }
        let temp = array[i]
        array[i] = array[min]
        array[min] = temp
    }
    print(array)
}
