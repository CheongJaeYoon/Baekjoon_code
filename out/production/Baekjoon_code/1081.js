const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = input[0].replace(/\r/, "").split(' ');

const sum_0_to_ = [0, 1, 3, 6, 10, 15, 21, 28, 36, 45];

const solution = (num1, num2) => {
    console.log(func(num2) - func(""+(+num1-1)))
}

const func = (num) => {
    if(num == '-1')
    return 0;
    let result = 0;
    let len = num.length
    for(let i = 0,n = len-1; i < len; i++, n--){
        let sum = 0;
        for(let j = 0; j < i; j++){
            sum += +num[j];
        }
        if(!(+num[i]))
            continue;
        result += (+num[i])*sum_0_to_[9]*(n * Math.pow(10, n-1))
        result += sum_0_to_[(+num[i]) - 1] * Math.pow(10, n)
        result += sum*(+num[i])*Math.pow(10, n)
    }
    for(let i =0; i < len; i++){
        result += +num[i]
    }
    return result;

}

solution(N[0], N[1]);