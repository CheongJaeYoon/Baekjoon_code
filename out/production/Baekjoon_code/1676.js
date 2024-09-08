const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = +input[0];
console.log(Math.floor(num/5) + Math.floor(num/25) + Math.floor(num/125))