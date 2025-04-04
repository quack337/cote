function clear(map, ch, row, col, visited) {
    if (row < 0 || col < 0 || row >= map.length || col >= map[0].length) return;
    if (visited[row][col]) return;
    visited[row][col] = true;
    if (map[row][col] === '0') {
        clear(map, ch, row - 1, col, visited);
        clear(map, ch, row + 1, col, visited);
        clear(map, ch, row, col - 1, visited);
        clear(map, ch, row, col + 1, visited);
    } else if (map[row][col] === ch)
        map[row][col] = '0';
}

function solution(storage, requests) {
    let map = storage.map(s => s.split(''));
    for (let req of requests) {
        if (req.length === 2) {
            for (let r = 0; r < map.length; ++r)
                for (let c = 0; c < map[0].length; ++c)
                    if (map[r][c] === req[0]) map[r][c] = '0';
        } else {
            let visited = Array.from({ length: map.length },
                                    () => Array(map[0].length).fill(false));
            for (let r = 0; r < map.length; ++r) {
                clear(map, req, r, 0, visited);
                clear(map, req, r, map[0].length - 1, visited);
            }
            for (let c = 0; c < map[0].length; ++c) {
                clear(map, req, 0, c, visited);
                clear(map, req, map.length - 1, c, visited);
            }
        }
    }
    let answer = 0;
    for (let r = 0; r < map.length; ++r)
        for (let c = 0; c < map[0].length; ++c)
            if (map[r][c] !== '0') ++answer;
    return answer;
}

const storage1 = ["AZWQY", "CAABX", "BBDDA", "ACACA"];
const requests1 = ["A", "BB", "A"];
let answer = solution(storage1, requests1);
console.log(answer);

const storage2 = ["HAH", "HBH", "HHH", "HAH", "HBH"];
const requests2 = ["C", "B", "B", "B", "B", "H"];
answer = solution(storage2, requests2);
console.log(answer);
