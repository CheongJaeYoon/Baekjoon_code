const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].replace(/\r/, "").split(" ").map(el=>+el);
const L = num[0]
const K = num[1]
const C = num[2]
const data = input[1].replace(/\r/, "").split(" ").map(el=>+el);
let len = [];
let pos = [...new Set(data)].sort(function(a, b){return a-b});

const solution = () => {
    len[0] = pos[0]
    for(let i = 1; i < pos.length; i++){
        len[i] = pos[i] - pos[i-1];
    }
    len[pos.length] = L - pos[pos.length-1]
    //binary search 시작

    let min = 1; 
    let max = L;
    let result = [];
    while(min <= max){
        let avg = (max + min) >> 1;
        let tmp = func(avg)
        if(tmp){
            max = avg - 1
            result[0] = avg;
            result[1] = tmp;
        }
        else {
            min = avg + 1;
        }
    }
    console.log(result.join(" "))
}
const func = (size) => {
    let total = 0;
    let cnt = C;
    for(let i = len.length - 1; i >= 0; i--){
        if(len[i] > size)
            return false;
        total += len[i]
        if(total > size){
            total = len[i];
            cnt--;
        }
        if(cnt == 0){
            if(pos[i] > size)
                return false;
            else
                return pos[i];
        }
    }
    
    if(cnt > 0)
        return pos[0];

    console.log("ERROR")
}

solution();