class Location {
  constructor(r, c) {
    this.r = r;
    this.c = c;
  }
  toInt() {
    return this.r * 1000 + this.c;
  }
}

class Board {
    constructor(게임판크기) {
        this.게임판크기 = 게임판크기;
        this.사과좌표 = new Set();
    }

    사과등록(location) { this.사과좌표.add(location.toInt()); }
    사과가있는가(location) { return this.사과좌표.has(location.toInt()); }
    사과제거(location) { this.사과좌표.delete(location.toInt()); }
    벽에충돌(location) {
        return location.r < 1 || location.r > this.게임판크기 ||
               location.c < 1 || location.c > this.게임판크기;
    }
}

class Snake {
  constructor() {
    this.vr = 0; this.vc = 1; // 오른쪽 방향
    this.몸좌표목록 = [];
    this.몸좌표목록.push(new Location(1, 1));
  }

  get머리가전진할좌표() {
    const 머리좌표 = this.몸좌표목록[0];
    return new Location(머리좌표.r + this.vr, 머리좌표.c + this.vc);
  }

  머리가_전진한다(location) { this.몸좌표목록.unshift(location); }
  꼬리가_전진한다() { this.몸좌표목록.pop(); }
  몸에충돌(location) { return this.몸좌표목록.some(좌표 => 좌표.toInt() == location.toInt()); }

  회전하라(회전방향) {
      if (this.vr === -1) {
          this.vr = 0;
          this.vc = 회전방향 === 'L' ? -1 : 1;
      } else if (this.vr === 1) {
          this.vr = 0;
          this.vc = 회전방향 === 'L' ? 1 : -1;
      } else if (this.vc === -1) {
          this.vc = 0;
          this.vr = 회전방향 === 'L' ? 1 : -1;
      } else if (this.vc === 1) {
          this.vc = 0;
          this.vr = 회전방향 === 'L' ? -1 : 1;
      }
  }
}

function 이동하라(뱀, 게임판) {
  const 새좌표 = 뱀.get머리가전진할좌표();
  if (게임판.벽에충돌(새좌표)) return false;
  if (뱀.몸에충돌(새좌표)) return false;
  뱀.머리가_전진한다(새좌표);
  if (게임판.사과가있는가(새좌표))
    게임판.사과제거(새좌표);
  else
    뱀.꼬리가_전진한다();
  return true;
}

function 플레이(게임판, 회전명령) {
  const 뱀 = new Snake();
  let 초 = 1;
  while (이동하라(뱀, 게임판)) {
    const 회전방향 = 회전명령.get(초);
    if (회전방향) 뱀.회전하라(회전방향);
    초++;
  }
  return 초;
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let ii = 0;
let N = parseInt(input[ii++]);
let 게임판 = new Board(N);

const 사과_수 = parseInt(input[ii++]);
for (let i = 0; i < 사과_수; i++) {
  let r = parseInt(input[ii++]);
  let c = parseInt(input[ii++]);
  게임판.사과등록(new Location(r, c));
}

let 회전명령_수 = parseInt(input[ii++]);
let 회전명령 = new Map();
for (let i = 0; i < 회전명령_수; i++) {
  let 초 = parseInt(input[ii++]);
  let 방향 = input[ii++];
  회전명령.set(초, 방향);
}

const 초 = 플레이(게임판, 회전명령);
console.log(초);
