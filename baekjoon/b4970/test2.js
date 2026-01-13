S='(P*Q)';I=0;
//S='(--R+(P*Q))';I=0;
//S='(P*-P)';I=0;
//S='2';I=0;
//S='1';I=0;
//S='(-1+(((---P+Q)*(--Q+---R))*(-R+-P)))';I=0;

fo=get1();
let count = 0;
for(p=0;p<=2;++p)
for(q=0;q<=2;++q)
for(r=0;r<=2;++r)
  if (get2(fo)==2) ++count;
console.log(count);

function get1(){
  let c=S[I++];
  if(c=='0'||c=='1'||c=='2')return['N',+c];
  if(c=='P'||c=='Q'||c=='R')return['V',c];
  if(c=='-')return['-',get1()];
  if(c=='('){
    let fo1=get1(),op=S[I++],fo2=get1();
    if(S[I++]!=')' || (op!='+'&&op!='*')){console.log('error');process.exit(0)}
    return[op,fo1,fo2]}
}

function get2(fo){
  let [t,a,b]=fo;
  if (t=='N') return a;
  if (t=='V') return a=='P'?p : a=='Q'?q : r;
  if (t=='-') return 2 - get2(a);
  if (t=='+' || t=='*') {
    let x=get2(a),y=get2(b);
    return t=='+' ? Math.max(x,y) : Math.min(x,y);
  }
}