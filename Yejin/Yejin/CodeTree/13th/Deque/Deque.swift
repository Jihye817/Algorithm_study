//
//  Deque.swift
//  Yejin
//
//  Created by Yejin Hong on 2/18/25.
//

func deque() {
    var deque = DoublyLinkedList()
    let num = Int(readLine()!)!
    
    for _ in 0 ..< num {
        let input = readLine()!.split(separator: " ")
        
        switch input[0] {
        case "push_front":
            deque.push_front(value: Int(input[1])!)
        case "push_back":
            deque.push_back(value: Int(input[1])!)
        case "pop_front":
            print(deque.pop_front()!)
        case "pop_back":
            print(deque.pop_back()!)
        case "front":
            print(deque.front()!)
        case "back":
            print(deque.back()!)
        case "empty":
            print(deque.empty() ? 1 : 0)
        case "size":
            print(deque.size)
        default:
            print("Default")
        }
    }
}
