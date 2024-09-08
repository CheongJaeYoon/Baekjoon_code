const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = input[0].split(' ').map((el) => +el);
const data = [];
for(let i = 1; i < N[0]+1; i++){
    data.push(input[i].split(''))
}

let parent = [];
let left_edge = [];

const solution = (N, M, data) => {
    let road_count = 0;
    let node = new Array(N).fill(0);

    for(let i = 0; i < N; i++){
        parent[i] = i
    }

    for(let i = 0; i < N; i++){
        for(let j = i+1; j < N; j++){
            if(data[i][j] == 'Y'){
                if(find(i) != find(j)){
                    union(i, j);
                    road_count++;
                    node[i]++;
                    node[j]++;
                }
                else{
                    left_edge.push([i,j])
                }
            }
        }
    }

    if(road_count != N-1){
        console.log("-1");
        return;
    }

    let edge;
    for(let i = N-1; i < M; i++) {
        if(left_edge.length == 0){
            console.log("-1");
            return;
        }

        edge = left_edge.shift();
        node[edge[0]]++;
        node[edge[1]]++;
    }
    console.log(node.join(' '))
}

const find = (a) => {
    if(parent[a] == a){
        return a;
    }
    else{
        let b = find(parent[a])
        parent[a] = b;
        return b;
    }
}

const union = (a, b) => {
    parent[find(b)] = find(a);
}




solution(N[0], N[1], data);