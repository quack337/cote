//D=(require('fs').readFileSync(0)+'').split('\n').map(e=>e.trim());
//N=+D.shift();
F=_=>{
 let s=0;
 for(;;){
  switch(s){
  case 0: if(S[n]=='D'||S[n]=='E'){++n;s=1} else return 0; break;
  case 1: if(S[n]=='F'){++n;s=2} else return 0; break;
  case 2:
    switch(S[n]){
    case 'F': ++n; break;
    case 'D': case 'E': ++n; s=1; break;
    case 'G': return ++n;
    default: return 0}}}}

P=_=>{
 let s=0;
 for(;;){
//  console.log(S,s,n);
  if(n>=S.length)return 0;
  let t;
  switch(s){
  case 0: if(S[n]=='A'){++n;s=1} else return 0; break;
  case 1:
    if(S[n]=='H') return ++n;
    if(S[n]=='B'){++n;s=3;break}
    t=n;
    if(F()){s=2;break}
    n=t;return 0
  case 2: return S[n]=='C'?++n:0;
  case 3:
    t=n;
    if(P()){s=2;break}
    n=t; return 0}}}
A=['DFG', 'EFG', 'DFFFFFG', 'DFDFDFDFG', 'DFEFFFFFG', 'DFEFF', 'EFAHG', 'DEFG', 'DG', 'EFFFFDG'];
A=['AH','ABAHC', 'ABABAHCC', 'ADFGC', 'ADFFFFGC', 'ABAEFGCC', 'ADFDFGC', 'ABC', 'ABAH', 'DFGC', 'ABABAHC', 'SLIMP', 'ADGC'];
A=['AHDFG', 'ADFGCDFFFFFG', 'ABAEFGCCDFEFFFFFG', 'AHDFGA', 'DFGAH', 'ABABCC'];
for(S of A){
  n=0;
  console.log(S, P() && F() && n==S.length)
}