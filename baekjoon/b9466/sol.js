let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
let T = getInt();
for (let t = 0; t < T; ++t) {
  let N = getInt();
  let A = [], count = [];
  for (let i = 0; i < N; ++i) {
    A[i] = getInt() - 1;
    count[A[i]]++;
  }
  const 제거됨 = -1, answer = 0;
  for (let i = 0; i < N; ++i) {
    if (count[i] == 0) {
      let node = i;
      while (count[node] == 0) {
        ++answer;
        count[node] = 제거됨;
        let node = A[i];
        count[node]--;
      }
    }
  }
  console.log(N - answer);
}
