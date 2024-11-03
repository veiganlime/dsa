def sort_odd_numbers(source_array):
    odd_numbers = []
    for x in source_array:
        if x % 2 != 0:  # Check if x is odd
            odd_numbers.append(x)
    
    # Sort the collected odd numbers
    odd_numbers.sort()
    
    # Step 2: Replace odd numbers in the original array with the sorted ones
    odd_index = 0  # Index to keep track of the sorted odd numbers
    for i in range(len(source_array)):
        if source_array[i] % 2 != 0:  # Check if the number at position i is odd
            source_array[i] = odd_numbers[odd_index]
            odd_index += 1  # Move to the next sorted odd number
    
    return source_array


arr = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  
sorted_arr = sort_odd_numbers(arr)
print(sorted_arr)