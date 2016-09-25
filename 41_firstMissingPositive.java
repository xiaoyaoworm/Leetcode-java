我想到的这个解法是O(n)的space O(n)的时间复杂度
蛮trick的，思路很清晰，可以再简化空间复杂度的。
我想自己创建一个数组，保证这个数组的index = value，超出范围的就不用存了，直接忽略。
因为有n = nums.length-1 个数，所以我们的数组多定义一位，第0位。arr = new int[nums.length+1];
那从0开始往后扫，只要 > 0 和 < nums.length+1的index值，保证arr[nums[i]] = nums[i];
再从左（0位是忽略的，从1开始扫）往右扫一遍，找到这个i。
最容易犯错的地方在最后那个return，如果都没找到怎么办，说明现在的序列一定是1~n返回n+1即可。


[code]
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums.length+1 && nums[i] > 0){
                arr[nums[i]] = nums[i];
            }
        }
        for(int i = 1; i < nums.length+1; i++){
            if(arr[i]!=i) return i;
        }
        return nums.length+1;
    }
}[/code]


那么思路对了，可以进一步优化，首先我们可以去掉那个+1用同样的length，因为我们浪费了第0位，所以错位即可。存arr[i] = i+1最后找出arr[i]!=i+1即可。

进一步优化就是O(1) space,我们可以不用arr直接用num：
不断更新nums[i]的值: while循环去把当前nums[i]换走，再继续这样做，直到无法满足条件，当然还要加上不能一直去换两个相等的值，这样会进入死循环。

then use for loop to find 0~n, return which not equals to i+1, otherwise, same as above return length+1;

时间复杂度分析：
We visit each number once, and each number will be put in its right place at most once, so it is O(n) + O(n). 
Although there are two nesting of cyclic (for and while), but its time complexity is still O(n).

[code]
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }
        for(int i = 0; i < n; i++)
            if(nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
[/code]