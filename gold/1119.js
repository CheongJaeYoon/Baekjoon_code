const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 0; i < N; i++){
    data.push(input[i+1].replace(/\r/, "").split(""))
}
let visited_node = new Array(N).fill(0);
let surplus_edge_cnt = 0;
let group_cnt = 0;

const solution = () => {
    if(N == 1){
        console.log(0);
        return
    }
    for(let i = 0; i < N; i++){
        let tmp = func(null, i)
        if(tmp){
            if(tmp == "island"){
                console.log(-1)
                return;
            }
            group_cnt++
        }
    }
    surplus_edge_cnt = surplus_edge_cnt/2
    if(group_cnt - 1 <= surplus_edge_cnt)
        console.log(group_cnt - 1);
    else
        console.log(-1)
}

const func = ( prev_node, cur_node) => {
    if(visited_node[cur_node] == 1)
        return false;

    visited_node[cur_node] = 1;
    let check_island = 0;
    for(let i = 0; i < N; i++){
        if(i == prev_node)
            continue;
        if(data[cur_node][i] == "Y"){
            if(visited_node[i] == 1){
                surplus_edge_cnt++;
            }
            else{
                func(cur_node, i);
            }
        }
        else{
            if(prev_node == null)
                check_island++;
        }
    }
    if(check_island == N)
        return "island"
    return true;
}

solution();