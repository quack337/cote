P=[,9,9];Q=[,10,10]; //0불가,0가능
for(let i=3;;++i){
  P[i]=9*Q[i-2];
  Q[i]=10*Q[i-2];
  if(P[i]>1e16)break;
}
console.log(P);
console.log(P.length);
