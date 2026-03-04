package Day4;

public class ContainerWithMostWater {
        /*
        * PROBLEM: Container With Most Water
        *
        * GOAL:
        * Find two lines that together with the x-axis form a container, such that the container contains the most water.
        *
        * CORE DIFFICULTY:
        * 1) Brute force approach is O(n^2) → check all pairs of lines.
        * 2) We need a more efficient way to find the optimal pair.
        *
        * KEY OBSERVATION:
        * The area formed by two lines is determined by:
        * - The distance between the lines (width).
        * - The height of the shorter line (height).
        *
        * Two-pointer technique:
        * - Start with two pointers at the ends of the array.
        * - Calculate area and update max area.
        * - Move the pointer pointing to the shorter line inward, hoping to find a taller line that can increase area.
        *
        * Why move the shorter line?
        * Because moving the taller line won't increase area (height is limited by shorter line), but moving the shorter line might find a taller line that increases area.
        *
        * Time Complexity: O(n) since we traverse the array once with two pointers.
        * Space Complexity: O(1) since we use only constant extra space.
        */
    public int maxArea(int[] height) {
        int n = height.length;
        int r=n-1,l=0;
        int maxArea = 0;
        while(l<r){
            int area = (r-l)*(Math.min(height[l],height[r]));
            maxArea = Math.max(area,maxArea);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}
