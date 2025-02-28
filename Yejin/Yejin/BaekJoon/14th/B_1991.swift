//
//  B_1991.swift
//  Yejin
//
//  Created by Yejin Hong on 2/24/25.
//

let number = Int(readLine()!)!
var tree: [String: Node2] = [:]

func B_1996() {
    for _ in 0 ..< number {
        let input = readLine()!.split(separator: " ").map { String($0) }
        tree[input[0]] = Node2(leftChild: input[1], rightChild: input[2])
    }
    
    let order = [preOrderTraversal, inOrderTraversal, postOrderTraversal]
    
    order.forEach {
        $0("A")
        print("")
    }
}

struct Node2 {
    let leftChild: String
    let rightChild: String
}

func preOrderTraversal(_ target: String) {
    if target == "." { return }
    
    print(target, terminator: "")
    preOrderTraversal(tree[target]!.leftChild)
    preOrderTraversal(tree[target]!.rightChild)
}

func inOrderTraversal(_ target: String) {
    if target == "." { return }
    inOrderTraversal(tree[target]!.leftChild)
    print(target, terminator: "")
    inOrderTraversal(tree[target]!.rightChild)
}

func postOrderTraversal(_ target: String) {
    if target == "." { return }
    postOrderTraversal(tree[target]!.leftChild)
    postOrderTraversal(tree[target]!.rightChild)
    print(target, terminator: "")
}
