const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const data = [];
for(let i = 0; i < 5 ; i++){
    data.push(input[i].replace(/\r/, "").split(''));
}

const dot = [];
const board = new Array(7);
for(let i = 0; i < 7; i++){
    board[i] = new Array(7).fill(-1);
}
let total_num = 0;
let result = 9999999; 

const solution = () => {
    for(let i = 0; i < 5; i++){
        for(let j = 0; j < 5; j++){
            board[i+1][j+1] = 0;
            if(data[i][j] == "*"){
                dot.push([i+1, j+1]);
                total_num++;
            }
        }
    }
    dfs(0, 0);
    console.log(result);
}

const dfs = (num_of_dot, moving_distance) => {
    if(moving_distance > result){ //계산할 필요가 없음
        return;
    }
    if(num_of_dot == total_num){ //연결 된 경우인지 확인
        if(connect()){
            result = Math.min(moving_distance, result);
        }
        return;
    }

    for(let i = 1; i < 6; i++){
        for(let j = 1; j < 6; j++){
            if(board[i][j] == 0){
                board[i][j] = 1;
                let tmp = Math.abs(dot[num_of_dot][0] - i) + Math.abs(dot[num_of_dot][1] - j);
                dfs(num_of_dot+1, moving_distance + tmp);
                board[i][j] = 0;
            }
        }
    }
}

let visit = new Array(7);
for(let i = 0; i < 7; i++){
    visit[i] = new Array(7);
}

const connect = () => {
    let group_count = 0;
    for(let i = 0; i < 7; i++){
        visit[i].fill(0);
    }

    for(let i = 1; i < 6; i++){
        for(let j = 1; j < 6; j++){
            if(board[i][j] && !visit[i][j]){
                visit[i][j] = 1;
                group_count++;
                group_visit(i, j);
            }
        }
    }
    if( group_count == 1)
        return true;
    else
        return false
}

const group_visit = (i, j) => {
    let add_x = [-1, 0, 1, 0];
    let add_y = [0, -1, 0, 1];
    for(let n = 0; n < 4; n++){
        let x = i + add_x[n];
        let y = j + add_y[n];
        

        if(board[x][y] != 1 || visit[x][y] == 1){ //board가 1이 아닌 경우나, 이미 방문한 경우
            continue;
        }
        visit[x][y] = 1;

        group_visit(x, y)

    }
}

solution();
