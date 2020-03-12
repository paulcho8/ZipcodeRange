## Williams Sonoma Coding Challenge

#### Dependenices
- Java 8+

#### Clone the repository
Create a folder in a directory of your choice


```git clone https://gitlab.mynisum.com/pcho/wsi-challenge.git```

#### Testing

```gradle test```

Test cases:

1. Properly merge overlapping ranges
2. Properly return non-overlapping ranges
3. Properly merge overlapping, long ranges
4. Properly merge overlapping, long, and unsorted ranges

#### Run

```gradle run --args='ranges separated by one space'```

**Please follow the format provided by the examples below**

Examples: 

```gradle run --args='94133,94133 94200,94299 94600,94699'```

```gradle run --args='94133,94133 94200,94299 94200,94399'```

#### Background


###### PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

 

###### NOTES

- The ranges above are just examples, your implementation should work for any set of arbitrary ranges

- Ranges may be provided in arbitrary order

- Ranges may or may not overlap

- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

 

###### EXAMPLES:

If the input = [94133,94133] [94200,94299] [94600,94699]

Then the output should be = [94133,94133] [94200,94299] [94600,94699]

###### SOLUTION:

Implemented two classes: ```ZipcodeRange``` and ```ZipcodeRangeCollection```.

```ZipcodeRange``` has two attributes: ```lowerRange ``` and ```higherRange``` that keep track of the lower and upper limits of the zipcode range.

Upon instantiation, the two range limits are "sorted" at O(n) time complexity.

Each ```ZipcodeRange``` is added to a ```rangedList``` to iterate through.

```rangedList``` is sorted using a custom comparator prior to merging.

```ZipcodeRangeCollection``` takes the ```rangedList``` and applies a modified quickSort by comparing the previous range's ```higherRange``` with the current range's ```lowerRange```. 

**Logic for performing the merge**

_Step 1: Add the range to the ```merged linkedList```_

- Condition 1: merged list is empty (first time a range is added)

OR

- Condition 2: there is no overlap between the previous upper range and current lower range
- Condition 3: the previous upper range and current lower range are not consecutive

_Step 2: Merge ranges_

- If consecutive range: Set the previous range's ```higherRange``` to the current range's ```higherRange```

- If nonconsecutive range: Set the previous range's ```higherRange``` to the higher range of the two ranges.

Please reference in code documentation for details.

###### TIME COMPLEXITY

O(n * log(n))