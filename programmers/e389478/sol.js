
let row, col, step, width;

function next() {
    col += step;
    if (col < 0) {
        ++row; col = 0;
        step = 1;
    } else if (col == width) {
        ++row; col = width - 1;
        step = -1;
    }
}

function solution(n, w, x) {
    row = col = 0;
    step = 1;
    width = w;
    let a = Array.from({ length: Math.ceil(n / w) }, () => Array(w).fill(0));
    let i = 1;
    while (i < x) {
        a[row][col] = i++;
        next();
    }
    let col_x = col, answer = 0;
    while (i <= n) {
        if (col == col_x) ++answer;
        a[row][col] = i++;
        next();
    }
    return answer;
}

console.log(solution(22, 6, 8));
console.log(solution(13, 3, 6));
