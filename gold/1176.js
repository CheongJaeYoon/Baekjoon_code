const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const K = num[1];
let data = [];
for(let i = 1; i <= N; i++){
    data[i - 1] = +input[i]
}
let check = new Array(N);
for(let i = 0; i < N; i++){
    check[i] = new Array(N).fill(0);
}
let dp = new Array(1 << N);
for(let i = 0; i < (1 << N); i++){
    dp[i] = new Array(N).fill(0);
}
const full = (1 << N) - 1;
let count = 0;

const solution = () => {
    let student1;
    let student2;
    for(let i = 0; i < N; i++){
        student1 = data[i];
        for(let j = i+1; j < N; j++){
            student2 = data[j];
            if(Math.abs(student1 - student2) > K){
                check[i][j] = 1;
                check[j][i] = 1;
            }
        }
    }

    for(let i = 0; i < N; i ++){
        dp[1 << i][i] = 1;
    }
    for(let i = 0; i < (1 << N); i++){
        for(let j = 0 ; j < N; j++){
            if(dp[i][j] == 0)
                continue;
            for(let n = 0; n < N; n++){
                if( (i & (1 << n)) > 0)
                    continue;
                if( check[j][n] == 0)
                    continue;
                let new_state = i | (1 << n);
                dp[new_state][n] += dp[i][j]
            }
        }
    }
    let sum = 0;
    for( let i = 0; i < N; i++){
        sum += dp[full][i]
    }
    console.log(sum)
}


solution();