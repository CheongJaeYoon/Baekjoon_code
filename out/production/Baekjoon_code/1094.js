const solution = (N) => {
    let inventory = [64];
    while(true){
        let sum = 0;
        inventory.forEach( (el) => {
            sum += el;
        })
        if(sum > N){
            let tmp = inventory.pop();
            tmp = tmp / 2;
            inventory.push(tmp);

            let sub_sum = 0;
            inventory.forEach( (el) => {
                sub_sum += el;
            })
            if(sub_sum < N){
                inventory.push(tmp);
            }
        }
        if(sum == N)
            break;
    }
    console.log(inventory.length)
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];

solution(N);