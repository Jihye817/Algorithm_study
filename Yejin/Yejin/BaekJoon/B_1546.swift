//
//  B_1546.swift
//  Yejin
//
//  Created by Yejin Hong on 11/7/24.
//

func B_1546() {
    let subjects = Double(readLine()!)!
    let score = readLine()!.split(separator: " ").map{ Double($0)! }
    let maxScore = score.max()!
    
    let newScore = score.map { $0 * 100.0 / maxScore }
    let result = newScore.reduce( 0.0, + ) / subjects
    
    print(result)
}
