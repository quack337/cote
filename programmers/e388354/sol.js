const 정홀짝 = 0, 역홀짝 = 1;

function dfs(node, nodeValues, neighbors, visited, count) {
    if (visited[node]) return;
    visited[node] = true;
    if (nodeValues[node] % 2 === neighbors[node].length % 2)
        count[정홀짝]++;
    else
        count[역홀짝]++;
    for (let neighbor of neighbors[node])
        dfs(neighbor, nodeValues, neighbors, visited, count);
}

function solution(nodeValues, edges) {
    let nodeIndex = new Map();
    for (let i = 0; i < nodeValues.length; ++i)
        nodeIndex.set(nodeValues[i], i);
    let neighbors = Array.from({ length: nodeValues.length }, () => []);
    for (let edge of edges) {
        let a = nodeIndex.get(edge[0]), b = nodeIndex.get(edge[1]);
        neighbors[a].push(b);
        neighbors[b].push(a);
    }
    let answer = [0, 0];
    let visited = Array(nodeValues.length).fill(false);
    for (let node = 0; node < nodeValues.length; ++node)
        if (!visited[node]) {
            let count = [0, 0];
            dfs(node, nodeValues, neighbors, visited, count);
            if (count[정홀짝] === 1) answer[0]++;
            if (count[역홀짝] === 1) answer[1]++;
        }
    return answer;
}

let nodeValues = [11, 9, 3, 2, 4, 6];
let edges = [[9, 11], [2, 3], [6, 3], [3, 4]];
let answer = solution(nodeValues, edges);
console.log(answer[0], answer[1]);

nodeValues = [9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10];
edges = [[5, 14], [1, 4], [9, 11], [2, 15], [2, 5], [9, 7], [8, 1], [6, 4]];
answer = solution(nodeValues, edges);
console.log(answer[0], answer[1]);
