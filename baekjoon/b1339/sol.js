let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let words = [];
for (let i = 0; i < N; ++i)
  words[i] = input[index++];

let set = new Set();
for (let word of words)
  for (let ch of word)
    set.add(ch);
let alphabets = [...set];
let nPr_result = nPr(alphabets, alphabets.length);

let max = 0;
for (let sequence of nPr_result) {
  let sum = 0;
  for (let word of words) {
    for (let i = 0; i < sequence.length; ++i)
      word = word.replaceAll(sequence[i], 9 - i);
    sum += Number(word);
  }
  if (sum > max) max = sum;
}
console.log(max);

function nPr(list, r) {
  let result = [], selected = [];
  DFS();
  return result;

  function DFS() {
    if (selected.length == r) {
      result.push(selected.join(''));
      return;
    }
    for (let ch of list)
      if (!selected.includes(ch)) {
        selected.push(ch);
        DFS();
        selected.pop();
      }
  }
}
