Assignment Observations

Part 2: Analysis of SpeedUni vs SpeedMulti

(1) SpeedUni Runtime

Input: Array Size = 100,000; Range = 0-2000
Observed Runtime: Approx 3355.0 ms (Reference from Assignment Figure 1)

(2) SpeedMulti Runtime

Input: Array Size = 100,000; Mid = 50,000; Range = 0-2000
Observed Runtime: Approx 1022.0 ms (Reference from Assignment Figure 2)

(3) Observations & Comparison

Observation: The "Parallel Mode" (SpeedMulti) is significantly faster than the "Normal Mode" (SpeedUni).
Reason: 1.  Parallel Execution: SpeedMulti utilizes multi-threading. By splitting the 100,000 elements into two chunks of 50,000, two separate CPU cores can sort the halves simultaneously.
2.  Algorithmic Complexity: Selection sort is $O(N^2)$. Sorting 100,000 items takes roughly $100,000^2$ operations. Sorting two halves of 50,000 takes effectively half time of the total work of the single large sort.
3.  Result: Even with the overhead of merging the two halves, the parallel approach reduces the total execution time drastically (roughly 3x faster in the provided example).

Part 3: Bubble Sort Upgrade Analysis

(3) Comparison: Bubble Sort vs Selection Sort

Results Comparison:
When running MyBubbleUni and MyBubbleMulti with the same inputs (Size: 100,000), the runtimes are significantly higher (slower) compared to the Selection Sort results in Part 2.

Reasons for Difference:

Swap Operations: While both Selection Sort and Bubble Sort have a time complexity of $O(N^2)$, their internal behavior differs. Selection Sort makes a maximum of $N$ swaps (one per iteration). Bubble Sort, however, swaps adjacent elements repeatedly to "bubble" elements to the top.

Memory Overhead: The excessive swapping in Bubble Sort requires more memory write operations, which is computationally expensive compared to the read-heavy nature of Selection Sort.

Conclusion: The upgraded API works correctly, but the performance metrics show that Bubble Sort is less efficient than the default Selection Sort for this dataset.