# Solved challenge solution

**Context:** Come up with solution to Two Sum problem with algorithm less than O(n^2)

**My solution:** O(n) time and space complexity


## Algorithm:

### Setup
1. Add all elements to Set: O(n) both time and space
2. Add all elements and their count/frequency to HashMap "count": O(n) both time and space
    eg. HashMap(1: 2,
                2: 1,
                3: 1,
                .
                .
                .
            )
3. Add all elements with list of indices to HashMap "indices": O(n) both time and space
    eg. HashMap(1: [0, 1],
                2: [3],
                3: [2],
                .
                .
                .
            )

### Main algorithm: O(n) for time, O(1) for space
'''for (i = 0 to len(arr)) {
    leftover = target - arr[i]
    if (set.contains(leftover)) {
        if (leftover == arr[i] && count.get(arr[i]) >= 2) {
            temp_arr = indices.get(arr[i])
            return [temp_arr[0], temp_arr[1]]
        }
        else if (leftover != arr[i]) {
            temp_arr1 = indices.get(arr[i])
            temp_arr2 = indices.get(leftover)
            return [temp_arr1[0], temp_arr2[0]]
        }
    }

    return NULL //shouldn't happen if problem input is valid
}'''