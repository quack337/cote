function solution(n, w, x) {
    let a = Array(n / w + 1).fill(0)
    let col_x
    let i = 1, row = 0, col = 0
    while (i < x) {
        a[row][col] = i;
        ++i; ++col;
        if (col == w) {
            col = 0;
            ++row;
        }
    }




}

console.log(solution(22, 6, 8));
console.log(solution(13, 3, 6));
