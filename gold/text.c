#include <stdio.h>
#include <string.h>
#define  INF  1000

short dp[1001][1001][2];
short min(short a,short b) { return a<b?a:b; }
int main()
{
  int i, j, r, na, nb;
  char a[1004], b[1004];
  gets(a);
  gets(b);
  
  na=strlen(a);
  nb=strlen(b);
  
  if(na>nb)
    { puts("-1"); return 0; }
  for(i=1;i<=nb;i++){
    dp[0][i][0]=INF;
    dp[0][i][1]=1;
  }
  dp[0][0][0]=0;
  dp[0][0][1]=INF;

  for(i=0;i<na;i++){
    for(j=0;j<=i;j++){
        dp[i+1][j][0] = dp[i+1][j][1] = INF;
    }
    for(j=i;j<nb;j++)
    {
      if(a[i]==b[j])
        dp[i+1][j+1][0] = min(dp[i][j][0],dp[i][j][1]);
      else
        dp[i+1][j+1][0] = INF;
      dp[i+1][j+1][1] = min(dp[i+1][j][0]+1,dp[i+1][j][1]);
    }
  }
  r=min(dp[na][nb][0],dp[na][nb][1]);
  printf("%d\n",(r>=INF)?-1:r);
}