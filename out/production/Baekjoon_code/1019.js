const solution = (input) => {
    let num = input
    let digit = [];
    let result = [0,0,0,0,0,0,0,0,0,0];
    for(let i = 10, j = 0;num != 0; i *= 10, j++){
        digit[j] = [num % i, j+1];
        num = num - digit[j][0]
    }
    digit.reverse();
    let first = true;
    let tmp = [];
    digit.forEach((el) => {

        for(let i = 0; i < (el[0] == 0? 0 : (el[0]/Math.pow(10, (el[1]-1)))); i++){
            if(el[1] == 1){
                result[i] += 1
                tmp.forEach(element =>{
                    result[element] += 1
                })
                if(first){
                    result[0] -= 1;
                    first = false;
                }
            }
            else if(i == 0 && first){
                let sub = '';
                for(let j = 0; j < el[1]-1; j++){
                    sub += '1'
                }
                result[0] += (el[1]-1) * Math.pow(10, (el[1]-2)) - (+sub)
                result[1] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[2] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[3] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[4] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[5] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[6] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[7] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[8] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[9] += (el[1]-1) * Math.pow(10, (el[1]-2))
                first = false;
            }
            else{
                result[0] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[1] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[2] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[3] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[4] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[5] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[6] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[7] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[8] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[9] += (el[1]-1) * Math.pow(10, (el[1]-2))
                result[i] += Math.pow(10, (el[1]-1))
                tmp.forEach(element =>{
                    result[element] += +(Math.pow(10, (el[1]-1)))
                })
            }
        }
        tmp.push(el[0]/Math.pow(10, (el[1]-1)))
    })
    tmp.forEach(element =>{
        result[element] += 1
    })
    console.log(result.join(' '))
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

solution(+input);