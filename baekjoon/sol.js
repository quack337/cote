let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let A = [];
for (let i = 0; i < N; ++i)
  A[i] = parseInt(input[index++]);



