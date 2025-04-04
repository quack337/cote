package main

import "fmt"

func check(q [][]int, ans []int, a int, b int, c int, d int, e int) bool {
	for i := 0; i < len(q); i++ {
		count := 0
		for j := 0; j < 5; j++ {
			v := q[i][j]
			if v == a || v == b || v == c || v == d || v == e {
				count++
			}
		}
		if count != ans[i] {
			return false
		}
	}
	return true
}

func solution(n int, q [][]int, ans []int) int {
	answer := 0
	for a := 1; a <= n-4; a++ {
	for b := a + 1; b <= n-3; b++ {
	for c := b + 1; c <= n-2; c++ {
	for d := c + 1; d <= n-1; d++ {
	for e := d + 1; e <= n; e++ {
		if check(q, ans, a, b, c, d, e) {
			answer++
		}
	}}}}}
	return answer
}

func main() {
	n := 10
	q := [][]int {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}}
	ans := []int {2, 3, 4, 3, 3}
	answer := solution(n, q, ans)
	fmt.Println(answer)

	n = 15
	q = [][]int {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}}
	ans = []int {2, 1, 3, 0, 1}
	answer = solution(n, q, ans)
	fmt.Println(answer)
}