S=(require('fs').readFileSync(0)+'').trim();
X=[];V=[];
F2=n=>{V[n]=1;X.push(V.map((v,i)=>v?S[i]:'').join(''))}
F1=(n,c)=>{
  if(!V[n]&&S[n]==c)F2();
  F1(n+1,c);
}
for(let i=65;i<91;++i){
 for(let j=0;j<S.length;++j)
  if(S.charCodeAt(j)<=i)A.push(S[j]);
 if(A.length>P.length)X.push(P=A.join(''));
}
console.log(X.join('\n'))