//node는 BFS를 사용하면 시간이 오래걸린다...
const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');
class Node {
    constructor(node) {
      this.node = node;
      this.next = null;
    }
  }
  
class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(node) {
    if (!this.head) {
      this.head = node;
    }
    if (this.tail) {
      this.tail.next = node;
    }
    this.tail = node;
    this.size++;
  }

  shift() {
    if (!this.size) {
      return null;
    }
    const node = this.head;
    this.head = this.head.next;
    this.size--;
    return node;
  }
}


const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const start_city = num[1];
const end_city = num[2];
const M = num[3];

const INF = 99999999999;
const queue = new Queue();

let data = [];
for(let i = 1; i <= M; i++){
    data.push(input[i].trim().split(" ").map(el => +el))
}
let data2 = input[M+1].trim().split(" ").map(el => +el)

let graph = new Array(N);
for(let i = 0;i < N; i++){
    graph[i] = []
}
for(let i = 0; i < M; i++){
    graph[data[i][0]].push([data[i][1], data[i][2] - data2[data[i][1]]])
}

let table = new Array(N).fill(INF);
let result;


const solution = () => {
    table[start_city] = -data2[start_city];
    for(let i = 0; i < N; i++){
        for(let j = 0; j < N; j++){
            if(table[j] == INF)
                continue;
            for(let k = 0; k < graph[j].length; k++){
                let cur_node = j;
                let next_node = graph[j][k][0];
                let cost = graph[j][k][1];
                if((table[cur_node] != INF) && (table[next_node] > table[cur_node] + cost)){
                    table[next_node] = table[cur_node] + cost
                    if(i == N-1){
                        if(gee_check(next_node)){
                            result = "Gee"
                            return;
                        }
                    }
                }
            }
        }
    }
    if(table[end_city] == INF)
        result = "gg"
    else
        result = -table[end_city];
}
const gee_check = (node) => {
    let visit = new Array(N).fill(0);
    
    queue.push(new Node(node))
    visit[node] = 1;
    while(queue.size){
        const tmp = queue.shift().node;
        if(tmp == end_city)
            return true;
        for(let i = 0; i < graph[tmp].length; i++){
            if(visit[graph[tmp][i][0]] == 0){
                queue.push(new Node(graph[tmp][i][0]))
            }
        }
    }
    return false;

}

solution();
console.log(result)

