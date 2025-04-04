const fs = require('fs');
const input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
const A = [];
for (let i = 0; i < N; ++i)
    A[i] = i + 1;
for (let i = 0; i < M; ++i) {
    let from = input[index++] - 1;
    let to = input[index++] - 1;
    // from ~ to 영역 뒤집기
    while (from < to) {
        [A[from], A[to]] = [A[to], A[from]];
        ++from; --to;
    }
}
console.log(A.join(' '))
