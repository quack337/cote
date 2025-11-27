A=(require('fs').readFileSync(0)+'').split('');
console.log(parse(A));

function parse(A) {
  return str(parse2(parse1(A.slice(0).reverse())));
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

function parse1(A) {
  let B=[];
  while(A.length){
    let c=A.pop();
    if(c=='(') B.push(parse1(A));
    else if(c==')') return B;
    else B.push(c);
  }
  return B;
}

function str(A) {
  if(typeof A == 'string') return A;
  return '('+A.map(a=>str(a)).join('')+')';
}