A='A*(B+C*(D/E))-C'.split('');
B=parse1(A.slice(0).reverse());
C=parse2(B);
console.log(str(B));
console.log(str(C));

function parse1(A) {
  let B=[];
  while(A.length){
    let c=A.pop();
    switch(c){
      case '(': B.push(parse1(A)); break;
      case ')': return B;
      default: B.push(c); break;
    }
  }
  return B;
}

function parse2(A) {
  if(typeof A != 'object') return A;
  if(A.length==3) return A;
  let B=[];
  for(let i=0; i<A.length; ++i){
    let e = A[i];
    if (typeof e=='object') B.push(parse2(e));
    else if(e=='*' || e=='/') B.push([B.pop(), e, parse2(A[++i])]);
    else B.push(e);
  }
  return B;
}

function str(A) {
  if(typeof A == 'string') return A;
  return '('+A.map(a=>str(a)).join(' ')+')';
}