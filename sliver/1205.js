const solution = (N, t_score, K, data) => {
    let arr = [];
    for(let i = 0; i < N; i++){
        arr.push(data[i]);
    }
    arr.push(t_score);
    arr.sort(function(a, b){if(a>b) return -1;});
    for(let i = 0; i < N+1; i++){
        if(i < K){
            if(arr[i] == t_score){
                if(N >= K && arr[K] == t_score){
                    console.log(-1);
                    break;
                }
                console.log(i+1)
                break;
            }
        }
        else{
            console.log(-1)
            break;
        }
    }
}


const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let N = input[0].split(' ').map((el) => +el);
let data = [];
if(N[0] != 0){
    data = input[1].split(' ').map((el) => +el);
}

solution(N[0],N[1],N[2], data);