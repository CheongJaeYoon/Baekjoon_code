const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = input[0].split(' ').map((el) => +el);
const data = [];
for(let i = 1; i < N[0]+1; i++){
    data.push(input[i].split(' '))
}
for(let i = N[0]+1; i < N[0]+N[1]+1; i++){
    data.push(input[i].replace(/\r/, "").split('='))
}


const solution = (N, M, data1, data2) => {
    let item = {};
    let recipe = [];
    for(let i = 0; i < N; i++){
        let name = data1[i][0];
        let cost = +data1[i][1];

        if(item[name] == undefined){
            item[name] = cost
        }
        else{
            if(item[name] > cost)
                item[name] = cost;
        }
    }

    for(let i = 0; i < M; i++){
        let name = data2[i][0]
        let tmp = data2[i][1].split("+")
        let tmp2 = []
        for(let j = 0; j < tmp.length; j++){
            tmp2.push([+tmp[j][0], tmp[j].slice(-tmp[j].length+1)])
        }
        recipe.push([name, tmp2]);
    }

    while(true){
        let check = true;

        for(let i = 0 ; !!recipe[i]; i++){
            let comb = recipe[i][1];
            let sum = 0;
            for(let j = 0; j < comb.length; j++){

                if(item[comb[j][1]] == undefined){
                    sum = -1;
                    break;
                }
                else{
                    sum += comb[j][0] * item[comb[j][1]];
                }
            }
            if(sum != -1){
                let name = recipe[i][0]
                if(item[name] == undefined){
                    item[name] = sum
                    check = false;
                }
                else{
                    if(item[name] > sum){
                        item[name] = sum;
                        check = false;
                    }
                }
            }
        }

        if(check)
            break;
    }
    if(item.LOVE == undefined){
        console.log(-1)
        return;
    }
    if(item.LOVE > 1000000000){
        console.log(1000000001)
        return;
    }
    console.log(item.LOVE)

}


solution(N[0], N[1], data.slice(0, N[0]), data.slice(N[0], N[0]+N[1]));