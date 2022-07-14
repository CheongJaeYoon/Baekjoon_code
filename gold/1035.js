// 시간초과 에러
// 점의 중점 방향으로만 이동하게 설계하면 될 것 같다.
// 점을 모을때 최소의 이동거리를 가지게 하기 위해서는 모든 점의 평균값이 아니라 중앙값을 구해야 한다.


const solution = () => {
    let start_bit = 0;
    totalnum = 0;
    let row = [];
    let col = [];
    for(let i = 0; i<5; i++){
        for(let j = 0; j<5; j++){
            if(data[i][j] == '*'){
                start_bit = start_bit | (1 << (i*5 + j));
                totalnum++;
                row.push( i )
                col.push( j )
            }
        }
    }
    goal[0] = row[(totalnum-1)/2];
    goal[1] = col[(totalnum-1)/2];
    func(start_bit, 0)
}

const func = (bit, count) => { //BFS로 구현
    let queue = [];
    queue.push( [bit, count] )

    while(queue.length != 0){
        let current_bit = queue[0][0];
        let current_count = queue.shift()[1];
        let row;
        let col;
        
        if(bitArr[current_bit] != -1){ //같은 경로가 있는 경우
            continue;
        }
        if(connect_all(current_bit)){ //모두 연결이 되었을 경우 정답 제출후 탐색 종료
            console.log(current_count);
            break;
        }
        for(let i = 0 ; i < 25; i++){
            if(current_bit & (1 << i)){
                row = Math.floor(i/5);
                col = i%5;
                let dr = goal[0] - row;
                let dc = goal[1] - col;
                if( dr < 0 && ( (row - 1) != -1) && ( (current_bit & (1 << (row - 1)*5+col)) == 0) ){ //상
                    queue.push( [ ( current_bit - (1<< i) + (1<< (row-1)*5+col) ) , current_count + 1 ] )
                }
                if( dr > 0 && ( (row + 1) != 5) && ( (current_bit & (1 << (row + 1)*5+col)) == 0) ){ //하
                    queue.push( [ ( current_bit - (1<< i) + (1<< (row+1)*5+col) ) , current_count + 1 ] )
                }
                if( dc < 0  && ( (col - 1) != -1) && ( (current_bit & (1 << row*5+(col - 1) )) == 0) ){ //좌
                    queue.push( [ ( current_bit - (1<< i) + (1<< row*5+(col-1)) ) , current_count + 1 ] )
                }
                if( dc > 0  && ( (col + 1) != 5) && ( (current_bit & (1 << row*5+(col + 1) )) == 0) ){ //우
                    queue.push( [ ( current_bit - (1<< i) + (1<< row*5+(col+1)) ) , current_count + 1 ] )
                }
            }
        }
        bitArr[current_bit] = current_count
    }
}
const connect_all = (bit) => {
    let visited = new Array(25).fill(0)
    let group = [];
    let count = 0;
    for(let i = 0 ; i < 25; i++){
        if(bit & (1 << i)){
            visited[i] = 1;
            group.push(i);
            count++;
            break;
        }
    }
    while(true){
        let check = true;
        while(group.length != 0){
            let row = Math.floor(group[0]/5);
            let col = group.shift()%5;
            if( ( (row - 1) != -1) && ( (bit & (1 << (row - 1)*5+col)) != 0) ){ //상
                if(!visited[(row - 1)*5+col]){
                    visited[(row - 1)*5+col] = 1;
                    group.push((row - 1)*5+col)
                    count++;
                    check = false;
                }
            }
            if( ( (row + 1) != 5) && ( (bit & (1 << (row + 1)*5+col)) != 0) ){ //하
                if(!visited[(row + 1)*5+col]){
                    visited[(row + 1)*5+col] = 1;
                    group.push((row + 1)*5+col)
                    count++;
                    check = false;
                }
            }
            if( ( (col - 1) != -1) && ( (bit & (1 << row*5+(col - 1) )) != 0) ){ //좌
                if(!visited[row*5+col -1]){
                    visited[row*5+col -1] = 1;
                    group.push(row*5+col -1)
                    count++;
                    check = false;
                }
            }
            if( ( (col + 1) != 5) && ( (bit & (1 << row*5+(col + 1) )) != 0) ){ //우
                if(!visited[row*5+col +1]){
                    visited[row*5+col +1] = 1;
                    group.push(row*5+col +1)
                    count++;
                    check = false;
                }
            }
        }
        if(check)
            break;
    }
    if(totalnum == count){
        return true;
    }
    else{
        return false;
    }
    
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');





const data = [];
for(let i = 0; i < 5 ; i++){
    data.push(input[i].split(''));
}



const bitArr = new Array(1 << 25).fill(-1);
let totalnum;
let goal = [0, 0];

solution();
