#include <stdio.h>

int solve(int x, int * y) {
	int result = 0; int i;
	for(i=1; result < x; i++){
		result += i;
	}
	*y = x - result + i - 1;

	return i-1;
}

int main(void)
{
	int test_case;
	int T;
	setbuf(stdout, NULL);
	scanf("%d", &T);
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int s, e;
		int result = 0;
		scanf("%d %d", &s, &e);
		if(s == e) result = 0;
		else {
			if(s > e){ // swap
				s = s ^ e;
				e = s ^ e;
				s = s ^ e;
			}
			int s_x, s_y, e_x, e_y;
			s_x = solve(s, &s_y);
			e_x = solve(e, &e_y);
			int diff_x = e_x - s_x;
			int diff_y = s_y - e_y;
			if(diff_y < 0){ // 삼각형을 만들어야 하는 경우
				diff_y *= -1;
				if(diff_x >= diff_y){
					result = diff_y + (diff_x - diff_y);
				} else {
					result = diff_x + (diff_y - diff_x);
				}
			} else if (diff_y > 0){ // 뒤로 가야하는 경우
				result = diff_x + diff_y;
			} else { // y좌표가 같은 경우
				result = diff_x;
			}
			// printf("%d %d, %d %d\n", s_x, s_y, e_x, e_y);
		}
		printf("#%d %d\n", test_case, result);
	}
	return 0;
}