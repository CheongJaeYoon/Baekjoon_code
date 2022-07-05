const solution = (N, data) => {
    for(let i = 0; i < N; i++){
        C(data[i][1], data[i][0])
    }
}

const C = (left, right) => {
    let up = 1;
    let down = 1;
    for(let i = left; i> (left-right);i--){
        up = up*i;
    }
    for(let j = right; j> 1; j--){
        down = down*j;
    }
    console.log( Math.round(up/down) )
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 1; i < N + 1; i++){
    data.push(input[i].split(' ').map((el) => +el));
}

solution(N, data);