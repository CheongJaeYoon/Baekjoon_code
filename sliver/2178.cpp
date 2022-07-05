#include <stdio.h>
#include <queue>

using namespace std;

int main() {
	int N,M;
	int ans = 0;
	int check[110][110] = { 0 };
	char maze[110][110] = { 0 };
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };

	scanf("%d %d ", &N, &M);
	queue <int> x;
	queue <int> y;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M+1; ++j)
		{
			scanf("%c", &maze[i][j]);
		}
	}

	x.push(0); y.push(0);
	check[0][0] = 1;

	while (!x.empty())
	{
		int curX = x.front(); x.pop();
		int curY = y.front(); y.pop();
		for (int i = 0; i < 4; ++i)
		{
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];
			if (maze[nextX][nextY] == '1')
			{
				if ((check[nextX][nextY])==0)
				{
					check[nextX][nextY] = check[curX][curY] + 1;
					x.push(nextX);
					y.push(nextY);
				}
			}
			if (nextX == N-1 && nextY == M-1)
			{
				ans = check[nextX][nextY];
				break;
			}

		}
	}
	
	printf("%d\n", ans);
	return 0;
}