H=[0,1];Y=[0,0];
for(let i=2;i<=10;++i){
  H[i]=H[i-1]*2+1;//w=h*2-1;
  Y[i]=Y[i-1]+(i%2?-1:1)*H[i-1];
}
//  console.log(H.join())
//  console.log(Y.join())
N=3;h=H[N];w=h*2-1;
A=Array(20).fill().map(_=>Array(w).fill(' '));
put=(x,y)=>A[-y+h][x+(w/2|0)]='*';

x=-w/2|0;y=Y[N];
for(let i=0;i<w;++i)put(x+i,y);
for(let i=0;i<h;++i){put(x+w-i-1,y+i);put(x+i,y+i)}
console.log(h);

console.log(A.map(a=>a.join('')).join('|\n')+'|')
