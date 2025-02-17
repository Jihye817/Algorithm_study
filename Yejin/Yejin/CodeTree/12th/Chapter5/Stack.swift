//
//  Stack.swift
//  Yejin
//
//  Created by Yejin Hong on 2/11/25.
//

func stack() {
    let input = Int(readLine()!)!
    
    var items: [Int]  = []
    var size: Int { items.count }
    var empty: Bool { items.isEmpty }

    func push(_ num: Int) { items.append(num) }

    func pop() -> Int? {
        if empty { return nil }
        
        return items.popLast()
    }

    func top() -> Int? {
        if empty { return nil }
        
        return items.last
    }

    for _ in 0..<input {
        let request = readLine()!.split(separator: " ")
        
        switch request.first {
        case "push":
            push(Int(request[1])!)
        case "pop":
            print(pop()!)
        case "size":
            print(size)
        case "empty":
            print(empty ? 1 : 0)
        case "top":
            print(top()!)
        default:
            print("Error?")
        }
    }
}

