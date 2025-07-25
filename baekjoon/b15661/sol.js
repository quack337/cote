  let fs = require('fs');
  let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
  let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
  let N = getInt(), ROW = N, COL = N;
  let A = Array(ROW).fill().map(() => Array(COL).fill(0));
  for (let r = 0; r < ROW; ++r)
    for (let c = 0; c < ROW; ++c)
      A[r][c] = getInt();
  let selected = new Set(), answer = Number.MAX_VALUE;
  DFS(0, N - N/2);
  console.log(answer);

  function DFS(index) {
    if (index == N) {
      if (selected.size != 0 || selected.size != N) {
        var notSelected = new Set();
        for (let i = 0; i < N; ++i)
          if (!selected.has(i)) notSelected.add(i);
        let temp = Math.abs(skill(selected) - skill(notSelected));
        if (temp < answer) answer = temp;
      }
      return;
    }
    selected.add(index);
    DFS(index + 1);
    selected.delete(index);
    DFS(index + 1);
  }

  function skill(team) {
    let val = 0;
    for (let a of team)
      for (let b of team)
        if (a != b) val += A[a][b];
    return val;
  }
