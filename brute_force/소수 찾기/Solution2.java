import java.util.*;

// 1. 주어진 문자열로 만들 수 있는 모든 숫자 구하기
// - 1자리, 2자리, ... , 문자열 길이의 자릿 수
// - 중복 생성 방지를 위해 Set에 담기 (1, 1이 주어진 경우 1, 1과 11, 11이 중복됨)
// 2. 소수 판별
// - 어떤 수 N의 약수들은 루트 N을 기준으로 대칭을 이루며, 소수는 1과 자기자신만 약수로 가지므로 2와 루트 N 사이에 N의 약수가 존재한다면 소수가 아님

class Solution2 {
    Set<Integer> created_nums = new HashSet<>();
    boolean[] use_num;
    
    public int solution(String numbers) {
        use_num = new boolean[numbers.length()];
        
        // 1. 주어진 문자열로 만들 수 있는 모든 숫자 구하기
        for(int i = 1; i <= numbers.length(); i++) {
            makeNumber(numbers, i, "");
        }
        
        // 2. 소수 판별
        int answer = 0;
        
        for(int num : created_nums) {
            if(isPrimeNum(num)) answer += 1;
        }

        return answer;
    }
    
    // 주어진 문자열로 숫자를 만드는 메소드
    public void makeNumber(String numbers, int length, String temp) {
        if(temp.length() == length) { // 원하는 길이의 숫자를 만들었다면 set에 담기
            created_nums.add(Integer.valueOf(temp));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(use_num[i]) continue;
            
            use_num[i] = true;
            makeNumber(numbers, length, temp + numbers.charAt(i));
            use_num[i] = false;
        }
    }
    
    // 소수 판별 메소드
		// - 파라미터로 0, 1이 들어오면 false 반환 (0,1은 소수가 아님)
		// - 파라미터로 2가 들어오는 경우는 for문을 돌지 않기 때문에 true를 리턴할 것
    public boolean isPrimeNum(int num) {
        // 0과 1은 소수가 아니므로 false 리턴
        if(num < 2) return false;
        
        // 2~루트num 사이에 num의 약수가 존재하는지 확인
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}