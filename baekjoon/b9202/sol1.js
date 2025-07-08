// 입력 확인
let D = require('fs').readFileSync(0).toString().split(/[\n\r]+/),
  WN = +D[0], WA = D.slice(1,WN+1), BN = +D[WN+1], BA = [];
for (let i=0; i<BN; ++i)
  BA[i] = D.slice(WN+2+i*4, WN+6+i*4).map(e=>e.split(''));
console.log(WN, WA);
console.log(BA);