#include <stdio.h>

int Vertex[1001][1001] = { 0 };
int DFSVisit[1001] = { 0 };
int BFSVisit[1001] = { 0 };
int queue[1001] = { 0 };

void DFS(int V,int N)
{
	DFSVisit[V] = 1;
	for (int i = 1; i < N+1; ++i)
	{
		if (Vertex[V][i] == 1 && DFSVisit[i] == 0)
		{
			printf(" %d", i);
			DFS(i, N);
		}
	}
}

void BFS(int V, int N)
{
	int front = 0, rear = 0, pop;
	printf("%d", V);
	queue[0] = V;
	rear++;
	BFSVisit[V] = 1;

	while (front < rear)
	{
		pop = queue[front];
		front++;

		for (int i = 1; i < N+1; ++i)
		{
			if (Vertex[pop][i] == 1 && BFSVisit[i] == 0)
			{
				printf(" %d", i);
				queue[rear] = i;
				rear++;
				BFSVisit[i] = 1;
				
			}
		}
	}


}


int main()
{	int N, M, V;
	scanf("%d %d %d", &N, &M, &V);
	while (M--)
	{
		int Temp[2] = { 0 };
		scanf("%d %d", &Temp[0], &Temp[1]);
		Vertex[Temp[0]][Temp[1]] = 1;
		Vertex[Temp[1]][Temp[0]] = 1;
	}
	printf("%d", V);
	DFS(V, N);
	printf("\n");
		BFS(V, N);
	return 0;

}