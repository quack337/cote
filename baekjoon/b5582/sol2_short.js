let[a,b]=(require('fs').readFileSync(0)+'').split('\n')
A=a.length
B=b.length
P=Array(A+1).fill().map(e=>Array(B+1).fill(0))
Q=Array(A+1).fill().map(e=>Array(B+1).fill(0))
for(i=A-1;i>=0;--i)
 for (j=B-1;j>=0;--j){
  P[i][j]=a[i]==b[j]?P[i+1][j+1]+1:0
  Q[i][j]=Math.max(Q[i][j+1],Q[i+1][j],a[i]==b[j]?P[i][j]:0)
 }
console.log(Q[0][0])