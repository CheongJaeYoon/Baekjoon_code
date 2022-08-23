const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const num = input[1].trim().split(" ").map(el => +el);
const primeNum = new Array(1001).fill(true);

const solution = () => {
    primeNum[0] = false;
    primeNum[1] = false;
    for(let i = 2; i < 1001; i++){
        if(primeNum[i] == true){
            for(let j = i*2; j < 1001; j += i){
                primeNum[j] = false;
            }
        }
    }
    let cnt = 0;
    for(let i = 0; i < N; i++){
        if(primeNum[num[i]] == true)
            cnt++;
    }
    console.log(cnt)
}

solution();