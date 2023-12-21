const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const S = num[1];
let data = input[1].trim().split(" ").map(el => +el);
let memory = new Array(8000000).fill(0);
let count = 0;

const solution = () => {
    mid = 5 >> 1
    left(0, mid, 0)
    memory
    right(mid, N, 0)
    if(S == 0){
        count--
    }
    console.log(count)
}

const left = (start, end, val) => {
    if(start == end){
        memory[4000000 + val] += 1;
    }
    else{
        left(start + 1, end, val);
        left(start + 1, end, val + data[start]);
    }
}
const right = (start, end, val) => {
    if(start == end){
        count += memory[4000000 + S - val];
    }
    else{
        right(start + 1, end, val);
        right(start + 1, end, val + data[start]);
    }
}


solution();