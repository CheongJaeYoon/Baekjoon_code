const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0]
let arr = [];
for(let i = 1; i <= N; i++){
    arr.push(input[i].trim().split(" ").map(el => +el))
}
const solution = () => {
    for(let i = 0;i < N;i++){ //row
        let min = 10001;
        for(let j = 0; j < N; j++){
            min = min > arr[i][j] ? arr[i][j] : min;
        }
        for(let j = 0; j < N; j++){
            arr[i][j]-= min
        }
    }
    for(let i = 0;i < N;i++){ //col
        let min = 10001;
        for(let j = 0; j < N; j++){
            min = min > arr[j][i] ? arr[j][i] : min;
        }
        for(let j = 0; j < N; j++){
            arr[j][i]-= min
        }
    }
    let zeroArr = [];
    for(let i = 0;i < N;i++){ //row
        let cnt = 0;
        for(let j = 0; j < N; j++){
            if(arr[i][j] == 0)
                cnt++
        }
        zeroArr.push(['r', i, cnt]);
    }
    for(let i = 0;i < N;i++){ //col
        let cnt = 0;
        for(let j = 0; j < N; j++){
            if(arr[j][i] == 0)
                cnt++
        }
        zeroArr.push(['c', i, cnt]);
    }
    zeroArr.sort(function(a, b){return b[2] - a[2]})
    let row = new Array(N).fill(1);
    let col = new Array(N).fill(1);
    for(let n = 0; n < N; n++){
        if(zeroArr[n][0] == 'r')
            row[zeroArr[n][1]] = 0;
        else
            col[zeroArr[n][1]] = 0;
            
        let cnt = 0;
        for(let i = 0; i < N; i++){
            for(let j = 0; j < N; j++){
                if(row[i] == 1 && col[j] == 1){
                    if(arr[i][j] == 0)
                        cnt++;
                }
            }
        }
        if(cnt == 0){
        }
    }
    
}


solution();