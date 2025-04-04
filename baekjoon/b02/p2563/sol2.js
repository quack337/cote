let fs = require('fs')
let input = fs.readFileSync(0).toString().split(/[ \n]+/)
let index = 0
let A = new Array(100).fill([]).map(_ => Array(100).fill(0))
let N = parseInt(input[index++])
for (let i = 0; i < N; ++i) {
  let x = Number(input[index++]), y = Number(input[index++])
  for (let dx = 0; dx < 10; ++dx)
    A[x + dx].fill(1, y, y + 10)
}
console.log(A.reduce((ac, row) => row.reduce((ac, e) => ac + e, ac), 0))