D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' '));
[a,b,c,d]=D[0];
I={[a]:0,[b]:1,[c]:2,[d]:3};
A=[[],[],[],[]];
G=[];
for(let i=1;i<7;++i){
 [a,b,w,d,l]=D[i];a=I[a];b=I[b];
 G.push([a,b])
 A[a][b]=[w,d,l];
 A[b][a]=[l,d,w];
}
S=[];
B1=n=>{
 if(n==6){B2();return}
 for(let i=0;i<3;++i){S[n]=i;B1(n+1)}
}
B2=_=>{

}