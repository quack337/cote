function parse(s) {
  let stack = [];
  let 곱 = 1;   // 중첩된 괄호에 의해 곱해져야 할 값
  let 결과 = 0; // 계산 결과 값
  let 직전문자 = 'x';
  for (let ch of s) {
    switch (ch) {
      case '(':
        stack.push('(');
        곱 *= 2; // 중첩된 괄호에 의해 곱해져야 할 값 누적
        break;
      case '[':
        stack.push('[');
        곱 *= 3; // 중첩된 괄호에 의해 곱해져야 할 값 누적
        break;
      case ')':
        if (stack.length == 0 || stack.pop() != '(') return 0;
        if (직전문자 == '(') 결과 += 곱;
        곱 /= 2; // 괄호가 한 개 닫혔으므로, 곱해져야할 값도 줄어든다
        break;
      case ']':
        if (stack.length == 0 || stack.pop() != '[') return 0;
        if (직전문자 == '[') 결과 += 곱;
        곱 /= 3; // 괄호가 한 개 닫혔으므로, 곱해져야할 값도 줄어든다
        break;
    }
    직전문자 = ch;
  }
  return stack.length == 0 ? 결과 : 0;
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split('\n');
let s = input[0].split('');
console.log(parse(s));
