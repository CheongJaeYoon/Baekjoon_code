const solution = (N, data) => {
    for(let i = 0; i < N; i++){
        func(data[i][1] - data[i][0])
    }
}

const func = (distance) => {
    let result = 0;
    let num = 1;
    let i = 1;
    let j = 0;
    while(true){
        result += i;
        if(distance<=result){
            console.log(num)
            break;
        }

        j++;
        num++;
        if( j == 2){
            i++;
            j = 0;
        }
    }
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 1; i < N + 1; i++){
    data.push(input[i].split(' ').map((el) => +el));
}

solution(N, data);