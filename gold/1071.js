const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const data = input[1].replace(/\r/, "").split(' ').map(el=>+el);

const solution = (N, data) => {
    let result = [];
    let sortArr = [];
    data.sort(function(a, b){return a-b});
    let tmp;
    for(let i = 0; i < N; i++){
        if(tmp != data[i]){
            tmp = data[i];
            sortArr.push([tmp, 1])
        }
        else{
            sortArr[sortArr.length - 1][1]++;
        }
    }
    while(sortArr.length != 0){
        if(sortArr.length == 1){
            for(let i = 0; i < sortArr[0][1]; i++){
                result.push(sortArr[0][0]);
            }
            sortArr = [];
        }
        else if(sortArr.length == 2){
            let last_val = result[result.length - 1];
            if(last_val + 1 == sortArr[0][0]){
                result.push(sortArr[1][0]);
                sortArr[1][1]--;
                if(sortArr[1][1] == 0)
                    sortArr.splice(1, 1);
            }
            else if(sortArr[0][0] + 1 == sortArr[1][0]){
                for(let i = 0; i < sortArr[1][1]; i++){
                    result.push(sortArr[1][0]);
                }
                for(let i = 0; i < sortArr[0][1]; i++){
                    result.push(sortArr[0][0]);
                }
                sortArr = [];
            }
            else{
                for(let i = 0; i < sortArr[0][1]; i++){
                    result.push(sortArr[0][0]);
                }
                for(let i = 0; i < sortArr[1][1]; i++){
                    result.push(sortArr[1][0]);
                }
                sortArr = [];
            }

        }
        else{
            if(!result){
                result.push(sortArr[0][0]);
                sortArr[0][1]--;
                if(sortArr[0][1] == 0)
                    sortArr.shift();
            }
            else{
                let last_val = result[result.length - 1];
                if(last_val + 1 == sortArr[0][0]){
                    result.push(sortArr[1][0]);
                    sortArr[1][1]--;
                    if(sortArr[1][1] == 0)
                        sortArr.splice(1, 1);
                }
                else{
                    result.push(sortArr[0][0]);
                    sortArr[0][1]--;
                    if(sortArr[0][1] == 0)
                        sortArr.shift();

                }

            }
        }
    }
    console.log(result.join(" "))
}

solution(N, data);