#include <stdio.h>
// #include <stdlib.h>

const int MAX_POWER = 3000000;

int main(void) {
  int test_case;
  int T;
  setbuf(stdout, NULL);
  scanf("%d", &T);
  for (test_case = 1; test_case <= T; ++test_case) {
    int power[3];
    int m, max, max_idx;
    int result = 0;
    int myStore[3][50][3] = {0};
    int len[3] = {0, 0, 0};
    scanf("%d", &m);
    for (int j = 0; j < m; j++) {
      max = 0;
      max_idx = 0;
      for (int k = 0; k < 3; k++) {
        scanf("%d", power + k);
        if (max < power[k]) {
          max = power[k];
          max_idx = k;
        }
      }

      for (int k = 0; k < 3; k++) {
        myStore[max_idx][len[max_idx]][k] = power[k];
      }
      len[max_idx]++;
    }

    if (m < 3) {
      printf("#%d -1\n", test_case);
      continue;
    }

    for (int idx = 0; idx < len[0]; idx++) {
      result += myStore[0][idx][1] + myStore[0][idx][2];
    }
    for (int idx = 0; idx < len[1]; idx++) {
      result += myStore[1][idx][0] + myStore[1][idx][2];
    }
    for (int idx = 0; idx < len[2]; idx++) {
      result += myStore[2][idx][0] + myStore[2][idx][1];
    }

    if (len[0] == 0) {
      if (len[1] == 0) { // a와 b 능력자가 선택되지 않음
        int a_idx = 0, b_idx = 0;
        int a = MAX_POWER, b = MAX_POWER;
        for (int idx = 0; idx < len[2]; idx++) {
          if (myStore[2][idx][2] - myStore[2][idx][0] < a) {
            a = myStore[2][idx][2] - myStore[2][idx][0];
            a_idx = idx;
          }
          if (myStore[2][idx][2] - myStore[2][idx][1] < b) {
            b = myStore[2][idx][2] - myStore[2][idx][1];
            b_idx = idx;
          }
        }

        if (a_idx == b_idx) { // 하필 같은 행...
          int tmp_idx = a_idx;
          int tmp_a = a, tmp_b = b;
          a = MAX_POWER, b = MAX_POWER;

          for (int idx = 0; idx < len[2]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[2][idx][2] - myStore[2][idx][0] < a) {
              a = myStore[2][idx][2] - myStore[2][idx][0];
            }
            if (myStore[2][idx][2] - myStore[2][idx][1] < b) {
              b = myStore[2][idx][2] - myStore[2][idx][1];
            }
          }
          if (tmp_a + b >= tmp_b + a) {
            result += tmp_b + a;
          } else {
            result += tmp_a + b;
          }

        } else if (a >= b) { // b를 선택
          result += b;
          int tmp_idx = b_idx;
          a = MAX_POWER;

          for (int idx = 0; idx < len[2]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[2][idx][2] - myStore[2][idx][0] < a) {
              a = myStore[2][idx][2] - myStore[2][idx][0];
            }
          }
          result += a;
        } else { // a를 선택
          result += a;

          int tmp_idx = a_idx;
          b = MAX_POWER;

          for (int idx = 0; idx < len[2]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[2][idx][2] - myStore[2][idx][1] < b) {
              b = myStore[2][idx][2] - myStore[2][idx][1];
            }
          }
          result += b;
        }
      } else if (len[2] == 0) { // a와 c 능력자가 선택되지 않음
        int a_idx = 0, c_idx = 0;
        int a = MAX_POWER, c = MAX_POWER;
        for (int idx = 0; idx < len[1]; idx++) {
          if (myStore[1][idx][1] - myStore[1][idx][0] < a) {
            a = myStore[1][idx][1] - myStore[1][idx][0];
            a_idx = idx;
          }
          if (myStore[1][idx][1] - myStore[1][idx][2] < c) {
            c = myStore[1][idx][1] - myStore[1][idx][2];
            c_idx = idx;
          }
        }

        if (a_idx == c_idx) { // 하필 같은 행...
          int tmp_idx = a_idx;
          int tmp_a = a, tmp_c = c;
          a = MAX_POWER, c = MAX_POWER;

          for (int idx = 0; idx < len[1]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[1][idx][1] - myStore[1][idx][0] < a) {
              a = myStore[1][idx][1] - myStore[1][idx][0];
            }
            if (myStore[1][idx][1] - myStore[1][idx][2] < c) {
              c = myStore[1][idx][1] - myStore[1][idx][2];
            }
          }
          if (a + tmp_c >= c + tmp_a) {
            result += c + tmp_a;
          } else {
            result += a + tmp_c;
          }

        } else if (a >= c) { // c를 선택
          result += c;
          int tmp_idx = c_idx;
          a = MAX_POWER;

          for (int idx = 0; idx < len[1]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[1][idx][1] - myStore[1][idx][0] < a) {
              a = myStore[1][idx][1] - myStore[1][idx][0];
            }
          }
          result += a;
        } else { // a를 선택
          result += a;

          int tmp_idx = a_idx;
          c = MAX_POWER;

          for (int idx = 0; idx < len[1]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[1][idx][1] - myStore[1][idx][2] < c) {
              c = myStore[1][idx][1] - myStore[1][idx][2];
            }
          }
          result += c;
        }
      } else { // a 능력자만 선택되지 않음
        int b = MAX_POWER, c = MAX_POWER;
        if (len[1] > 1) {
          for (int idx = 0; idx < len[1]; idx++) {
            if (myStore[1][idx][1] - myStore[1][idx][0] < b) {
              b = myStore[1][idx][1] - myStore[1][idx][0];
            }
          }
        }
        if (len[2] > 1) {
          for (int idx = 0; idx < len[2]; idx++) {
            if (myStore[2][idx][2] - myStore[2][idx][0] < c) {
              c = myStore[2][idx][2] - myStore[2][idx][0];
            }
          }
        }
        if (b >= c) {
          result += c;
        } else {
          result += b;
        }
      }
    } else if (len[1] == 0) {
      if (len[2] == 0) { // b와 c 능력자가 선택되지 않음
        int b_idx = 0, c_idx = 0;
        int b = MAX_POWER, c = MAX_POWER;
        for (int idx = 0; idx < len[0]; idx++) {
          if (myStore[0][idx][0] - myStore[0][idx][1] < b) {
            b = myStore[0][idx][0] - myStore[0][idx][1];
            b_idx = idx;
          }
          if (myStore[0][idx][0] - myStore[0][idx][2] < c) {
            c = myStore[0][idx][0] - myStore[0][idx][2];
            c_idx = idx;
          }
        }

        if (b_idx == c_idx) { // 하필 같은 행...
          int tmp_idx = b_idx;
          int tmp_b = b, tmp_c = c;
          b_idx = 0, c_idx = 0, b = MAX_POWER, c = MAX_POWER;

          for (int idx = 0; idx < len[0]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[0][idx][0] - myStore[0][idx][1] < b) {
              b = myStore[0][idx][0] - myStore[0][idx][1];
              b_idx = idx;
            }
            if (myStore[0][idx][0] - myStore[0][idx][2] < c) {
              c = myStore[0][idx][0] - myStore[0][idx][2];
              c_idx = idx;
            }
          }
          if (b + tmp_c >= c + tmp_b) {
            result += c + tmp_b;
          } else {
            result += b + tmp_c;
          }

        } else if (b >= c) { // c를 선택
          result += c;
          int tmp_idx = c_idx;
          b_idx = 0, b = MAX_POWER;

          for (int idx = 0; idx < len[0]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[0][idx][0] - myStore[0][idx][1] < b) {
              b = myStore[0][idx][0] - myStore[0][idx][1];
              b_idx = idx;
            }
          }
          result += b;
        } else { // b를 선택
          result += b;

          int tmp_idx = b_idx;
          c_idx = 0, c = MAX_POWER;

          for (int idx = 0; idx < len[0]; idx++) {
            if (idx == tmp_idx)
              continue;
            if (myStore[0][idx][0] - myStore[0][idx][2] < c) {
              c = myStore[0][idx][0] - myStore[0][idx][2];
              c_idx = idx;
            }
          }
          result += c;
        }
      } else { // b 능력자만 선택되지 않음
        int a = MAX_POWER, c = MAX_POWER;

        if (len[0] > 1) {
          for (int idx = 0; idx < len[0]; idx++) {
            if (myStore[0][idx][0] - myStore[0][idx][1] < a) {
              a = myStore[0][idx][0] - myStore[0][idx][1];
            }
          }
        }
        if (len[2] > 1) {
          for (int idx = 0; idx < len[2]; idx++) {
            if (myStore[2][idx][2] - myStore[2][idx][1] < c) {
              c = myStore[2][idx][2] - myStore[2][idx][1];
            }
          }
        }
        if (a >= c) {
          result += c;
        } else {
          result += a;
        }
      }
    } else if (len[2] == 0) { // c 능력자만 선택되지 않음
      int a = MAX_POWER, b = MAX_POWER;
      if (len[0] > 1) {
        for (int idx = 0; idx < len[0]; idx++) {
          if (myStore[0][idx][0] - myStore[0][idx][2] < a) {
            a = myStore[0][idx][0] - myStore[0][idx][2];
          }
        }
      }
      if (len[1] > 1) {
        for (int idx = 0; idx < len[1]; idx++) {
          if (myStore[1][idx][1] - myStore[1][idx][2] < b) {
            b = myStore[1][idx][1] - myStore[1][idx][2];
          }
        }
      }
      if (a >= b) {
        result += b;
      } else {
        result += a;
      }
    }

    printf("#%d %d\n", test_case, result);
  }
  return 0;
}