// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&problemLevel=5&contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=5&pageSize=10&pageIndex=1

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
      int num;
      scanf("%d", &num);
      int * scores = (int *)malloc(sizeof(int) * num);
      int sum = 0;
      for(int j=0; j<num; j++){
        scanf("%d", scores+j);
        sum += scores[j];
      }
      
      

      // printf("#%d %d\n", i+1, num);
      free(scores);
    }

    return 0;
}