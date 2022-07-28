const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0]
let data = input[1].trim().split(" ").map(el => +el);

const solution = () => {
    let all = [];
    let shelter = [];
    let start_pos = 0;
    let min, max;

    all.push([[-data[0], data[0]], data[0], 1])
    min = -data[0];
    max = data[0]
    shelter.push([0, data[0]])

    for(let i = 1; i < N; i++){
        let x = start_pos;
        let y = start_pos + data[i];
        let breaker = false;
        for(let j = 0;j < data[i]; j++){
            for(let n = 0; n < shelter.length; n++){
                let s_x = shelter[n][0];
                let s_y = shelter[n][1];
                if( ((x - j) == s_x && (y - j) == s_y) || ((x - j) < s_x && (y - j) == s_y) || ((x - j) == s_x && (y - j) < s_y) ){
                    if((y - j) + data[i] > shelter[0][1]){
                        shelter = [];
                        shelter.push([(x - j) + data[i], (y - j) + data[i]])
                        all.push([[(x - j)*2 + data[i], (x - j)*2 + data[i]*3], data[i], i+1])
                        min = (((x - j)*2 + data[i]) < min )? ((x - j)*2 + data[i]) : min;
                        max = (((x - j)*2 + data[i]*3) > max )? ((x - j)*2 + data[i]*3) : max;
                        start_pos = (x - j) + data[i]
                    }
                    else{
                        shelter.push([(x - j) + data[i], (y - j) + data[i]])
                        all.push([[(x - j)*2 + data[i], (x - j)*2 + data[i]*3], data[i], i+1])
                        min = (((x - j)*2 + data[i]) < min )? ((x - j)*2 + data[i]) : min;
                        max = (((x - j)*2 + data[i]*3) > max )? ((x - j)*2 + data[i]*3) : max;
                        start_pos = (x - j) + data[i]
                    }

                    breaker = true;
                    break;

                }
            }
            if(breaker)
                break;
        }
    }
    all.sort(function(a, b){return b[1] - a[1]})
    let result = [];

    for(let i = min + 0.5; i < max; i++){
        for(let j = 0; j < all.length; j++){
            if(all[j][0][0] < i && all[j][0][1] > i){
                if(result.indexOf(all[j][2])<0){
                    result.push(all[j][2])
                }
                break;
            }
        }
    }
    console.log(result.join(" "))
}


solution();