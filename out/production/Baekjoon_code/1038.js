//let count = 0;
//let number = [];

const solution = () => {
    for(let i = 0; i <= 10; i++){
        recur_func(10,i);
        if(breaker)
            return;
    }
    if(!breaker){
        console.log(-1)
    }
}


let count = 0;
let number = [];
let breaker = false
const recur_func = (n, i) => { // n 앞자리 수, i 현재 자리수
    if(breaker)
        return;
    for(let j = 0; j < 10; j++){
        if(n>j){
            number[i] = j;
            if(i == 0){
                if(+input == count){
                    console.log(number.reverse().join(''))
                    breaker = true;
                    break;
                }
                count++;
            }
            else{
                recur_func(j, i-1);
            }
        }
        else{
            break;
        }
    }
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

solution();