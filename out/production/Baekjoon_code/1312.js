const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const A = num[0];
const B = num[1];
const N = num[2];

const solution = () => {
    let tmp = A % B;
    for(let i = 0 ; i < N; i++){
        tmp *= 10;
        if(i == N-1)
            console.log(Math.floor(tmp/B))
        tmp %= B;
    }
}

solution();