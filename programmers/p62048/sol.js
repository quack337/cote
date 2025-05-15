function GCD(a, b) {
  while (b != 0) {
    let t = a % b;
    a = b;
    b = t;
  }
  return a;
}

function solution(w, h) {
  return w * h - (w + h - GCD(w, h));
}

console.log(solution(8, 12));