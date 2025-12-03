N=(require('fs').readFileSync(0)+'');
L=[3];
F1=_=>{
 if(N<=L[0])return F2(0);
 for(let i=1;;++i){
  L[i]=L[i-1]*2+i+3;
  if(N<=L[i]) return F2(i);
 }}
F2=i=>{
  if(N<=3)return "moo"[N-1];
  if(N<=L[i-1])return F2(i-1);
  if(N-L[i-1]==1)return 'm';
  if(N-(L[i-1]+i+3)<=0)return 'o';
  N -= L[i-1]+i+3;
  return F2(i-1)
}
console.log(F1())