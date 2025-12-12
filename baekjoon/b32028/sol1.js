A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
for(let i=0;i<N;++i)A[i][2]=i;
A.sort((a,b)=>a[1]-b[1]?a[1]-b[1]:a[0]-b[0]);
root=[-1,A[0],-1];
if(A[0][1]!=1) {console.log(-1);return}
for(i=1;i<N;++i)
  if(!add(root, [-1,A[i],-1], 1)) {console.log(-1);return}
OUT=[];
generateOutData(root);
console.log(OUT.join('\n'))

function add(parent, node, depth){
  if(node[1][0]<parent[1][0]){
    if(parent[0]==-1) {parent[0]=node; return depth+1==node[1][1];}
    else return add(parent[0], node, depth+1);
  } else {
    if(parent[2]==-1) {parent[2]=node; return depth+1==node[1][1];}
    else return add(parent[2], node, depth+1);
  }
}

function generateOutData(node){
  if(node==-1)return;
  let a = node[0]==-1 ? -1 : node[0][1][2]+1;
  let b = node[2]==-1 ? -1 : node[2][1][2]+1;
  OUT[node[1][2]] = a+' '+b;
  generateOutData(node[0]);
  generateOutData(node[2]);
}