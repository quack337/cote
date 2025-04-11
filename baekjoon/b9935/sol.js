function solution(S, bomb) {
  let builder = [],  stack = [];
  let matchCount = 0;
  for (let c of S) {
    if (c === bomb[matchCount]) {
      matchCount++;
      if (matchCount === bomb.length)
        matchCount = stack.length > 0 ? stack.pop() : 0;
    } else {
      if (c === bomb[0]) {
        stack.push(matchCount);
        matchCount = 1;
      } else {
        append(builder, stack, matchCount, bomb);
        stack = []
        matchCount = 0;
        builder.push(c);
      }
    }
  }
  append(builder, stack, matchCount, bomb);
  stack = []
  return builder.join('');
}

function append(builder, stack, matchCount, bomb) {
  for (let i = 0; i < stack.length; ++i)
    builder.push(bomb.slice(0, stack[i]));
  builder.push(bomb.slice(0, matchCount));
}

const fs = require('fs');
const input = fs.readFileSync(0).toString().split(/[\n\r ]+/);
const S = input[0];
const bomb = input[1];
const result = solution(S, bomb);
console.log(result.length > 0 ? result : 'FRULA');
