const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const data = input[0].trim().split("");
const solution = () => {
    let str = [];
    let tmp = "";
    let idx = 0;
    let rock = false;
    let cnt = [1,0]
    for(let i = 0; i < data.length; i++){
        if(data[i] != '+' && data[i] != '-' && data[i] != '*' && data[i] != '/' && data[i] != '(' && data[i] != ')'){
             tmp += data[i];
             cnt[0] = 0;
        }
        else{
            if(data[i] == '+' || data[i] == '-' || data[i] == '*' || data[i] == '/'){
                cnt[0]++;
                if(cnt[0] == 2)
                    rock = true;
            }
            if(data[i] == '('){
                cnt[1]++
            }
            if(data[i] == ')'){
                cnt[1]--
            }
            if(tmp.length == 0){
                str[idx] = data[i];
                idx++;
            }
            else{
                str[idx] = tmp;
                idx++;
                tmp = "";
                str[idx] = data[i];
                idx++;
            }
            if(cnt[1] < 0)
                rock = true;
        }
    }
    if(tmp.length != 0){
        str[idx] = tmp;
    }
    if(cnt[1] != 0)
        rock = true;
    if(cnt[0] == 1)
        rock = true;


    if(rock == true){
        console.log("ROCK")
        return;
    }

    let arr = [];
    arr[0] = new Array();
    let arr_i = 0;
    let arr_j = 1;
    let stack_i = [];
    let next_arr_i = 0;
    stack_i.push(0)
    for(let i = 0; i < str.length; i++){
        if(str[i] == '('){
            next_arr_i++;
            stack_i.push(next_arr_i)
            arr[arr_i][arr_j] = "X" + (next_arr_i);
            arr[next_arr_i] = new Array();
            arr_i = next_arr_i;
            arr_j = 1;
        }
        else if(str[i] == ')'){
            stack_i.pop();
            arr_i = stack_i[stack_i.length - 1];
            arr_j = arr[arr_i].length
        }
        else{
            if(str[i] != '+' && str[i] != '-' && str[i] != '*' && str[i] != '/')
                arr[arr_i][arr_j] = BigInt(str[i]);
            else
                arr[arr_i][arr_j] = str[i];
            arr_j++;
        }
    }
    for(let i = arr.length - 1; i>=0; i--){
        for(let j = 0; j < arr[i].length;j++){
            if(typeof(arr[i][j]) == 'string' && arr[i][j].slice(0, 1) == 'X')
                arr[i][j] = arr[arr[i][j].slice(1, arr[i][j].length)][0]
        }
        let first = [];
        let first_idx = 0;
        for(let j = 1; j < arr[i].length;j++){
            if(arr[i][j] == '*'){
                first[first_idx - 1] = first[first_idx - 1] * arr[i][j+1]
                first_idx--;
                j = j + 2;
            }
            else if(arr[i][j] == '/'){
                first[first_idx - 1] = first[first_idx - 1] / arr[i][j+1]
                first_idx--;
                j = j + 2;
            }
            else{
                first[first_idx] = arr[i][j];
                first_idx++;
            }
        }
        let second = [];
        let second_idx = 0;
        for(let j = 0; j < first.length;j++){
            if(first[j] == '+'){
                second[second_idx - 1] = second[second_idx - 1] + first[j+1]
                second_idx--;
                j = j + 2;
            }
            else if(first[j] == '-'){
                second[second_idx - 1] = second[second_idx - 1] - first[j+1]
                second_idx--;
                j = j + 2;
            }
            else{
                second[second_idx] = first[j];
                second_idx++;

            }
        }
        arr[i][0] = second[0]
    }
    console.log(arr[0][0].toString())
}


solution();