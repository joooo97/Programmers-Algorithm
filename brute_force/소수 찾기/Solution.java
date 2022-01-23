import java.util.*;

class Solution {
    public int n;
    public char[] nums;
    public boolean[] use;
    public boolean[] check_prime = new boolean[10000000]; // check[i] == false면 소수
    public Set<Integer> primeNums = new HashSet<>();

    // 1 ~ end_num 이하의 모든 소수 구하기
    public void findAllPrimeNumber(int end_num) {
    	check_prime[0] = check_prime[1] = true; // 0, 1은 소수 아님
    	
    	for(int i = 2; i*i <= end_num; i++) {
    		if(!check_prime[i]) {
    			for(int j = i*2; j <= end_num; j += i) {
    				check_prime[j] = true;
    			}
    		}
    	}
    }
    
    // length 길이의 수를 만들 것이고, idx번째 숫자를 정한다.
    // length: 1부터 시작, idx: 0부터 시작
    public void makeNumber(int length, int idx, String str_num) {  	
    	// length 길이의 수를 만들었다면 소수인지 확인
    	if(idx == length) {
    		int number = Integer.valueOf(str_num);
    		if(!check_prime[number]) primeNums.add(number);
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(!use[i]) {
    			use[i] = true;
    			makeNumber(length, idx + 1, str_num + nums[i]);
    			use[i] = false;
    		}
    	}
    	
    }
    
    public int solution(String numbers) {
    	n = numbers.length();
        nums = numbers.toCharArray();
        use = new boolean[n];
        
        String end_num = "";
        for(int i = 0; i < n; i++) {
        	end_num += "9";
        }
        findAllPrimeNumber(Integer.valueOf(end_num)); // 1에서 end_num 이하의 모든 소수 구하기
                
        for(int i = 1; i <= n; i++) {
        	makeNumber(i, 0, "");
        }
        
        return primeNums.size();
    }
    
}