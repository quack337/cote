let N=+(require('fs').readFileSync(0)+'');
let S=Array(N),C=Array(N);
console.log(SK(N)?'SK':'CY');

function SK(n) {
  if (n<=0||n==1||n==3||n==4) return 1;
  if (S[n]!=undefined) return S[n];
  return S[n]=CY(n-1)||CY(n-3)||CY(n-4);
}

function CY(n) {
  if (n<=0||n==1||n==3||n==4) return 0;
  if (C[n]!=undefined) return C[n];
  return C[n]=SK(n-1)&&SK(n-3)&&SK(n-4);
}