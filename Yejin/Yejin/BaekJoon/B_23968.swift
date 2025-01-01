//
//  B_23968.swift
//  Yejin
//
//  Created by Yejin Hong on 11/9/24.
//

func B_23968() {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let elements = readLine()!.split(separator: " ").map { Int($0)! }
    
    bubbleSort(array: elements, change: input[1])
}

func bubbleSort(array: [Int], change: Int) {
    var array = array
    var times = 0
    
    for i in 0..<array.count - 1 {
        for j in 0..<array.count - 1 {
            if array[j] > array[j+1] {
                let temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
                
                times += 1
            }
            
            if times == change {
                print(array[j], array[j+1])
                return
            }
        }
    }
    
    if times < change { print("-1") }
}
