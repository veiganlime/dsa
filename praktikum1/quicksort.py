def partition(a, begin, end):

    pivot = a[end]
    i = begin - 1

    for j in range (begin, end):
        if a[j] <= pivot:
            i = i + 1
            temp = a[i]
            a[i] = a[j]
            a[j] = temp

    temp = a[i+1]
    a[i+1] = a[end]
    a[end] = temp

    return i+1

def sortiere(a, begin, end):

    if begin < end:
        pivotIndex = partition(a, begin, end)
        sortiere(a, begin, pivotIndex -1)
        sortiere(a, pivotIndex +1, end)



a = [99, 0, 33, 27, 87, 80, 65, 77, 39, 88]

print(a)

sortiere(a, 0, len(a)-1)

print(a)
