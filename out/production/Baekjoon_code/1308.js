const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const start = input[0].trim().split(" ").map(el => +el);
const end = input[1].trim().split(" ").map(el => +el);

const month_day = [31,28,31,30,31,30,31,31,30,31,30,31]
const solution = () => {
    if(count(end[0], end[1], end[2]) - count(start[0]+1000, start[1], start[2]) >= 0)
        console.log("gg")
    else
        console.log("D-" + (count(end[0], end[1], end[2]) - count(start[0], start[1], start[2])))

}

const count = (year, month, day) => {
    let result = 0;
    for(let i = 1; i < year; i++){
        result += (365 + check(i));
    }
    for(let i = 1; i < month; i++){
        if(i == 2)
            result += check(year)
        result += month_day[i-1];
    }
    result += day;
    return result;
}

const check = (year) => {
    if(year % 4 == 0){
        if(year % 100 == 0){
            if(year % 400 == 0){
                return 1;
            }
            return 0;
        }
        return 1;
    }
    return 0;
}

solution();