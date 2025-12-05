[N,A,C,R]=(require('fs').readFileSync(0)+'').split(/\s+/);
r=c=0;w=1;N*=1;
for(i=0;i<N;++i,w*=2){a=A[N-1-i];if(a==1||a==4)c+=w;if(a==3||a==4)r+=w;}
r-=+R;c+=+C;
if(r<0||c<0||r>=w||c>=w){console.log(-1);return}
B=[[2,1],[3,4]];w/=2;X=[];
for(i=0;i<N;++i,w/=2){X[i]=B[r>=w?1:0][c>=w?1:0];r%=w;c%=w;}
console.log(X.join(''))