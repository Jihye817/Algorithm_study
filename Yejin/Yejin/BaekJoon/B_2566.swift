//
//  B_2566.swift
//  Yejin
//
//  Created by Yejin Hong on 11/7/24.
//
func B_2566() {
    var row: Int = 1
    var column: Int = 1
    var maxValue: Int = 0
    
    for i in 1...9 {
        let inputArr = readLine()!.split(separator: " ").map{ Int($0)! }
        let isMaxValue: Bool = maxValue < inputArr.max()!
        
        maxValue = isMaxValue ? inputArr.max()! : maxValue
        row = isMaxValue ? i : row
        column = isMaxValue ? inputArr.firstIndex(of: maxValue)! + 1 : column
    }
    
    print(maxValue)
    print(row, column)
}
