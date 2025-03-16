//
//  Deque_Sequence.swift
//  Yejin
//
//  Created by Yejin Hong on 2/18/25.
//

func deque_sequence() {
    let input = Int(readLine()!)!
    var list = DoublyLinkedList()
    
    for num in 1...input {
        list.push_back(value: num)
    }
    
    while list.size > 1 {
        list.pop_front() // 맨 앞에 요소 삭제
        
        let first = list.front() // 맨 앞의 요소를 저장해두고
        list.pop_front() // 맨 앞 요소를 삭제한 뒤
        list.push_back(value: first!) // 저장해둔 값을 뒤로 보내기
    }
    
    print(list.front()!)
}
