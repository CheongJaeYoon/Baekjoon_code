#include <stdio.h>

int a_reward(int rate);
int b_reward(int rate);

int main() {
    int T;
    scanf("%d", &T);
    while(T--){
        int a, b;
        scanf("%d %d", &a, &b);
        printf("%d\n", a_reward(a) + b_reward(b));
    }
	return 0;
}

int a_reward(int rate){
    if(rate == 0 || rate > 21){
        return 0;
    }
    else if(rate <= 21 && rate > 15){
        return 10 * 10000;
    }
    else if(rate <= 15 && rate > 10){
        return 30 * 10000;
    }
    else if(rate <= 10 && rate > 6){
        return 50 * 10000;
    }
    else if(rate <= 6 && rate > 3){
        return 200 * 10000;
    }
    else if(rate <= 3 && rate > 1){
        return 300 * 10000;
    }
    else if(rate == 1){
        return 500 * 10000;
    }
    else{
        return -99999999;
    }
}

int b_reward(int rate){
    if(rate == 0 || rate > 31){
        return 0;
    }
    else if(rate <= 31 && rate > 15){
        return 32 * 10000;
    }
    else if(rate <= 15 && rate > 7){
        return 64 * 10000;
    }
    else if(rate <= 7 && rate > 3){
        return 128 * 10000;
    }
    else if(rate <= 3 && rate > 1){
        return 256 * 10000;
    }
    else if(rate == 1){
        return 512 * 10000;
    }
    else{
        return -99999999;
    }
}