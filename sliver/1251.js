const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const data = input[0];

const solution = () => {
    let N = data.length;
    let result;
    let first = true;
    for(let i = 1 ; i < N; i++){
        for(let j = i+1; j < N; j++){
            let fir = data.slice(0, i).split('').reverse().join("");
            let sec = data.slice(i, j).split('').reverse().join("");
            let thr = data.slice(j, N).split('').reverse().join("");
            let tmp = fir+sec+thr;
            if(first == true){
                result = tmp;
                first = false;
            }
            if(result > tmp)
                result = tmp;
        }
    }
    console.log(result)
}

solution();