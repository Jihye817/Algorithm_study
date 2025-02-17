//
//  Stack_Parenthese.swift
//  Yejin
//
//  Created by Yejin Hong on 2/16/25.
//

func stack_patrentheses() {
    let input = readLine()!.map{String($0)}
    var stack: [String] = []
    
    for char in input {
        switch char {
        case "(":
            stack.append(char)
        case ")":
            if !stack.isEmpty {
                stack.removeLast()
            } else {
                print("No")
                return
            }
        default:
            print("Default")
        }
    }
    
    if stack.isEmpty {
        print("Yes")
    } else {
        print("No")
    }
}
