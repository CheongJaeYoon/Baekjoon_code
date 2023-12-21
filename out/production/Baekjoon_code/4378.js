const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString();

const qwerty = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
const str = input;
let result = "";
let index;
for(let i = 0; i < str.length; i++){
    index = qwerty.indexOf(str[i])
    if(index >= 0){
        result += qwerty[index - 1]
    }
    else{
        result += str[i]
    }
}
console.log(result)
