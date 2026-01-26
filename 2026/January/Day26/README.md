Back to basics
*placement preparation start day-1*
solved the two sum with the using of hashmap in an unsorted array 
*dutch national flag algorithm* [sort 0,1,2]
    we have 3 pointers low,mid and high 
    here the algorithm completely depends on the mid pointer 
    0..low-1 contains the values 0's
    low...mid-1 contains the values 1's
    mid..high-1 contains unknown where we process values 
    high..end contains 2's 
    
    if the nums[mid]=0 swap nums[low] and nums[mid] and incrment mid and low
    else if nums[mid]== 1 update mid++
    else nums[mid]==2 swap nums[mid] with nums[high] and decrement high as we place 2 in the last places


*moores voting algorithm* update the majority no through incrementing count when we encounter the same num and decrementing the max count when a new number arrives 
so as the maxcount becomes zero we have to update it with the current new number


*best time to sell and buy stocks*:
    initially assume the first stock as minstock and maxprofit is 0 
    now traverse the prices array when you find the no which is less than the initially assumed stock then update the minstock with the new min stock
    if the prices[i]> minstock then find the profit update the maxprofit till the end 

solved the leetcode daily question 
which is a easy where we have to find the min abs diff and add the adj pairs to 2d list which are equal to the same absolute difference

