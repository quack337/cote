D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[[N,M],[w,x,y,z]]=D;
g=M?y:w;b=M?z:x;
for(let i=1,t;i<N;++i){t=g*w+b*y;b=g*x+b*z;g=t}
F=x=>x*1000+.5|0;
console.log(F(g)+'\n'+F(b))