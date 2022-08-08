const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const C = num[0];
const D = num[1];
const M = num[2];

const data = [];
for(let i = 0; i < C; i++){
    data.push(input[i+1].trim().split(" ").map(el => +el))
}
let dp = [];

const solution = () => {
    let money = M;
    for(let i = 1; i < D; i++){
        dp = new Array(500010).fill(0);
        for(let j = 0; j < C; j++){
            for(let n = 0; n <= money; n++ ){
                if(n - data[j][i - 1] < 0)
                    continue;
                dp[n] = Math.max(dp[n], dp[n - data[j][i - 1]] + (data[j][i] - data[j][i - 1]))
            }
        }
        money += dp[money];
    }
    console.log(money)
}

solution();