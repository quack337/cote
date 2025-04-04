function findGroup(heights, HeightLimit, r, c, prevHeight, noMap, no) {
  if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) return;
  if (noMap[r][c] != -1) return;
  if (Math.abs(heights[r][c] - prevHeight) > HeightLimit) return;
  noMap[r][c] = no;
  findGroup(heights, HeightLimit, r - 1, c, heights[r][c], noMap, no);
  findGroup(heights, HeightLimit, r + 1, c, heights[r][c], noMap, no);
  findGroup(heights, HeightLimit, r, c - 1, heights[r][c], noMap, no);
  findGroup(heights, HeightLimit, r, c + 1, heights[r][c], noMap, no);
}

function findLink(heights, noMap, r, c, prevNo, prevHeight, links, visited) {
  if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) return;
  let no = noMap[r][c];
  if (no !== prevNo) {
    let cost = Math.abs(heights[r][c] - prevHeight);
    if (links[prevNo][no] > cost)
      links[prevNo][no] = cost;
  }
  if (visited[r][c]) return;
  visited[r][c] = true;
  findLink(heights, noMap, r - 1, c, no, heights[r][c], links, visited);
  findLink(heights, noMap, r + 1, c, no, heights[r][c], links, visited);
  findLink(heights, noMap, r, c - 1, no, heights[r][c], links, visited);
  findLink(heights, noMap, r, c + 1, no, heights[r][c], links, visited);
}

function solution(land, height) {
  var noMap = Array.from(Array(land.length), () => Array(land.length).fill(-1));
  var no = 0;
  for (var a = 0; a < land.length; a++)
    for (var b = 0; b < land.length; b++)
      if (noMap[a][b] === -1) {
        findGroup(land, height, a, b, land[a][b], noMap, no);
        no++;
      }
  console.log(noMap);
  let minCost = Array.from(Array(no), () => Array(no).fill(Infinity));
  var visited = Array.from(Array(land.length), () => Array(land.length).fill(false));
  findLink(land, noMap, 0, 0, noMap[0][0], land[0][0], minCost, visited);
  let max = 0, sum = 0, count = 0;
  for (var a = 0; a < no; a++)
    for (var b = 0; b < no; b++) {
      if (minCost[a][b] === Infinity) continue;
      count++;
      max = Math.max(max, minCost[a][b]);
      sum += minCost[a][b];
    }
  console.log(minCost, max, sum, count);
}

// Test case
//console.log(solution([[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]], 3)); // 15
console.log(solution([[1, 2, 11, 12], [3, 42, 43, 13], [21, 41, 44, 33], [22, 23, 31, 32]], 5));