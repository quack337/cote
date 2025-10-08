[N,K]=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
M=[[1],[1,1],[1,2]];
M[N]=[];
for(let r=3;r<=N;++r){
 M[r]=Array(r+1).fill(0);
 M[r][0]=1;
 let e=r/2|0;
 for(let c=1;c<=e;++c)
   M[r][c]=(M[r-1][c]+M[r-2][c-1])%1000000003;
}
console.log(M[N][K]);