const solution = (N, data) => {
    let num = "";
    let max = -1;
    for(let i = 0; i < N[0]; i++){
        for(let j = 0; j < N[1]; j++){
            for(let n = 0; n < N[0]; n++){
                for(let m = 0; m < N[1]; m++){
                    let ri = n - i; //row increase
                    let ci = m - j; //column increase
                    if(ri == 0 && ci == 0){
                        num = num + data[i][j];
                        max = max < func(+num) ? func(+num) : max;
                    }
                    else{
                        num = num + data[i][j];
                        for(let t = 1; data[i + ri*t] != undefined && data[i + ri*t][j + ci*t] != undefined; t++){
                            num = num + data[i + ri*t][j + ci*t];
                            max = max < func(+num) ? func(+num) : max;
                        }
                    }
                    num = ""
                }
            }
        }
    }
    console.log(max)
}

const func = (num) => {
    for(let i = 0; i*i <= num; i++){
        if(i*i == num)
            return i*i
    }
    return -1
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = input[0].split(' ').map((el) => +el);
const data = [];
for(let i = 1; i < N[0] + 1; i++){
    data.push(input[i].split('').map((el) => +el));
}

solution(N, data);