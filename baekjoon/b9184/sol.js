let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let M=Array(21).fill().map(_=>Array(21).fill().map(_=>Array(21).fill(null)));
let X=[];
for (let i=0;;) {
  let [a,b,c] = A[i++];
  if (a==b && b==c && c==-1) break;
  X.push('w('+a+', '+b+', '+c+') = ' + w(a,b,c));
}
console.log(X.join('\n'));

function w(a,b,c) {
  if (a<=0 || b<=0 || c<=0) return 1;
  if (a>20 || b>20 || c>20) return w(20, 20, 20);
  if (M[a][b][c]!=null) return M[a][b][c];
  if (a<b && b<c)
    return M[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
  return M[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
}
