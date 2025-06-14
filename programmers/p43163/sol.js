function diff(word1, word2) {
  let count = 0;
  for (let i = 0; i < word1.length; ++i)
    if (word1[i] != word2[i])
      ++count;
  return count;
}

function solution(begin, target, words) {
  let queue = [], visited = {};
  queue.push([begin, 0]);
  while (queue.length > 0) {
    let [current, distance] = queue.shift();
    if (current == target) return distance;
    if (visited[current]) continue;
    visited[current] = true;
    for (let next of words)
      if (!visited[next] && diff(current, next) == 1)
        queue.push([next, distance+1]);
  }
  return 0;
}

console.log(solution("hit",	"cog",	["hot","dot","dog","lot","log","cog"]));
console.log(solution("hit",	"cog",	["hot","dot","dog","lot","log"]));
