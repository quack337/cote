let fs = require('fs');
let input = fs.readFileSync(0).toString().split('\n');
let N = parseInt(input[0]);
for (let i = 0; i < N; ++i)
  console.log(/^((100+1+)|(01))+$/.test(input[i + 1]) ? "YES" : "NO");

