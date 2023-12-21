
const solution = () => {
    max_count = 1;
    func(0, 1, 0); // 1번은 방문한 상태이다.
    console.log(max_count);
}

const func = (idx, bit, cost) => {
    if(breaker)
        return;
    if(dp[idx][bit] == 1) // 중복 제거;
        return;
    let search = 0;
    for(let i = 0; i< N; i++){
        if(bit & (1 << i)) //이미 방문한 곳 제외;
            continue;
        if( cost <= data[idx][i] ){
            dp[idx][bit] = 1;
            func(i, bit | (1 << i ), data[idx][i])
            search++;
        }
    }
    if(search  == 0){
        let count = counting(bit)
        if(count == N){
            breaker = true;
        }
        if(count > max_count)
            max_count = count
    }
}

const counting = (bin) => {
    let count = 0;
    while(bin != 0){
        count += bin & 1;
        bin >>= 1;
    }
    return count;
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');



const N = +input[0];
const data = [];
for(let i = 1; i < N + 1; i++){
    data.push(input[i].split('').map((el) => +el));
}

let max_count;
let dp = new Array(N)
for(let i = 0; i < N; i++){
    dp[i] = new Array(1<<N).fill(-1);
}
let breaker = false;


solution();
