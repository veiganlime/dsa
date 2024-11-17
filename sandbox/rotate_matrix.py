# DESCRIPTION:

# Your task is to rotate a matrix 90 degree to the left. The matrix is an array of integers with dimension n,m. So this kata checks some basics, it's not too difficult.

# There's nothing more to explain, no tricks, no "bad cases";-). Perhaps you take a look at the testcases...

# One easy example:

# Input: {{-1, 4, 5},
#         { 2, 3, 4}}

# Output: {{ 5, 4},
#          { 4, 3},
#          {-1, 2}}
# First there are some static tests, later on random tests too...


def rotate_matrix(arr):
    rotated_matrix = [list(row) for row in zip(*arr)][::-1]
    return rotated_matrix


matrix = [[-1, 4, 5], [2, 3, 4]]

print(rotate_matrix(matrix))

