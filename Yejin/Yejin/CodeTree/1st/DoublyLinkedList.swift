//
//  Doubly-LinkedList : 정수 명령 처리 8.swift
//  Yejin
//
//  Created by Yejin Hong on 11/3/24.
//

class Node {
    var prev: Node?
    var next: Node?
    var data: Int
    
    init(data: Int){
        self.data = data
    }
}

struct DoublyLinkedList {
    private(set) var head: Node?
    private(set) var tail: Node?
    private(set) var size: Int = 0
    
    mutating func push_front(value: Int) {
        let newNode = Node(data: value)
        
        if size == 0 {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
        
        size += 1
    }
    
    mutating func push_back(value: Int) {
        let newNode = Node(data: value)
        
        if size == 0 {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
        
        size += 1
    }
    
    mutating func pop_front() -> Int? {
        let result = head?.data
        
        if size == 0 { return nil }
        
        if size == 1 {
            head = nil
        } else {
            head = head?.next
            head?.prev = nil
        }
        
        size -= 1
        
        return result
    }
    
    mutating func pop_back() -> Int? {
        let result = tail?.data
        
        if size == 0 { return nil }
        
        if size == 1 {
            head = nil
        } else {
            tail = tail?.prev
            tail?.next = nil
        }
        size -= 1
        
        return result
    }
    
    func empty() -> Bool {
        return size == 0
    }
    
    mutating func front() -> Int? {
        if size == 0 { return nil }
        
        return head?.data
    }
    
    func back() -> Int? {
        if size == 0 { return nil }
        
        return tail?.data
    }
}

func calculate() {
    var doublyLinkedList = DoublyLinkedList()
    let `repeat` = Int(readLine()!)!
    
    for _ in 1...`repeat` {
        let input = readLine()!.split(separator: " ")
        
        let calculator = String(input[0])
        var num = 0
        
        if input.count > 1 { num = Int(input[1])! }
        
        switch calculator {
        case "push_front":
            print(doublyLinkedList.push_front(value: num))
        case "push_back":
            print(doublyLinkedList.push_back(value: num))
        case "pop_front":
            print(doublyLinkedList.pop_front())
        case "pop_back":
            print(doublyLinkedList.pop_back())
        case "size":
            print(doublyLinkedList.size)
        case "empty":
            print(doublyLinkedList.empty())
        case "front":
            print(doublyLinkedList.front())
        case "back":
            print(doublyLinkedList.back())
        default:
            print("Error?")
        }
    }
}

