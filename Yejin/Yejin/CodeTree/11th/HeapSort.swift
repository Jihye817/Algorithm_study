//
//  HeapSort.swift
//  Yejin
//
//  Created by Yejin Hong on 1/22/25.
//
// 첫번째 줄에는 n
// 두번째 줄에는 n개의 원소 값이 공백을 두고 주어짐
// 1 <= n <= 100,000
// 1 <= 원소 값 <= 100,000

func heapify(array: [Int], n: Int, i: Int) {
    var arr = array
    
    var largest = i
    var l = i * 2
    var r = i * 2 - 1
    
    if l <= n && array[l] > array[largest] {
        largest = l
    }
    
    if r <= n && array[r] > array[largest] {
        largest = r
    }
    
    if largest != i {
        // swap(arr[i], arr[largest])
        heapify(array: array, n: n, i: largest)
    }
}

func heapSort() {
    let number = readLine()
    let elements = readLine()!.split(separator: " ").map{ Int($0)! }
    
    
}
