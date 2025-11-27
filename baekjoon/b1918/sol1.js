A=(require('fs').readFileSync(0)+'').split('').reverse();
i=0;

function expr() {
  let a=A[i++];
  if(a=='(') return expr();
  else if(alpha(a)) {
    if(i==A.length || A[i]==')') return a;
    let op=A[i++], b=expr();
  }
  else if(e==')') return
  if(e == '(') {let t=expr(); pop()
}

function alpha(e) {
  return typeof e=='string' && 'A'<=e && e<='Z';
}