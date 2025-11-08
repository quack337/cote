A=(require('fs').readFileSync(0)+'').split('\n');
[R,C]=A.shift().split(' ').map(e=>+e);
M=Array(R).fill().map(_=>Array(C));
BT=(r,c)=>{
 if(r<0||r>=R||c<0||c>=C)return 1;
 if(M[r][c]!=undefined)return M[r][c];
 if(V[r][c])return M[r][c]=0;
 V[r][c]=1;
 let x=0,y=0,h=A[r][c];
 if(h=='U')y=-1;else if(h=='D')y=1;else if(h=='L')x=-1;else x=1;
 return M[r][c]=BT(r+y,c+x);
}
X=0;
V=Array(R).fill().map(_=>Array(C));
for(let r=0;r<R;++r)
for(let c=0;c<C;++c)X+=BT(r,c);
console.log(X)