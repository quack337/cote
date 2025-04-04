function solution(array, cmd) {
  let answer = [];
  for (let i = 0; i < cmd.length; i++) {
    let [from, to, k] = cmd[i];
    let a = array.slice(from - 1, to)
    a.sort((a, b) => a - b);
    answer.push(a[k - 1]);
  }
  return answer;
}

const array = [1, 5, 2, 6, 3, 7, 4];
const commands = [[2, 5, 3],[4, 4, 1],[1, 7, 3]];
console.log(solution(array, commands));
