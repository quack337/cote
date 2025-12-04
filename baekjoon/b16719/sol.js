S=(require('fs').readFileSync(0)+'').trim();N=S.length;
X=[];V=[];
F=n=>{for(;;){
 let c='a',j=-1;
 for(let i=n;i<N;++i)if(!V[i]&&S[i]<c)c=S[j=i];
 if(j==-1)return;
 V[j]=1;X.push(V.reduce((a,v,i)=>v?a+S[i]:a,''));if(j<N-1)F(j+1)}}
F(0);
console.log(X.join('\n'))