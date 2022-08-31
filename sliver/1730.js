const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const str = input[1].trim().split("");

const solution = () => {
    let board = new Array(N);
    for(let i = 0; i < N; i++){
        board[i] = new Array(N).fill(0);
    }
    let c_pos = [0, N-1];
    let n_pos = [0, 0];
    for(let i = 0; i < str.length; i++){
        let cur_c = str[i];
        let cut = 0;
        n_pos = [0, 0];
        let ignore = false;

        if(cur_c == 'R'){
            n_pos[0]++;
            cut = (1 << 0);
        } 
        if(cur_c == 'L'){
            n_pos[0]--;
            cut = (1 << 0);
        }
        if(cur_c == 'U'){
            n_pos[1]++;
            cut = (1 << 1);
        }
        if(cur_c == 'D'){
            n_pos[1]--;
            cut = (1 << 1);
        }
        
        if(c_pos[0] + n_pos[0] < 0){
            ignore = true;;
        }
        if(c_pos[0] + n_pos[0] >= N){
            ignore = true;;
        }
        if(c_pos[1] + n_pos[1] < 0){
            ignore = true;;
        }
        if(c_pos[1] + n_pos[1] >= N){
            ignore = true;;
        }
        if(!ignore){
            board[c_pos[0]][c_pos[1]] |= cut;
            c_pos[0] += n_pos[0];
            c_pos[1] += n_pos[1];
            board[c_pos[0]][c_pos[1]] |= cut;
        }

    }
    let result = "";
    for(let i = N-1; i >= 0; i--){
        for(let j = 0; j < N; j++){
            if(board[j][i] == 0)
                result += ".";
            if(board[j][i] == 1)
                result += "-";
            if(board[j][i] == 2)
                result += "|";
            if(board[j][i] == 3)
                result += "+";
        }
        console.log(result)
        result = "";
    }

}

solution();