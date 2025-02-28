//
//  B_1966.swift
//  Yejin
//
//  Created by Yejin Hong on 2/19/25.
//

func B_1966() {
    let testCase = Int(readLine()!)!
    var result = 0
    
    for _ in 0 ..< testCase {
        let firstLine = readLine()!.split(separator: " ").map { Int($0)! }
        var priority = readLine()!.split(separator: " ").map{ Int($0)! }
        
        var wantedIndex = firstLine[1]
        
        while true {
            if priority[0] != priority.max() { // 맨 앞이 최대가 아닐 때
                if wantedIndex > 0 {
                    wantedIndex -= 1
                } else {
                    wantedIndex = priority.count - 1
                }
                
                let first = priority[0]
                priority.removeFirst()
                priority.append(first)
            } else if priority[0] == priority.max(), wantedIndex != 0 { // 맨 앞이 최대인데 원하는 인덱스가 아닐 때
                priority.removeFirst()
                wantedIndex = wantedIndex - 1
                result += 1
            } else { // 맨 앞이 최대이면서 원하는 인덱스일 때
                priority.removeFirst()
                result += 1
                print(result)
                break
            }
        }
        
        result = 0
    }
}
