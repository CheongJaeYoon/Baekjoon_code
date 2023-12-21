const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].trim().split(" ").map(el => +el);
const N = num[0];
const Q = num[1];

let arr = input[1].trim().split(" ").map(el => +el);

const data = [];
for(let i = 0; i < Q; i++){
    data.push(input[i+2].trim().split(" ").map(el => +el))
}


let tree = [];
const solution = () => {
    let result = "";
    make_tree(1, 1, N);
    for(let i = 0; i < Q; i++){
        let x, y, a, b;
        x = data[i][0];
        y = data[i][1];
        a = data[i][2];
        b = data[i][3];
        if(x > y){
            let tmp = x;
            x = y;
            y = tmp;
        }
        result += "" + sum(1, 1, N, x, y);
        trans(1, a, 1, N, b - arr[a-1])
        arr[a-1] = b
        if(i != Q-1)
            result += "\n"
    }
    console.log(result)
}

const make_tree = (node, start, end) => {
    if(start == end)
        return tree[node] = arr[start - 1];
    else
        return tree[node] = make_tree(node*2, start, Math.floor((start + end) / 2)) + make_tree(node*2 + 1, Math.floor((start + end) / 2) + 1, end)
}
const sum = (node, start, end, x, y) => {
    if(x > end || y < start)
        return 0;
    if( x <= start && end <= y)
        return tree[node]
    return sum(node*2, start, Math.floor((start + end) / 2), x, y) + sum(node*2 + 1, (Math.floor((start + end) / 2)) + 1, end, x, y)
}
const trans = (node,index, start, end, diff) => {
    if(index > end || index < start)
        return 0;
    tree[node] += diff;
    if(start != end){
        trans(node*2,index, start, Math.floor((start + end) / 2), diff)
        trans(node*2 + 1,index, (Math.floor((start + end) / 2)) + 1, end, diff)
    }

}

solution();