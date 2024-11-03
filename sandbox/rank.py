def rank(lst):
    # Pair elements with their original indices
    sorted_array = sorted((value, idx) for idx, value in enumerate(lst))
    
    # Initialize variables
    rank_dict = {}
    rank = 0
    i = 0
    
    # Calculate ranks
    while i < len(sorted_array):
        same_values = [sorted_array[i]]
        j = i + 1
        
        # Find all elements with the same value
        while j < len(sorted_array) and sorted_array[j][0] == sorted_array[i][0]:
            same_values.append(sorted_array[j])
            j += 1
        
        # Calculate average rank for duplicate values
        avg_rank = sum(rank + k for k in range(len(same_values))) / len(same_values)
        
        # Assign the average rank to each index
        for value, idx in same_values:
            rank_dict[idx] = avg_rank
        
        # Update rank and index for next group
        rank += len(same_values)
        i = j
    
    # Build the result list based on original order
    ranked_array = [rank_dict[i] for i in range(len(lst))]
    return ranked_array

# Test cases
my_arr = [1, 3, 3, 9, 8]
my_arr2 = [9, 1, 4, 5, 4]
my_arr3 = ["z", "c", "f", "b", "c"]

ranking1 = rank(my_arr)
ranking2 = rank(my_arr2)
ranking3 = rank(my_arr3)
print("Original array:", my_arr)
print("Ranked:", ranking1)
print("Original array:", my_arr2)
print("Ranked:", ranking2)
print("Original array:", my_arr3)
print("Ranked:", ranking3)