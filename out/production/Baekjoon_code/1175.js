const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const M = num[1];

let data = [];
let cur_pos = [];
let C = [];
let breaker = false;
const r_dir = [0, 1, 0, -1]
const c_dir = [-1, 0, 1, 0]
let visit = new Array(N);
for(let i = 1; i <= N; i++){
    visit[i - 1] = new Array(M);
    for(let j = 0; j < M; j++){
        visit[i - 1][j] = new Array(4);
        for(let n = 0; n < 4; n++){
            visit[i - 1][j][n] = [[0,0], [0,0]]
        }
    }
    data.push(input[i].trim().split(""));
    for(let j = 0; j < M; j++){
        if(data[i-1][j] == 'S')
            cur_pos = [i-1, j]
        if(data[i-1][j] == 'C')
            C.push([i-1, j])
    }
}

const solution = () => {
    result = -1;
    let queue = [];
    queue.push([cur_pos[0], cur_pos[1], null, 0, 0, 0])
    let tmp, r_pos, c_pos, prev_dir, c1, c2, cnt, r, c, symbol;
    while(queue.length != 0){

        tmp = queue.shift();
        r_pos = tmp[0];
        c_pos = tmp[1];
        prev_dir = tmp[2];
        c1 = tmp[3];
        c2 = tmp[4];
        cnt = tmp[5];

        if(c1 == 1 && c2 == 1){
            result = cnt
            break;
        }

        for(let i = 0; i < 4; i++){
            if(i == prev_dir) //same prev direction
                continue;
            r = r_pos + r_dir[i];
            c = c_pos + c_dir[i];
            if(r < 0 || r >= N || c < 0 || c >= M) // out of range
                continue;
            if(visit[r][c][i][c1][c2] == 1)
                continue;
            visit[r][c][i][c1][c2] = 1
            symbol = data[r][c]
            if(symbol == '#')
                continue;
            if(symbol == 'C'){
                if(r == C[0][0] && c == C[0][1])
                    queue.push([r, c, i, 1, c2, cnt + 1]);
                else if(r == C[1][0] && c == C[1][1])
                    queue.push([r, c, i, c1, 1, cnt + 1]);
            }
            if(symbol == '.')
                queue.push([r, c, i, c1, c2, cnt + 1]);
            if(symbol == 'S')
                queue.push([r, c, i, c1, c2, cnt + 1]);
        }

    }
    console.log(result)
}


solution();