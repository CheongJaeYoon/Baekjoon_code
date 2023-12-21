const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const M = num[1];

let data = [];
const r_dir = [0, 1, 0, -1]
const c_dir = [-1, 0, 1, 0]
let cur_pos;
for(let i = 1; i <= N; i++){
    data.push(input[i].trim().split(""));
    for(let j = 0; j < M; j++){
        if(data[i-1][j] == '0')
            cur_pos = [i-1, j]
    }
}
let visited = new Array( 1 << 6 );
for(let i = 0; i < (1 << 7); i++){
    visited[i] = new Array( N )
    for(let j = 0 ; j < N ; j++){
        visited[i][j] = new Array( M ).fill(0);
    }
}

const solution = () => {
    result = -1;
    let queue = [];
    queue.push([cur_pos[0], cur_pos[1],0 , 0])
    visited[0][cur_pos[0]][cur_pos[1]] = 1;
    let tmp, r_pos, c_pos, cnt, r, c, symbol;
    while(queue.length != 0){

        tmp = queue.shift();
        r_pos = tmp[0];
        c_pos = tmp[1];
        keys = tmp[2];
        cnt = tmp[3];

        for(let i = 0; i < 4; i++){
            r = r_pos + r_dir[i];
            c = c_pos + c_dir[i];
            
            if(r < 0 || r >= N || c < 0 || c >= M) // out of range
                continue;
            if(visited[keys][r][c] == 1)
                continue;

            symbol = data[r][c]
            if(symbol == '#')
                continue;
            if(symbol == '1'){
                result = cnt + 1;
                queue = [];
                break;
            }
            if(symbol == '.' || symbol == '0'){
                visited[keys][r][c] = 1;
                queue.push([r, c, keys, cnt + 1]);
            }
            if(symbol == 'a' || symbol == 'b' || symbol == 'c' || symbol == 'd' || symbol == 'e' || symbol == 'f'){
                let convert = parseInt(symbol, 16) - 9;
                let new_keys = keys | (1 << convert);
                visited[new_keys][r][c] = 1;
                queue.push([r, c, new_keys, cnt + 1]);
            }
            if(symbol == 'A' || symbol == 'B' || symbol == 'C' || symbol == 'D' || symbol == 'E' || symbol == 'F'){
                let convert = parseInt(symbol, 16) - 9;
                let check = keys & (1 << convert);
                if(check > 0){
                    visited[keys][r][c] = 1;
                    queue.push([r, c, keys, cnt + 1]);
                }
            }
        }

    }
    console.log(result)
}


solution();