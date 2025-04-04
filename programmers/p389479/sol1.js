function solution(players, m, k) {
    let answer = 0, 서버수 = 0;
    let 반납 = Array(players.length).fill(0);
    for (let i = 0; i < players.length; ++i) {
        let 필요한서버수 = Math.floor(players[i] / m);
        let 증설 = Math.max(필요한서버수 - 서버수 + 반납[i], 0)
        반납[i + k] = 증설;
        서버수 = 서버수 + 증설 - 반납[i];
        answer += 증설;
        //console.log(i, players[i], 서버수, 증설);
    }
    return answer;
}

let players = [0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5];
console.log(solution(players, 3, 5));
players = [0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0];
console.log(solution(players, 5, 1));
players = [0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1];
console.log(solution(players, 1, 1));
