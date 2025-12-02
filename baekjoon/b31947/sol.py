import sys
input = sys.stdin.readline


N, M = map(int, input().split())
S, E = map(int, input().split())
S -= 1
E -= 1
# dp[i][j]: j번째 가로선이 추가되었을 때 i번째 세로선의 우승확률
dp = [[0] * (M + 1) for _ in range(N)]
dp[E][0] = 1
for j in range(1, M + 1):
    for i in range(N):
        if i == 0:
            dp[i][j] = (dp[i + 1][j - 1] + (N - 2)* dp[i][j - 1]) / (N - 1)
        elif i == N - 1:
            dp[i][j] = (dp[i - 1][j - 1] + (N - 2) * dp[i][j - 1]) / (N - 1)
        else:
            dp[i][j] = (dp[i + 1][j - 1] + (N - 3) * dp[i][j - 1] + dp[i - 1][j - 1]) / (N - 1)


print(dp[S][-1])