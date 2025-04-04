function parse(s) {
  let stack = [];
  for (let ch of s) {
    switch (ch) {
      case '(': stack.push('('); break;
      case '[': stack.push('['); break;
      case ')':
        if (stack.length == 0 || stack.pop() != '(') return 0;
        break;
      case ']':
        if (stack.length == 0 || stack.pop() != '[') return 0;
        break;
    }
  }
  return stack.length == 0 ? 1 : 0;
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split('\n');
let s = input[0].split('');
console.log(parse(s));
