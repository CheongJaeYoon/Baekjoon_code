const solution = (N, data) => {
    if(N == 1){
        let sum = 0;
        data.forEach( (el) =>{
            sum += el;
        })
        sum -=Math.max(...data)
        console.log(sum);
        return;
    }
    let minside = []
    let setting = [[[0], [1], [2], [3], [4], [5]], 
                  [[0, 1], [0, 2], [0, 3], [0, 4], [1, 2], [2, 4], [4, 3], [3, 1], [5, 1], [5, 2], [5, 3], [5, 4]],
                  [[0, 1, 2], [0, 1, 3], [0, 3, 4], [0, 4, 2], [5, 1, 2], [5, 1, 3], [5, 3, 4], [5, 4, 2]]]
    // 1면 A, B, C, D, E, F 면
    //     0, 1, 2, 3, 4, 5
    // 2면 AB, AC, AD, AE, BC, CE, ED, DB, FB, FC, FD, FE 모서리
    //     01, 02, 03, 04, 12, 24, 43, 31, 51, 52, 53, 54
    // 3면 ABC, ABD, ADE, AEC, FBC, FBD, FDE, FEC 꼭짓점
    //     012, 013, 034, 042, 512, 513, 534, 542

    minside[0] = data[0];
    minside[1] = data[0] + data[1];
    minside[2] = data[0] + data[1] + data[2];

    for(let i = 0; i< 3; i++){
        setting[i].forEach( (el) => {
            let sum = 0;
            for(let j = 0; j <= i; j++){
                sum += data[el[j]];
            }
            minside[i] = minside[i] > sum ? sum : minside[i];
        })
    }
    console.log(4*minside[2] + 4*(N-1)*minside[1] + 4*(N-2)*minside[1] + (N-2)*(N-2)*minside[0] + 4*(N-2)*(N-1)*minside[0])
}


const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
const data = input[1].split(' ').map((el) => +el);

solution(N, data);