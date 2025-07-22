let A=(require('fs').readFileSync(0)+'').split(/[ \n]+/).map(e=>+e),T=A[0]
let M1=[1,0],M2=[0,1]
for (let i=2; i<=40; ++i) {
  M1[i]=M1[i-1]+M1[i-2]
  M2[i]=M2[i-1]+M2[i-2]
}
let OUT=[]
for (let t=1; t<=T; ++t) {
  let n = A[t]
  OUT.push(M1[n]+' '+M2[n])
}
console.log(OUT.join('\n'))