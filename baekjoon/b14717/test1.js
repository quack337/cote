A=[];
for(let i=2;i<=10;++i){
  A.push(i);A.push(i);
}
X=[],S=[];
BT(0);
console.log(X.length);
console.log(X.join(' '));

function BT(from){
  if (S.length==2) {
    X.push(S.slice());
    return;
  }
  for(let i=from;i<A.length;++i){
    S.push(A[i]);
    BT(i+1);
    S.pop();
  }
}