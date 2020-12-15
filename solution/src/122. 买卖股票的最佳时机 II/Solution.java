class Solution {
    public int maxProfit(int[] prices) {
        int acs=0;
        int n=prices.length-1;
        for(int i=0;i<n;i++){
            acs+=Math.max(0,prices[i+1]-prices[i]);
        }
        return acs;
    }

}