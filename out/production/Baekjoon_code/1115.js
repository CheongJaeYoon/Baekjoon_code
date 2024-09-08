const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const P = input[1].replace(/\r/, "").split(" ").map(el=>+el);
let graph = [];
for(let i = 0; i < N; i++){
    graph[i] = P[i]
}
let circle_cnt = 0;

const solution = () => {
    visited = new Array(N).fill(0);
    for(let i = 0; i < N; i++){
        if(visited[i])
            continue;
        visited[i] = 1
        let tmp = i
        while(visited[graph[tmp]] == 0){
            tmp = graph[tmp];
            visited[tmp] = 1;
        }
        circle_cnt++;

        
    }

    if(circle_cnt == 1)
        console.log(0)
    else
        console.log(circle_cnt)
}


solution();