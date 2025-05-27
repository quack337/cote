function solution(tickets) {
  let linksMap = new Map();
  for (let i = 0; i < tickets.length; ++i) {
    let airport1 = tickets[i][0], airport2 = tickets[i][1];
    if (!linksMap.has(airport1))
      linksMap.set(airport1, []);
    linksMap.get(airport1).push([airport2, false]);
  }
  for (let links of linksMap.values())
    links.sort((a, b) => a[0].localeCompare(b[0]));
  let path = ["ICN"]
  DFS("ICN");
  return path;
  
  function DFS(airport1) {
    console.log(path);
    if (path.length == tickets.length + 1) 
      return true;
    if (!linksMap.has(airport1)) 
      return false;
    for (let link of linksMap.get(airport1)) {
      let [airport2, used] = link;
      if (used) continue;
      link[1] = true;
      path.push(airport2);
      if (DFS(airport2, path)) return true;
      path.pop();
      link[1] = false;
    }
    return false;
  }
}

console.log(solution([["ICN","JFK"],["HND","IAD"],["JFK","HND"]]));
console.log(solution([["ICN","SFO"],["ICN","ATL"],["SFO","ATL"],["ATL","ICN"],["ATL","SFO"]]));
console.log(solution([["ICN","AAA"],["AAA","BBB"]]));
console.log(solution([["ICN","BBB"],["BBB","AAA"]]));
console.log(solution([["BBB","AAA"],["ICN","BBB"]]));
console.log(solution([["ICN","BBB"],["BBB","ICN"],["ICN","AAA"]]));
console.log(solution([["ICN","AAA"],["ICN","BBB"],["ICN","CCC"],["CCC","ICN"],["BBB","ICN"]]));
console.log(solution([["ICN","AAA"],["ICN","BBB"],["BBB","ICN"],["AAA","ICN"]]));