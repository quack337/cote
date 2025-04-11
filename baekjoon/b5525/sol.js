const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');
const N = parseInt(input[0]);
const M = parseInt(input[1]);
const S = input[2];
let state = 0, length = 0, answer = 0;
const automata = [[2, 4, 2, 4, 2], [1, 1, 1, 1, 3]];

for (let i = 0; i < S.length; ++i) {
  const ch = (S[i] === 'O' ? 0 : 1);
  const nextState = automata[ch][state];
  if (state === 1 && nextState === 4) length = 0; // Ia -> Ob
  else if (state === 4 && nextState === 3) { // Ob -> Ib
    ++length;
    if (length >= N) ++answer;
  }
  state = nextState;
}
console.log(answer);
