D=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=D.shift();
M=Array(N).fill().map(_=>Array(N).fill(0));
for(let d=1;d<N;++d)
for(let a=0;a<N-d;++a){let b=a+d,m=M[a],m1=M[a+1];
 if(D[a]==D[b])m[b]=m1[b-1];
 else{let x=m1[b],y=m[b-1];m[b]=(x<y?x:y)+1;}
}
console.log(M[0][N-1])