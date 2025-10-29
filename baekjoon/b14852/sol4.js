N=+(require('fs').readFileSync(0)+'');
D=1e9+7;
M=Array(N+1);
M[N]=[1];M[N-1]=[2,1,1];
for(let c=N-2; c>=0; --c){
  let [x,y,z]=M[c+1];
  M[c] = [(x*2+y+z+M[c+2][0])%D, (x+z)%D, (x+y)%D];
}
console.log(M[0][0]);