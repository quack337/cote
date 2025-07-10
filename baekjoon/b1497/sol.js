let IN= require('fs').readFileSync(0).toString().split(/[\r\n]+/),
  [N, M] = IN[0].split(' ').map(e=>+e),
  A = IN.slice(1).map(s => BigInt('0b'+ String(s.split(' ')[1]).split('').map(c => c=='Y'?'1':'0').join('')));
let GCNT=0, SONG=0;
DFS(0,0,0n);
console.log(SONG ? GCNT : -1);

function DFS(i, gcnt, song) {
  if (i==N) {
    if (song > SONG) { SONG = song; GCNT = gcnt; }
    else if (song == SONG && gcnt < GCNT) GCNT = gcnt;
    return;
  }
  DFS(i+1, gcnt, song);
  DFS(i+1, gcnt+1, song | A[i]);
}
