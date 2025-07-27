// n 100,000 이므로 보나마나 stack overflow? 가 아니고 시간초과네
BT=(i,p)=>{
 if(i==N)return 0
 if(M[p][i])return M[p][i]
 let a=BT(i+1,0),b=p-1?BT(i+1,1)+A[0][i]:0,c=p-2?BT(i+1,2)+A[1][i]:0
 return M[p][i]=Math.max(a,b,c)
}
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
T=+D[0]
X=[]
for(t=0;t<T;++t){
 N=+D[t*3+1]
 A=D.slice(t*3+2,t*3+4)
 M=[[],[],[]]
 X.push(BT(0,0))
}
console.log(X.join('\n'))