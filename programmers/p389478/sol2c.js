
function solution(n, width, x) {
    let col = 0, col_x = 0, answer = 0;
    let direction = 1;
    for (let i = 1; i <= n; i++) {
        if (i == x) col_x = col;
        if (i >= x && col_x == col) ++answer;
        col += direction;
        if (col == width) {
            col = width - 1;
            direction = -1;
        } else if (col < 0) {
            col = 0;
            direction = 1;
        }
    }
    return answer;
}

console.log(solution(22, 6, 8));
console.log(solution(13, 3, 6));
