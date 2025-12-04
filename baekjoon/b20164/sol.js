S=(require('fs').readFileSync(0)+'').trim();
F=s=>{
 let c,d,C=99,D=0,N=s.length,x=s.split('').reduce((a,e)=>e%2?a+1:a,0);
 if(N==1) return[x,x];
 if(N==2){[c,d]=F(+s[0]+s[1]*1+'');return [c+x,d+x]}
 for(let i=1;i<N-1;++i)
 for(let j=i+1;j<N;++j){
  [c,d]=F(+s.slice(0,i)+s.slice(i,j)*1+s.slice(j)*1+'');
  if(c<C)C=c;if(d>D)D=d}
 return [C+x,D+x];
}
console.log(F(S).join(' '))