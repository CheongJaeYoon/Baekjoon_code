const solution = (N, data) => {
    for(let i = 0; i < N; i++){
        func(data[i][0])
    }
}

const func = (str) => {
    let reg = /(100+1+|01)+/
    let result = reg.test(str);
    if(result)
        console.log("YES");
    else
        console.log("NO")
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 1; i < N + 1; i++){
    data.push(input[i].split(' '));
}

solution(N, data);