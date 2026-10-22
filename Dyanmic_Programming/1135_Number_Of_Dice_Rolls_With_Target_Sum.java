class Solution {
    public int helper(int dice,int faces,int target,int[][] dp){
        if(dice==0 && target==0){
            return 1;
        }
        if(dice==0 || target<0){
            return 0;
        }
        if(dp[dice][target]!=-1){
            return dp[dice][target];
            
        }
        int totalcount=0;
        int modulo=1000_000_007;
        for(int face=1;face<=faces;face++){
            int count=helper(dice-1,faces,target-face,dp);
            totalcount=(totalcount+count)%modulo;
        }
        dp[dice][target]=totalcount;
        return totalcount;

    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);

        }
        return helper(n,k,target,dp);
        
    }
}
