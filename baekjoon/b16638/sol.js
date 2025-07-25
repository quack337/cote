let A=require('fs').readFileSync(0).toString().split('\n')[1].trim().split('')
 .map(e=> (e>='0' && e<='9') ? +e : e), N=A.length, ANS=-Infinity, F=Array(N).fill(0);
DFS(1);
console.log(ANS);

function DFS(n) {
  if (n>=N) {
    ANS = Math.max(ANS, calc(A));
    return;
  }
  if ((n==1 || !F[n-2]) && (n==N-2 || !F[n+2])) { // 좌우 연산자에 괄호가 없어야 함
    F[n] = 1; DFS(n + 2);
  }
  F[n] = 0; DFS(n + 2);
}

function calc(A) {
  let B=[];
  for (let i=0; i < A.length; ++i) {
    let e = A[i];
    switch (e) {
      case '*': if (F[i]) e = B.pop()*A[++i]; break
      case '+': if (F[i]) e = B.pop()+A[++i]; break
      case '-': if (F[i]) e = B.pop()-A[++i]; break
    }
    B.push(e);
  }
  A=B; B=[];
  for (let i=0; i < A.length; ++i) {
    let e = A[i];
    if (e=='*') e = B.pop()*A[++i];
    B.push(e);
  }
  A=B; B=[];
  for (let i=0; i < A.length; ++i) {
    let e = A[i];
    if (e=='+') e = B.pop()+A[++i];
    else if (e=='-') e = B.pop()-A[++i];
    B.push(e);
  }
  return B[0];
}