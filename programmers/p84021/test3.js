function getBoundingRect(table, r, c, visited) {
  let stack = [[r, c]], r1=99, c1=99, r2=0, c2=0;
  while (stack.length > 0) {
    [r, c] = stack.pop();
    if (table[r][c] != 1) continue;
    if (visited[r][c]) continue;
    visited[r][c] = true;
    if (r < r1) r1 = r; if (r > r2) r2 = r;
    if (c < c1) c1 = c; if (c > c2) c2 = c;
    if (r > 0) stack.push([r-1, c]);
    if (c > 0) stack.push([r, c-1]);
    if (r < table.length-1) stack.push([r+1, c]);
    if (c < table[0].length-1) stack.push([r, c+1]);
  }
  return [r1, c1, r2, c2];
}

function getUnit(table, boundingRect) {
  let [r1, c1, r2, c2] = boundingRect;
  let unit = Array(r2-r1+1).fill().map(() => Array(c2-c1+1));
  for (let r = r1; r <= r2; ++r)
    for (let c = c1; c <= c2; ++c)
      unit[r-r1][c-c1] = table[r][c];
  return unit;
}

function findUnit(table) {
  let visited = Array(table.length).fill().map(() => Array(table[0].length));
  for (let r = 0; r < table.length; ++r)
    for (let c = 0; c < table[0].length; ++c)
      if (table[r][c] == 1 && !visited[r][c]) {
        let boundingRect = getBoundingRect(table, r, c, visited);
        let unit = getUnit(table, boundingRect);
        print(unit);
      }
}

function print(a) {
  for (let r = 0; r < a.length; ++r)
    console.log(a[r]);
  console.log()
}

let table = [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]
findUnit(table);