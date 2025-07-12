import fs from 'fs';

let A=[
[[0,0,0,0,0],
 [1,1,1,1,0],
 [0,0,0,0,0],
 [0,1,1,1,1],
 [0,0,0,0,0]],

[[0,0,0,1,1],
 [0,0,0,1,1],
 [0,0,0,1,1],
 [0,0,0,1,1],
 [0,0,0,0,0]],
];

for (let i=0; i<A.length; ++i)
  save('data'+(i+2), A[i])

function save(name, A) {
  let out=[]
  let cnt = A.flat().reduce((r,e)=>r+e)
  out.push(cnt)
  for (let r=0; r<5; ++r)
    for (let c=0; c<5; ++c)
      if (A[r][c]) out.push((r+1) + ' ' + (c+1))
  fs.writeFileSync(name, out.join('\n'))
}
