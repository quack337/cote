function 정수to주문(value) {
  let result = [], A_CODE = 'a'.charCodeAt(0);
  while (value > 0) {
    let 자릿수 = value % 26;
    result.push(자릿수);
    value = Math.floor(value / 26);
  }
  return result
}

console.log('c');
console.log('ac');
console.log('acd');

