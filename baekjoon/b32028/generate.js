fs=require('fs');

N=100;
A=[];
for(let i=1;i<=N;++i)A.push(i);
for(let i=0;i<N;++i){
  let j=Math.random()*N|0;
  [A[i],A[j]]=[A[j],A[i]]
}
root=[-1,A[0],-1];
for(let i=1;i<N;++i)
  add(root, [-1,A[i],-1]);

IN=[];
generateInData(root, 1);
fs.writeFileSync("data", N+'\n'+
  IN.sort((a,b)=>a[0]-b[0]).map(e=>e.join(' ')).join('\n'));

OUT=[];
generateOutData(root);
fs.writeFileSync("out", OUT.join('\n'));

function add(parent, node){
  if(node[1]<parent[1]){
    if(parent[0]==-1) parent[0]=node;
    else add(parent[0], node);
  } else {
    if(parent[2]==-1) parent[2]=node;
    else add(parent[2], node);
  }
}

function generateInData(node, depth){
  if(node==-1)return;
  IN.push([node[1], depth]);
  generateInData(node[0], depth+1);
  generateInData(node[2], depth+1);
}

function generateOutData(node){
  if(node==-1)return;
  let a = node[0]==-1 ? -1 : node[0][1];
  let b = node[2]==-1 ? -1 : node[2][1];
  OUT[node[1]-1] = a+' '+b;
  generateOutData(node[0]);
  generateOutData(node[2]);
}