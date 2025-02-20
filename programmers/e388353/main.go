package main

import (
	"fmt"
)

func clear(map2d [][]rune, ch rune, row, col int, visited [][]bool) {
    if row < 0 || col < 0 || row >= len(map2d) || col >= len(map2d[0]) { return }
    if visited[row][col] { return }
    visited[row][col] = true
    if map2d[row][col] == 0 {
        clear(map2d, ch, row-1, col, visited)
        clear(map2d, ch, row+1, col, visited)
        clear(map2d, ch, row, col-1, visited)
        clear(map2d, ch, row, col+1, visited)
    } else if map2d[row][col] == ch {
        map2d[row][col] = 0
    }
}

func solution(storage []string, requests []string) int {
    map2d := make([][]rune, len(storage))
    for i, s := range storage {
        map2d[i] = []rune(s)
    }
    for _, req := range requests {
        if len(req) == 2 {
            for r := 0; r < len(map2d); r++ {
                for c := 0; c < len(map2d[0]); c++ {
                    if map2d[r][c] == rune(req[0]) {
                        map2d[r][c] = 0
                    }
                }
            }
        } else {
            visited := make([][]bool, len(map2d))
            for i := range visited {
                visited[i] = make([]bool, len(map2d[0]))
            }
            for r := 0; r < len(map2d); r++ {
                clear(map2d, rune(req[0]), r, 0, visited)
                clear(map2d, rune(req[0]), r, len(map2d[0])-1, visited)
            }
            for c := 0; c < len(map2d[0]); c++ {
                clear(map2d, rune(req[0]), 0, c, visited)
                clear(map2d, rune(req[0]), len(map2d)-1, c, visited)
            }
        }
    }
    answer := 0
    for r := 0; r < len(map2d); r++ {
        for c := 0; c < len(map2d[0]); c++ {
            if map2d[r][c] != 0 {
                answer++
            }
        }
    }
    return answer
}

func main() {
    storage1 := []string{"AZWQY", "CAABX", "BBDDA", "ACACA"}
    requests1 := []string{"A", "BB", "A"}
    answer := solution(storage1, requests1)
    fmt.Println(answer)

    storage2 := []string{"HAH", "HBH", "HHH", "HAH", "HBH"}
    requests2 := []string{"C", "B", "B", "B", "B", "H"}
    answer = solution(storage2, requests2)
    fmt.Println(answer)
}
