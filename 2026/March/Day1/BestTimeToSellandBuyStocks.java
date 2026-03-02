package Day1;


public class BestTimeToSellandBuyStocks {
    
    public int maxProfit(int[] prices) {
        int minPrice =prices[0];
        int maxProf =0;
        for(int i:prices){
            if(minPrice>i){
                minPrice =i;
            }else{
                maxProf = Math.max(maxProf,i-minPrice);
            }
        }
        return maxProf;
    
}
}
