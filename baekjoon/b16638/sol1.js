// 수식 계산

let F=[];
let A='1+2+3*4+5+6-7*8'.split('');
   F[1] = F[7] = F[11] = true;
// (1+2)+3*(4+5)+(6-7)*8

A = A.map(e=> (e>='0' && e<='9') ? +e : e);
console.log(A.join(' '));
console.log(calc(A));

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
  console.log(A.join(' '));
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