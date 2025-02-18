//
//  Queue.swift
//  Yejin
//
//  Created by Yejin Hong on 2/17/25.
//

func queueFunction() {
    let n = Int(readLine()!)!
    var queue: [Int] = []
    var size: Int {
        return queue.count
    }
    var empty: Bool {
        return queue.isEmpty
    }
    
    for _ in 0 ..< n {
        let input = readLine()!.split(separator: " ")
        
        switch input.first {
        case "push":
            queue.append(Int(input[1])!)
        case "pop":
            if empty { return }
            print(queue.first!)
            queue.removeFirst()
        case "front":
            if empty { return }
            print(queue.first!)
        case "size":
            print(size)
        case "empty":
            print(empty ? 1 : 0)
        default:
            print("Default")
        }
    }
}
