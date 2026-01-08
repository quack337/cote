S='(--R+(P*Q))';
I=0;

function FO(){
  let c=S[I++];
  if(c=='0'||c=='1'||c=='2')return['N',+c];
  if(c=='P'||c=='Q'||c=='R')return['V',c];
  if(c=='-')return['-',FO()];
  if(c=='('){
    let fo1=FO(),op=OP(),fo2=FO();
    if(S[I++]!=')'){console.log('error');process.exit(0)}
    return[op,fo1,fo2]}
}