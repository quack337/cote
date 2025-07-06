let fs = require('fs');

const nCr = [[0,1],[0,2],[0,3],[0,4],[0,5],[1,2],[1,3],[1,4],[1,5],
 [2,3],[2,4],[2,5],[3,4],[3,5],[4,5]];

exports.generate1 = function(fname) {
  let result = [], txt = [];
  for (let t = 0; t < 4; ++t) {
    let A = Array(18).fill(0);
    let T = [];
    for (let [a, b] of nCr) {
      let g = Math.floor(Math.random() * 3);
      switch (g) {
      case 0: A[a*3 + 0]++; A[b*3 + 2]++; break;
      case 1: A[a*3 + 1]++; A[b*3 + 1]++; break;
      case 2: A[a*3 + 2]++; A[b*3 + 0]++; break;
      }
      T.push([a, b, '승무패'.charAt(g)]);
    }
    result[t] = A;
    txt[t] = T;
  }
  let data = result.map(e => e.join(' ')).join('\n');
  fs.writeFileSync(fname, data);

  let text = txt.map(e => e.join(', ')).join('\n');
  fs.writeFileSync(fname + '.txt', text);
}

function bug(A) {
  for (;;) {
    let i = Math.floor(Math.random() * i.length);
    let j = Math.floor(Math.random() * i.length);
    if (i != j) {
      A[i] = A[j];
      return;
    }
  }
}

exports.generate2 = function(fname) {
  let result = [], txt = [];
  for (let t = 0; t < 4; ++t) {
    let A = Array(18).fill(0);
    let T = [];
    let nCr_bug = bug(nCr);
    for (let [a, b] of nCr_bug) {
      let g = Math.floor(Math.random() * 3);
      switch (g) {
      case 0: A[a*3 + 0]++; A[b*3 + 2]++; break;
      case 1: A[a*3 + 1]++; A[b*3 + 1]++; break;
      case 2: A[a*3 + 2]++; A[b*3 + 0]++; break;
      }
      T.push([a, b, '승무패'.charAt(g)]);
    }
    result[t] = A;
    txt[t] = T;
  }
  let data = result.map(e => e.join(' ')).join('\n');
  fs.writeFileSync(fname, data);

  let text = txt.map(e => e.join(', ')).join('\n');
  fs.writeFileSync(fname + '.txt', text);
}
