const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].replace(/\r/, "").split(" ").map(el=>+el);
const N = num[0]
const M = num[1]
const poll = new Array(N+2);
const visit = new Array(N+2);
let group_cnt = 0;
let min = 9;
let group = [];
for(let i = 0; i < N+2; i++){
    poll[i] = new Array(M+2).fill(0);
    visit[i] = new Array(M+2).fill(0);
}

for(let i = 1; i <= N; i++){
    for(let j = 1; j <= M; j++){
        poll[i][j] = +input[i].replace(/\r/, "").split("")[j-1]
    }
}

const solution = () => {
    let result = 0;
    do {
        group_cnt = 0;
        let group_arr = []
        for(let i = 1; i <= N; i++){
            for(let j = 1; j <= M; j++){
                check = true;
                let tmp = func(i, j)
                if(tmp == true){
                    group_arr.push([group, min])
                    group_cnt++;
                    
                    min = 9;
                    group = [];
                }
                else{
                    min = 9;
                    group = [];
                }
            }
        }

        group_arr.forEach(element => {
            let min = element[1];
            element[0].forEach( el => {
                result += (min - poll[el[0]][el[1]])
                poll[el[0]][el[1]] = min;
                visit[el[0]][el[1]] = 0;
            })
        })

        for(let i = 0; i < N+2; i++){
            visit[i] = new Array(M+2).fill(0);
        }
    } while(group_cnt != 0)
    console.log(result);
}

const func = (x, y) => {
    if(visit[x][y] == 1){
        return "visited";
    }

    let dot = poll[x][y];
    const xin = [0, 1, 0, -1];
    const yin = [-1, 0, 1, 0];

    visit[x][y] = 1
    group.push([x, y])

    for(let i = 0; i< 4; i++){
        let tmp = poll[x+xin[i]][y+yin[i]];
        if(dot == tmp){
            if(func(x+xin[i], y+yin[i]) == false){
                check = false;
            }
        }
        if(dot > tmp){
            check = false;
        }
        if(dot < tmp){
            min = (min > tmp)? tmp :  min
        }
    }
    return check;
}

solution();