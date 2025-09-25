let N=+require('fs').readFileSync(0).toString();
let MS=[], MC=[];
console.log(SK(N) ? "SK" : "CY");

function SK(n) {
  if (n==1) return false;
  if (MS[n]!=undefined) return MS[n];
  return MS[n] = CY(n-1) || (n>3 ? CY(n-3) : false);
}

function CY(n) {
  if (n==1) return true;
  if (MC[n]!=undefined) return MC[n];
  return MC[n] = SK(n-1) && (n>3 ? SK(n-3) : true);
}