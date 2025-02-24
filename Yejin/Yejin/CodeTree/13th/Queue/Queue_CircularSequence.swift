//
//  Queue_CircularSequence.swift
//  Yejin
//
//  Created by Yejin Hong on 2/17/25.
//

func queue_CircularSequence() {
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let n = input[0] // N 명의 사람들
    let k = input[1] // K 번째 사람을 제거
    
    var circularList = DoublyLinkedList_v2()
    
    for data in 1...n {
        circularList.push(data)
    }
    
    var current = circularList.head
    
    while !circularList.isEmpty {
        for _ in 1..<k {
            current = current?.next
        }
        
        // 현재 노드 삭제 및 다음 노드로 이동
        if let nodeToRemove = current {
            print(nodeToRemove.data, terminator: " ")
            current = circularList.remove(nodeToRemove)
        }
    }
}

class Node_v2 {
    var prev: Node_v2?
    var next: Node_v2?
    var data: Int
    
    init(data: Int) {
        self.data = data
    }
}

struct DoublyLinkedList_v2 {
    private(set) var head: Node_v2?
    private(set) var tail: Node_v2?
    private(set) var size: Int = 0
    
    var isEmpty: Bool { size == 0 }
    
    mutating func push(_ newData: Int) {
        let newNode = Node_v2(data: newData)
        
        if size == 0 {
            head = newNode
            tail = newNode
            newNode.next = newNode
            newNode.prev = newNode
        } else {
            newNode.prev = tail
            newNode.next = head
            tail?.next = newNode
            head?.prev = newNode
            tail = newNode
        }
        
        size += 1
    }
    
    mutating func remove(_ node: Node_v2) -> Node_v2? { // node가 삭제 된 이후 다음 노드
        guard size > 0 else { return nil }
        
        if size == 1 {
            head = nil
            tail = nil
        } else {
            node.prev?.next = node.next
            node.next?.prev = node.prev
            
            if node === head { // 현재 노드의 주소가 head 인지
                head = node.next
            }
            
            if node === tail { // 현재 노드의 주소가 tail 인지
                tail = node.prev
            }
        }
        
        size -= 1
        
        return node.next
    }
}
