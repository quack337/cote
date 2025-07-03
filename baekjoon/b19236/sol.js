let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/), in_idx = 0;
let getStr = () => input[in_idx++], getInt = () => parseInt(getStr());
const DR = [-1,-1,0,1,1,1,0,-1], DC = [0,-1,-1,-1,0,1,1,1];
const 상어칸 = -1, 빈칸 = 0;
const isValid = (r, c) => r >= 0 && c >= 0 && r < 4 && c < 4;
let A = Array(4).fill().map(() => []), fish = [];
for (let r = 0; r < 4; ++r)
  for (let c = 0; c < 4; ++c) {
    let no = getInt(), dir = getInt()-1;
    fish[no] = {r, c, dir};
    A[r][c] = no;
  }
let shark = {r:-1, c:-1, dir:0, sum:0}, 답 = 0;
DFS(0, 0, shark, fish, A);
console.log(답);

function DFS(r, c, shark, fish, A) {
  상어이동(r, c, shark, fish, A);
  물고기이동(fish, A);
  for (let [r, c] of 상어이동할곳(A, shark))
    DFS(r, c, {...shark}, {...fish}, A.map(row => [...row]));
}

function 상어이동(r2, c2, shark, fish, A) {
  let no = A[r2][c2];
  let {r, c} = shark;
  if (r != -1) A[r][c] = 빈칸;
  shark.r = r2; shark.c = c2;
  shark.dir = fish[no].dir;
  shark.sum += no;
  if (shark.sum > 답) 답 = shark.sum;
  A[r2][c2] = 상어칸;
  fish[no] = 0;
}

function 상어이동할곳(A, shark) {
  let list = [];
  let {r, c, dir} = shark;
  for (;;) {
    r += DR[dir]; c += DC[dir];
    if (!isValid(r, c)) return list;
    if (A[r][c] > 빈칸) list.push([r, c]);
  }
}

function 물고기이동(fish, A) {
  for (let no = 1; no <= 16; ++no)
    if (fish[no]) {
      let {r, c, dir} = fish[no];
      for (;;) {
        let r2 = r + DR[dir], c2 = c + DC[dir];
        if (isValid(r2, c2) && A[r2][c2] != 상어칸) {
          let no2 = A[r2][c2];
          if (no2 > 빈칸) fish[no2] = {r, c, dir: fish[no2].dir};
          fish[no] = {r: r2, c: c2, dir: dir};
          A[r][c] = no2;
          A[r2][c2] = no;
          break;
        }
        dir = (dir + 1) % 8;
      }
    }
}