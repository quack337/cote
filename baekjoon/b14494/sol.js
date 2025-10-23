[R,C]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
M=Array(R).fill().map(e=>Array(C).fill(1));
for(let r=R-2;r>=0;--r)
for(let c=C-2;c>=0;--c)
 M[r][c]=(M[r+1][c]+M[r][c+1]+M[r+1][c+1])%1000000007;
console.log(M[0][0]);