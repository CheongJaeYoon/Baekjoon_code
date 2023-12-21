const solution = (N, data, K) => {
    let number = new Array(36).fill(0);
    let sum = 0n;
    for(let i = 0; i<N; i++){
        let len = data[i].length
        for(let j = 0; j < len; j++){
            let tmp = parseInt(data[i][j], 36);
            if(number[tmp]){
                sum += bigintPow(36, len - j - 1) * BigInt(tmp);
                number[tmp] += bigintPow(36, len - j - 1) * BigInt((35 - tmp));
            }
            else{
                sum += bigintPow(36, len - j - 1) * BigInt(tmp);
                number[tmp] = bigintPow(36, len - j - 1) * BigInt((35 - tmp));
            }
        }
    }

    for(let i = 0; i < K; i ++){
        let max = [0, 0];
        for(let j = 0; j < 36; j++){
            if(number[j] > max[1]){
                max[0] = j;
                max[1] = BigInt(number[j])
            }
        }
        sum += BigInt(max[1]);
        number[max[0]] = 0;
    }
    console.log(sum.toString(36).toUpperCase());
}

const bigintPow = (a, b) => {
    let result = 1n;
    for(let i = 0; i< b; i++){
        result = result * BigInt(a)
    }
    return result
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
const K = +input[N+1]
for(let i = 1; i < N+1; i++){
    data.push(input[i].toLowerCase())
}

solution(N, data, K);