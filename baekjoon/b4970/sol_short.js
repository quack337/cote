D=(require('fs').readFileSync(0)+'').split('\n');X=[];
f1=_=>{
 let c=s[I++];
 if(c>='0'&&c<='2')return['N',+c];
 if(c>='P'&&c<='R')return['V',c];
 if(c=='-')return['-',f1()];
 if(c=='('){
  let a=f1(),p=s[I++],b=f1();I++;
  return[p,a,b]}}
f2=([t,a,b])=>{
 if(t=='N')return a;  
 if(t=='V')return a=='P'?p:a=='Q'?q:r;
 if(t=='-')return 2-f2(a);
 let x=f2(a),y=f2(b);
 return t=='+'?Math.max(x,y):Math.min(x,y)}
A=[0,1,2];
for(s of D){
 if(s==".")break;
 I=0;C=0;fo=f1();
 for(p of A)for(q of A)for(r of A)
 if(f2(fo)==2)++C;
 X.push(C)}
console.log(X.join('\n'))