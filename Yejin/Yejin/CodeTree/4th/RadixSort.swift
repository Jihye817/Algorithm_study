//
//  RadixSort.swift
//  Yejin
//
//  Created by Yejin Hong on 11/22/24.
//
import Foundation

func radixSort() {
    let input = Int(readLine()!)!
    var array = readLine()!.split(separator: " ").map{ Int($0)! }
    let maxLength = String(array.max()!).count
    
    var sortArray = [[Int]]()
    
    for index in 0 ..< maxLength {
        sortArray = [[Int]](repeating: [], count: 10)
        
        for item in array {
            if item.split().count < index + 1 {
                sortArray[0].append(item)
                return
            }
            
            let indexNum = item.split()[index]
            sortArray[indexNum].append(item)
            
            array = sortArray.flatMap { $0 }
        }
    }
    
    sortArray.forEach { items in
        items.forEach { item in
            print(item, terminator: " ")
        }
    }
}

extension Int {
    func split() -> [Int] {
        var array: [Int] = []
        
        for char in String(self) {
            array.append(Int(String(char))!)
        }
        
        return array
    }
}
