let [A,B]=(require('fs').readFileSync(0)+'').split('\n');
let AL=A.length, BL=B.length
let P1 = Array(AL+1).fill().map(e=>Array(BL+1).fill(0));
let P2 = Array(AL+1).fill().map(e=>Array(BL+1).fill(0));

for (let i=AL-1; i>=0; --i)
  for (let j=BL-1; j>=0; --j) {
    P1[i][j] = A[i]==B[j] ? P1[i+1][j+1]+1 : 0;
    P2[i][j] = Math.max(P2[i][j+1], P2[i+1][j], A[i]==B[j] ? P1[i][j] : 0);
  }
console.log(P2[0][0]);
