//
//  B_2750.swift
//  Yejin
//
//  Created by Yejin Hong on 11/10/24.
//

func B_2750() {
    var array: [Int] = []
    let number = Int(readLine()!)!
    
    for _ in 0..<number {
        let input = Int(readLine()!)!
        array.append(input)
    }
    
    array.sort()
    array.forEach { i in print(i) }
}
