function 최대공약수(a, b) {
  while (b !== 0) {
    let t = a % b;
    a = b;
    b = t;
  }
  return a;
}

function 최소공배수(a, b) {
  return (a * b) / 최대공약수(a, b);
}

function 최소공배수_배열(a) {
  let result = a[0];
  for (let i = 1; i < a.length; ++i)
      result = 최소공배수(result, a[i]);
  return result;
}

console.log(최소공배수_배열([2, 3]));  // 6
console.log(최소공배수_배열([3, 4, 5])); // 60
console.log(최소공배수_배열([4, 5, 6, 7])); // 420
