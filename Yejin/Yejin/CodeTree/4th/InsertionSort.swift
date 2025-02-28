//
//  InsertionSort.swift
//  Yejin
//
//  Created by Yejin Hong on 11/22/24.
//

import Foundation

func insertionSort() {
    let input = Int(readLine()!)!
    var array = readLine()!.split(separator: " ").map{ Int($0)! }
    
    for i in 1 ..< array.count {
        var j = i - 1
        while j >= 0 {
            if array[j] > array[j + 1] {
                let temp = array[j + 1]
                array[j + 1] = array[j]
                array[j] = temp
            }
            j -= 1
        }
    }
    
    array.forEach { item in print(item, terminator: " ")}
}
