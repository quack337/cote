A='A*(B+C*(D/E))-C'.split('');
B=parse1(A.slice(0).reverse());
//C=parse2(B);
console.log(B);
//console.log(C);
//console.dir(C, { depth: null, colors: true, maxArrayLength: null });

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
  let B=[];
  for(let i=0; i<A.length; ++i){
    let e = A[i];
    console.log(typeof e, e);
    if (typeof e=='object')
      B.push(parse2(e));
    else if(e=='*' || e=='/')
      B.push([B.pop(), e, A[++i]]);
    else
      B.push(e);
  }
  return B;
}