const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = input[0].replace(/\r/, "").split(' ').map(el=>+el);

const solution = (S, F, M) => {
    let prime_of_M = [];
    for(let i = 2; i <= M; i++){
        if(isPrime(i)){
            if( num_of_prime(S+F, i) - num_of_prime(S, i) - num_of_prime(F, i) != 0)
                prime_of_M.push([i, num_of_prime(S+F, i) - num_of_prime(S, i) - num_of_prime(F, i)]);
        }
    }
    while(M > 0){
        let tmp = M; // 50
        for(let i = 0; i < prime_of_M.length; i++){
            for(let j = 0; j < prime_of_M[i][1]; j++){
                if(tmp % prime_of_M[i][0] == 0){
                    tmp /= prime_of_M[i][0];
                }
            }
        }
        if(tmp == 1){
            console.log(M);
            return;
        }
        M--;
    }

    console.log(-1)
}

const isPrime = (num) => {
    for(let i = 2; num >= i*i; i++){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}

const num_of_prime = (nFactorial, primeNum) => {
    let cnt = 0; 
    let tmp = primeNum; 
    while((nFactorial / tmp) >= 1){
        cnt += Math.floor(nFactorial / tmp);
        tmp *= primeNum;
    }
    return cnt;
}

solution(N[0], N[1], N[2]);