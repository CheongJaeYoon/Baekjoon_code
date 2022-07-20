const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
const data = [];
let str_len = 0;
for(let i = 1; i < N+1; i++){
    data.push(input[i].replace(/\r/, ""))
    str_len += data[i-1].length;
}
const K = +input[N+1]

let count = 0;
let string = ""
let arr = [];
for(let i = 0; i< N; i++){
    arr.push(i);
}

const solution = () => {
    if(str_len%K != 0){
        console.log(0);
        return;
    }
    func(0, 0);
    console.log(count);
}

const func = (n, len) => {
    if(n == N){
        if(step1(string, str_len, K)){
            count++;
        }
        return;
    }

    for(let i = 0; i< arr.length; i++){
        let tmp = arr[i];
        cur_len = data[tmp].length
        
        arr.splice(i, 1);
        string = string + data[tmp]

        func(n+1, len + cur_len);
        
        arr.splice(i, 0, tmp);
        string = string.slice(0, len)
    }
}

const step1 = (str, len, K) => {
    let tmp = str.slice(0, len/K)
    let cnt = 0;
    for(let i = len/K; i < len; i += len/K){
        if(tmp != str.slice(i, i+len/K)){
            cnt++;
            break;
        }
    }
    if(cnt == 0){
        if(step2(tmp, tmp.length))
            return true;
    }
    return false;
}

const step2 = (str, len) => {
    for(let i = 1; i<= len/2; i++){
        if(len %i == 0){ // len의 약수만
            let cnt = 0;
            let tmp = str.slice(0, i);
            for(let j = i; j < len; j += i){
                if(tmp != str.slice(j, j+i)){
                    cnt++;
                    break;
                }
            }
            if(cnt == 0){
                return false;
            }
        }
    }
    return true;
}
solution();