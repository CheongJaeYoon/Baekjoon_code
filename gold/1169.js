const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0]
let data = input[1].trim().split(" ").map(el => +el);

const solution = () => {
    let result = [];

    let shelter = [];
    let start_pos = 0;
    for(let i = 0; i < N; i++){
        let cur_block = data[i];
        if(shelter.length == 0){
            shelter.push(cur_block);
            result.push(i+1);
        }
        else{
            let tmp = shelter[shelter.length - 1];
            let minus_value = 0;
            if(cur_block <= tmp){
                if(start_pos + cur_block*2 > shelter[0]){
                    shelter = [];
                    shelter.push(cur_block);
                    result.push(i + 1);
                }
                else{
                    start_pos += cur_block;
                    shelter.push(cur_block);
                }
            }
            for(let j = shelter.length - 1; j >= 0; j--){
                tmp += shelter[j];
                if(cur_block <= tmp){
                    break;
                }
            }

        }
    }

    console.log(result.join(" "));
}


solution();