const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = +input[0];
let data = [];
for(let i = 0; i < num; i++){
    data.push(input[i+1].trim())
}
let alphabet = new Map();

const solution = () => {
    let result = num;
    for(let i = 0; i < num; i++){
        let last = data[i][0];
        alphabet.set(last, true);
        for(let j = 0; j < data[i].length; j++){
            if(last != data[i][j]){
                if(alphabet.has(data[i][j])){
                    result--;
                    break;
                }
                else{
                    last = data[i][j];
                    alphabet.set(last, true);
                }
            }
        }
        alphabet.clear();
    }
    console.log(result)
}

solution();