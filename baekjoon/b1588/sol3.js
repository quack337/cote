[X,L,R,N]=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e)
C=[,'132','211','232']
J=(a,b)=>b.map((e,i)=>a[i]+=e)
D=Array(N+1).fill().map(_=>[])
for(n=0;n<=N;++n)for(x=1;x<4;++x){r=D[n][x]=[0,0,0]
 if(!n)r[x-1]=1;else for(c of C[x])J(r,D[n-1][+c])}
F=(n,x,l,r)=>{
 let e=3**n-1,u=3**n/3,p=[0,0,0],c=C[x],i
 if(l>e||r<0)return p;l=l<0?0:l;r=r>e?e:r
 if(r-l==e)return D[n][x]
 if(n<2){if(!n)p[x-1]=1;else for(i=l;i<=r;++i)p[c[i]-1]++}
 else for(i=0;i<3;++i)J(p,F(n-1,+c[i],l-u*i,r-u*i))
 return p}
console.log(F(N,X,L,R).join(' '))