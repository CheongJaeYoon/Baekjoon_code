const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const r = num[1] + 1;
const c = num[2] + 1;
const solution = () => {
    let leftTop = 0;
    let row = Math.pow(2, N-1);
    let col = Math.pow(2, N-1);
    for(let i = Math.pow(2, N-1); i >= 1; i /= 2){
        if(r <= row && c <= col){
            row -= i/2;
            col -= i/2;
            leftTop += 0;
        }
        else if(r <= row && c > col){
            row -= i/2;
            col += i/2;
            leftTop += i*i
        }
        else if(r > row && c <= col){
            row += i/2;
            col -= i/2;
            leftTop += i*i*2
        }
        else if(r > row && c > col){
            row += i/2;
            col += i/2;
            leftTop += i*i*3
        }
    }
    console.log(leftTop)
}


solution();