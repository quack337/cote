let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), input_idx = 0;
let getStr = () => input[input_idx++], getInt = () => parseInt(getStr());
const DIR = [[-1,0], [-1,-1],[0,-1],[1,-1],[1,0],[1,1],[0,1],[-1,1]];
const 상어칸 = -1, 빈칸 = 0;
let _A = Array(4).fill().map(() => []);
let _fish = [null];
for (let r = 0; r < 4; ++r)
  for (let c = 0; c < 4; ++c) {
    let no = getInt(), dir = getInt()-1;
    _fish[no] = {r, c, dir};
    _A[r][c] = no;
  }
let _shark = {r:-1, c:-1, dir:0, sum:0}, answer = 0;
DFS(0, 0, _shark, _fish, _A);
console.log(answer);

function DFS(r, c, shark, fish, A) {
  shark = {...shark}; fish = [...fish]; A = A.map(row => [...row]);
  상어이동(r, c, shark, fish, A);
  물고기이동(fish, A);
  for (let [r, c] of 상어이동할곳(A, shark))
    DFS(r, c, shark, fish, A);
}

function 상어이동(r, c, shark, fish, A) {
  if (shark.r >= 0) A[shark.r][shark.c] = 빈칸;
  let no = A[r][c];
  shark.r = r; shark.c = c;
  shark.dir = fish[no].dir;
  shark.sum += no;
  if (shark.sum > answer) answer = shark.sum;
  A[r][c] = 상어칸;
  fish[no] = null;
}

function isValid(r, c) {
  return r >= 0 && c >= 0 && r < 4 && c < 4;
}

function 상어이동할곳(A, shark) {
  let result = [];
  let r1 = shark.r, c1 = shark.c, dir1 = shark.dir;
  for (let 거리 = 1; 거리 <= 4; ++거리) {
    let r2 = r1 + DIR[dir1][0] * 거리, c2 = c1 + DIR[dir1][1] * 거리;
    if (isValid(r2, c2) && A[r2][c2] != 빈칸)
      result.push([r2, c2]);
  }
  return result;
}

function 물고기이동(fish, A) {
  for (let no = 1; no <= 16; ++no)
    if (fish[no]) {
      let r1 = fish[no].r, c1 = fish[no].c, dir1 = fish[no].dir;
      while (true) {
        let r2 = r1 + DIR[dir1][0], c2 = c1 + DIR[dir1][1];
        if (isValid(r2, c2) && A[r2][c2] != 상어칸) {
          let no2 = A[r2][c2];
          if (no2 != 빈칸)
            fish[no2] = {r: r1, c: c1, dir: fish[no2].dir};
          fish[no] = {r: r2, c: c2, dir: dir1 };
          A[r1][c1] = no2;
          A[r2][c2] = no;
          break;
        }
        dir1 = (dir1 + 1) % 8;
      }
    }
}
