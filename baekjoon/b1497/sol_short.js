let IN=require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0].split(' ')[0],
A=IN.slice(1).map(s=>BigInt('0b'+(''+s.split(' ')[1]).split('').map(c=>c=='Y'?'1':'0').join(''))),
SONG=0, ANS=-1;
DFS(0,0,0n)
console.log(ANS)

function DFS(i, ans, song) {
  if (i==N) {
    if (song > SONG) { SONG=song; ANS=ans; }
    else if (song==SONG && ans < ANS) ANS=ans;
    return
  }
  DFS(i+1, ans, song)
  DFS(i+1, ans+1, song|A[i])
}