let [T,...D]=(require('fs').readFileSync(0)+'').split('\n')
OUT=[]
for (let t=0; t<T; ++t) {
  A=D[t].split('')
  N=A.length
  set1=new Set()
  set2=new Set()
  if (numbers()) { OUT.push('Hello, BOJ 2023!'); continue }
  S=[]
  BT(1)
  OUT.push(set2.size)
}
console.log(OUT.join('\n'))

function numbers() {
  let B=A.map(e=>+e), C=B.slice(), n=B.length, p
  for (;;) {
    let x=0
    for (let i=0; i<n; ++i) x+=B[i]
    if (x==p) return 1
    if (x>1_000_000_000) return 0
    set1.add(p=x)
    for (let i=0; i<n; ++i) B[i]*=C[i]
  }
}

function BT(n) {
  if (n>=N) {
    let X=[], a=0
    for (let i=0; i<S.length; ++i) {
      while (a<S[i]) X.push(A[a++])
      X.push('+')
    }
    while (a<A.length) X.push(A[a++])
    let x=eval(X.join(''))
    if (set1.has(x)) set2.add(x)
    return
  }
  S.push(n); BT(n+1); S.pop(); BT(n+1)
}