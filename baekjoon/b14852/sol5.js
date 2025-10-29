N=(require('fs').readFileSync(0)+'')-1;
D=1e9+7;x=2;y=z=w=1;
for(let i=0;i<N;++i)[w,x,y,z]=[x,(x*2+y+z+w)%D,x+z,x+y];
console.log(x)