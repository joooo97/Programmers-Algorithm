class Solution {
    public int t, ans;
    public int[] arr_numbers;
    
	public void dfs(int idx, int cur) {
		if(idx == arr_numbers.length) {
			if(cur == t) ans += 1;
			return;
		}
		
		// cur + numbers[idx]
		dfs(idx + 1, cur + arr_numbers[idx]);
		
		// cur - numbers[idx]
		dfs(idx + 1, cur - arr_numbers[idx]);
	}
    
    public int solution(int[] numbers, int target) {
    	arr_numbers = numbers;
    	t = target;  
    	
    	dfs(0, 0);
    	        
        return ans;
    }
}