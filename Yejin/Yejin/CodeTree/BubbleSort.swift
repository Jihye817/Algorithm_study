//
//  BubbleSort.swift
//  Yejin
//
//  Created by Yejin Hong on 11/10/24.
//

func BubbleSort() {
    let n = Int(readLine()!)!
    var array = readLine()!.split(separator: " ").map { Int($0)! }.sorted()
    
    let result = array.map { String($0) }.joined(separator: " ")
    print(result)
}
