S='(--R+(P*Q))';I=0;
//S='(-1+(((---P+Q)*(--Q+---R))*(-R+-P)))';I=0;
FO=get();
console.log(JSON.stringify(FO));

function get(){
  let c=S[I++];
  if(c=='0'||c=='1'||c=='2')return['N',+c];
  if(c=='P'||c=='Q'||c=='R')return['V',c];
  if(c=='-')return['-',get()];
  if(c=='('){
    let fo1=get(),op=S[I++],fo2=get();
    if(S[I++]!=')' || (op!='+'&&op!='*')){console.log('error');process.exit(0)}
    return[op,fo1,fo2]}
}
