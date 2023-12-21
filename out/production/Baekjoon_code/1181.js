const solution = (N, data) => {
    data.sort(function(a, b){
        if(a.length == b.length){
            if(a < b)
                return -1
            else
                return 1
        }
        else{
            if(a.length < b.length)
                return  -1
            else
                return 1
        }
    })
    let tmp = "";
    for(let i = 0; i < N; i++){
        if(tmp != data[i])
            console.log(data[i])
            tmp = data[i];
    }
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 1; i < N + 1; i++){
    data.push(input[i]);
}

solution(N, data);