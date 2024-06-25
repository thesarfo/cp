There are six most popular sorting algorithms. They are:

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quicksort
6. HeapSort

### Bubble Sort
What it does is that, it cycles through the array of numbers, and looks at each pair of adjacent numbers. Bubble sort will then place the lower number on the left, towards the beginning of the array, and the higher number on the right, towards the end. This process is repeated and bubble sort will continue to loop through the array until no swaps are made, thus leaving a sorted array.

Bubble sort is ***slow***, with a worst case time complexity of 0(n²), hence its not really effective. But it could be potentially useful for lists that are already sorted and only a handful of swaps need to be made. Also, bubble sort is what’s known as an in-place algorithm so it doesn’t use a whole lot of extra auxiliary processing power from your computer.

<img src="../images/bubble-sort.gif">


### Selection Sort
Selection sort works by splitting the input array into two parts: the list of numbers being built, from smallest to largest, and the remainder numbers that have yet to be sorted. Selection sort finds the smallest number from the unsorted list, and places it at the end of the sorted one. Rinse and repeat.

First, it sets the first element in the array as the current minimum, it then loops through the rest of the elements in the array and checks if each element is smaller than the current minimum. If the current element the loop is on, is smaller than the current minimum, the current element becomes the current minimum. The loop then continues checking the rest of the elements to see if they are smaller than the current minimum. When the loop reaches the end of the array, it then swaps the position of the current minimum and the first value in the array.

With a big O notation of O(n²), selection sort is another algorithm that is not very effective for sorting large arrays. While slightly outperforming bubble sort when working with small lists, selection sort is still viewed as a very slow algorithm.

<img src="../images/selection-sort.gif">


### Insertion Sort
Insertion sort works by building the final, sorted array one item at a time. The algorithm will loop through the initial array, remove one element, and place it in its proper place as part of the sorted list.

<img src="../images/insertion-sort.gif">

The time complexity is also 0(n²)

| :exclamation:  This is very important   |
|-----------------------------------------|

> The first three algorithms above are called "simple sorting algorithms", the ones below are much more advanced sorting algorithms.


### Merge Sort
Merge sort operates by first breaking an array into its individual components. It then "pairs up" an individual with another, putting them into their proper place(sorted) with reference to each other. Merge sort then continues to pair up each sublist of numbers and sorts then in the process. This is continued until there is just one list remaining - the sorted array.

<img src="../images/merge-sort.gif">

### Quick Sort
This algorithm works by

1. First selecting a pivot number in the array
2. Then sorting the other numbers by placing them before or after the pivot number responsively
3. At this point the pivot number is in the correct location, and the two groups of numbers(one on each side of the pivot number) still need to be sorted
4. New pivot numbers are then chosen within the remaining subsets, and this process is repeated until no swaps are made.

Worst-case time complexity for quicksort is O(n²), although this is an algorithm that rarely falls into its worst-case performance, especially with minor amounts of customization. Typically the Big-O for quicksort is O(n log n). However, a worst case of O(n²) is a knock against it.


### Heap Sort
This is kind of an upgraded version of selection sort. They are similar because heapsort breaks down the input data into two groups, sorted and unsorted, and builds the sorted group one number at a time. Where they differ, is where heapsort uses, a heap, to build the unsorted group so its not blindly finding each number, one at a time. Heapsort adds the largest number from the unsorted group to the sorted group, then rebuilds the heap and repeats the process, adding the highest number to the sorted group.

