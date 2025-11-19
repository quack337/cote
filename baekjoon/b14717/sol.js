[a,b]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
A=[];
for(let i=1;i<=10;++i){if(i!=a)A.push(i);if(i!=b)A.push(i);}
F=(a,b)=>a==b?100+a:(a+b)%10;
v=F(a,b);
N=0;W=0;S=[];
BT=fr=>{
 if(S.length==2){++N;if(v>F(...S))++W; return;}
 for(let i=fr;i<A.length;++i){S.push(A[i]); BT(i+1); S.pop();}
}
BT(0);
X=W/N;
console.log(X.toFixed(3))
