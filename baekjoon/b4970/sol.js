D=(require('fs').readFileSync(0)+'').split('\n');X=[];
f1=_=>{
  let c=s[I++];
  if(c=='0'||c=='1'||c=='2')return['N',+c];
  if(c=='P'||c=='Q'||c=='R')return['V',c];
  if(c=='-')return['-',f1()];
  if(c=='('){
    let a=f1(),op=s[I++],b=f1();I++;
    return[op,a,b]}}
f2=fo=>{
  let [t,a,b]=fo;
  if(t=='N')return a;
  if(t=='V')return a=='P'?p:a=='Q'?q:r;
  if(t=='-')return 2-f2(a);
  if(t=='+'||t=='*'){
    let x=f2(a),y=f2(b);
    return t=='+'?Math.max(x,y):Math.min(x,y)}}
for(s of D) {
  if(s==".")break;
  I=0;cnt=0;
  fo=f1();
  for(p=0;p<=2;++p)
  for(q=0;q<=2;++q)
  for(r=0;r<=2;++r)if(f2(fo)==2)++cnt;
  X.push(cnt)}
console.log(X.join('\n'))