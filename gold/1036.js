const solution = (N, data, K) => {
    let number = new Array(36).fill(0);
    let sum = 0;
    for(let i = 0; i<N; i++){
        let len = data[i].length
        for(let j = 0; j < len; j++){
            let tmp = parseInt(data[i][j], 36);
            if(number[tmp]){
                sum += Math.pow(36, len - j - 1) * tmp;
                number[tmp] += (Math.pow(36, len - j - 1) * (35 - tmp));
            }
            else{
                sum += Math.pow(36, len - j - 1) * tmp;
                number[tmp] = (Math.pow(36, len - j - 1) * (35 - tmp));
            }
        }
    }

    for(let i = 0; i < K; i ++){
        let max = [0, 0];
        for(let j = 0; j < 36; j++){
            if(number[j] > max[1]){
                max[0] = j;
                max[1] = number[j]
            }
        }
        sum += max[1];
        number[max[0]] = 0;
    }
    console.log(sum.toString(36).toUpperCase());
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