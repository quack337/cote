// 답!
let D = require('fs').readFileSync(0).toString().split('\n'),
 N= +D[0], C= D[1].split(' ').map(e=>+e),
 t= D.slice(2).map(e=>e.split(' ').map(e=>+e)),
 A= t.map(e=>e.slice(0,4)), B=t.map(e=>e[4]), P=Infinity, Q;
DFS()
console.log(Q ? P+'\n' + Q.map(e => e+1).join(' ') : '-1\n')

function DFS() {
  let stack = [[0,[],0]]
  while (stack.length > 0) {
    let [n,S,p] = stack.pop()
    if (n==N) {
      let B = S.reduce((r,s)=> A[s].map((a,i)=> a+r[i]), [0,0,0,0])
      if (B.every((e,i)=> e >=C[i]))
        if (p < P) { P=p; Q=S; }
        else if (S.every((e,i)=> e<=Q[i]) && S.length<=Q.length) Q=S;
    } else {
      stack.push([n+1, S, p])
      if (p+B[n] <= P) stack.push([n+1, [...S, n], p+B[n]])
    }
  }
}
