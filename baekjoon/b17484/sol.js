A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[R,C]=A.shift();
BT=(r,c,p)=>{
 if(r==R-1)return A[r][c];
 if(M[r][c][p]!=undefined)return M[r][c][p];
 let x=Infinity;
 if(p&&c)x=Math.min(x,BT(r+1,c-1,0));
 if(p!=1)x=Math.min(x,BT(r+1,c,1));
 if(p!=2&&c<C-1)x=Math.min(x,BT(r+1,c+1,2));
 return M[r][c][p]=x+A[r][c];
}
M=Array(R).fill().map(e=>Array(C).fill().map(e=>[]));
x=BT(0,0,3);
for(let c=1;c<C;++c)x=Math.min(x,BT(0,c,3));
console.log(x);