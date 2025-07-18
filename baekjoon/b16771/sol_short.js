nums=s=>s.split(' ').map(e=>+e)
BT=(n,A,xa,B,xb)=>{
  if (n==4) {set.add(xa); return}
  let V=[]
  for (let i in A) {
    let s=A[i]
    if (s && !V[s]) {
      A[i]=0; B.push(s); V[s]=1
      BT(n+1,B,xb+s,A,xa-s);
      A[i]=s; B.pop()
    }
  }
}
IN=(require('fs').readFileSync(0)+'').split('\n')
A=nums(IN[0])
B=nums(IN[1])
set=new Set()
BT(0,A,1000,B,1000)
console.log(set.size)
