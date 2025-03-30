const fs = require('fs');
const input = fs.readFileSync(0).toString().trim().split('\n');
const N = parseInt(input[0]);
const A = input[1].split(' ').map(Number);
const stack = [];
const result = new Array(N);

for (let i = N - 1; i >= 0; i--) {
  while (stack.length > 0 && stack[stack.length - 1] <= A[i])
    stack.pop();
  result[i] = stack.length === 0 ? -1 : stack[stack.length - 1];
  stack.push(A[i]);
}
console.log(result.join(' '));
