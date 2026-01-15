D=(require('fs').readFileSync(0)+'').split('\n');
A=D[1].split(' ');S=D[2];C=Array(26).fill(0);
I=c=>c.charCodeAt(0)-97;
for(i=0;i<A.length;)C[I(A[i++])]=+A[i++];
N=C.reduce((a,b)=>a+b);
for(i=0;i<S.length;++i){
 C[I(S[i])]--;
 if(i>=N)C[I(S[i-N])]++;
 if(C.every(e=>!e)) console.log(S.slice(i-N+1,i+1));
}
