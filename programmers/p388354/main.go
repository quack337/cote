package main

import (
	"fmt"
)

const 정홀짝 = 0
const 역홀짝 = 1

func dfs(node int, nodeValues []int, neighbors [][]int, visited []bool, count []int) {
    if visited[node] { return }
    visited[node] = true
    if nodeValues[node]%2 == len(neighbors[node])%2 {
        count[정홀짝]++
    } else {
        count[역홀짝]++
    }
    for _, neighbor := range neighbors[node] {
        dfs(neighbor, nodeValues, neighbors, visited, count)
    }
}

func solution(nodeValues []int, edges [][]int) []int {
    nodeIndex := make(map[int]int)
    for i, value := range nodeValues {
        nodeIndex[value] = i
    }
    neighbors := make([][]int, len(nodeValues))
    for _, edge := range edges {
        a, b := nodeIndex[edge[0]], nodeIndex[edge[1]]
        neighbors[a] = append(neighbors[a], b)
        neighbors[b] = append(neighbors[b], a)
    }
    answer := []int{0, 0}
    visited := make([]bool, len(nodeValues))
    for node := 0; node < len(nodeValues); node++ {
        if !visited[node] {
            count := []int{0, 0}
            dfs(node, nodeValues, neighbors, visited, count)
            if count[정홀짝] == 1 { answer[0]++ }
            if count[역홀짝] == 1 { answer[1]++ }
        }
    }
    return answer
}

func main() {
    nodeValues := []int{11, 9, 3, 2, 4, 6}
    edges := [][]int{{9, 11}, {2, 3}, {6, 3}, {3, 4}}
    answer := solution(nodeValues, edges)
    fmt.Println(answer[0], answer[1])

    nodeValues = []int{9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10}
    edges = [][]int{{5, 14}, {1, 4}, {9, 11}, {2, 15}, {2, 5}, {9, 7}, {8, 1}, {6, 4}}
    answer = solution(nodeValues, edges)
    fmt.Println(answer[0], answer[1])
}
