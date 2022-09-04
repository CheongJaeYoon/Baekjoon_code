//최소비용 -> 최대비용으로 탐색
//사용한 비용 > 게이머의 비용이면 탐색종료
//현재시점에서 가장 레벨이 높은 유닛부터 생산(N 유닛 제외)

const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
for(let i = 1; i < N+1; i++){
    data.push(input[i].replace(/\r/, "").split(' ').map(el=> +el))
}

let player_cost = data[0][0];
let player_time = data[0][1];
let unit_cost = new Array(N);
let unit_time = new Array(N);

let result = 0;

for(let i = 1; i<N; i++){
    unit_cost[i] = data[i][0];
    unit_time[i] = data[i][1];
}

const solution = (N, data) => {

    let num_of_cur_unit = new Array(N+1).fill(0);
    num_of_cur_unit[1] = 1;


    dfs(0, 0, num_of_cur_unit, [])
    console.log(result)
}

const dfs = (cur_time,used_cost, num_of_unit, working_unit) => {
    console.log(cur_time,used_cost, num_of_unit, working_unit)
    console.log("1", used_cost, player_cost)
    if(used_cost > player_cost){
        return;
    }

    console.log("2", cur_time, player_time)
    if(cur_time == player_time){
        let num_of_unit_N = num_of_unit[N];
        result = Math.max(num_of_unit_N, result);
        return;
    }

    for(let i = 0; working_unit[i] != undefined; i++){
        let unit_level = working_unit[i][0]
        let left_time = working_unit[i][1]
        if(left_time == 1){
            num_of_unit[unit_level]++;
            working_unit.splice(i, 1);
            i--;
        }
        else{
            working_unit[i][1]--;
        }
    }
    if(num_of_unit[N] != 0 || working_unit){
        dfs(cur_time+1, used_cost, num_of_unit, working_unit)
    }
    let sum = 0;
    for(let i = N-1; i > 0; i--){
        if(num_of_unit[i] != 0 ){
            while(num_of_unit[i] != 0){
                working_unit.push([i, unit_time[i]])
                sum += unit_cost[i];
                num_of_unit[i]--;
                dfs(cur_time+1, used_cost + sum, num_of_unit, working_unit);
            }
        }
    }
}


solution(N, data);