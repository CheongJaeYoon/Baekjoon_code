const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0]

let arr = [];
let result_arr = [];

for(let i = 0; i < N; i++){
    arr[i] = i+1;
}


const solution = () => {
    let trigger = true;
    while(arr.length != 0){
        if(trigger){
            result_arr.push(arr.shift());
        }
        else{
            arr.push(arr.shift());
        }
        trigger = !trigger;
    }
    console.log(result_arr.join(" "))
}


solution();