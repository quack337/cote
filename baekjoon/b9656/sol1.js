let N=+require('fs').readFileSync(0).toString();
console.log(SK(N) ? "SK" : "CY");

function SK(n) {
  if (n==1) return false;
  return CY(n-1) || (n>3 ? CY(n-3) : false);
}

function CY(n) {
  if (n==1) return true;
  return SK(n-1) && (n>3 ? SK(n-3) : true);
}