function code(ch) { return ch.charCodeAt(0) }

function create(n) {
  return Array(n).fill().map((_,i)=>String.fromCharCode('a'.charCodeAt(0)+i))
}

function one(A) {
  let B=[]
  for (let i=0; i<A.length-1; ++i)
    B[i] = A[i] + A[i+1]
  return B
}

function two(A) {
  while (A.length > 1)
    A = one(A)
  return A
}

function three(n) {
  let A = create(n), C=Array(n).fill(0)
  //console.log(two(A)[0])
  two(A)[0].split('').forEach(c=>C[code(c)-code('a')]++)
  return C
}

for (let i=1; i<=10; ++i)
 console.log(i+ ': ' + three(i))
