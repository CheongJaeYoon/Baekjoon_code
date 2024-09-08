const solution = (data) => {
    func(data[0][0], data[0][1])
}

const func = (min, max) => {
    squareNumArr = primeSquare( Math.floor( Math.sqrt(max) ) );
    let NumArr = [];
    squareNumArr.forEach((el) => {
        let start = Math.ceil(min/el)
        let end = Math.floor(max/el)
        for(let i = start; i <= end; i++){
            NumArr[i*el] = 1;
        }
    });
    let result = 0;
    for(let j = min; j <= max; j++){
        if(!NumArr[j]){
            result++;
        }
    }
    console.log(result);
}

const primeSquare = (num) =>{
    let primeSquareArr = [];
    for(let i = 2; i <= num; i++){
        let isPrime = true;
        for(let j = 2; j*j <= i; j++){
            if(i%j == 0)
                isPrime = false;
        }
        if(isPrime)
            primeSquareArr.push(i*i)
    }
    return primeSquareArr;
}
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const data = [];
data.push(input[0].split(' ').map((el) => +el));


solution(data);