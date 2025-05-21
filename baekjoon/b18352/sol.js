let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let M = parseInt(input[index++]);
let K = parseInt(input[index++]);
let X = parseInt(input[index++]);
let links = Array(N).fill(null).map(() => []);
for (let i = 0; i < N; ++i) {
  let a = parseInt(input[index++]);
  let b = parseInt(input[index++]);
  links[a].push([b]);
}

function



