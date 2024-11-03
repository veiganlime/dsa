def binareSearch(a, target, begin, end):

    if begin <= end :
        mitte = begin + (end - begin) // 2


        if a[mitte] == target: 
            return mitte
        elif a[mitte] > target: 
            return binareSearch(a, target, begin, mitte - 1)
        else :
            return binareSearch(a, target, mitte + 1, end)
    return -1


a = [99, 0, 33, 27, 87, 80, 65, 77, 39, 88]

print(a)
a.sort()
print(a)
target = int(input("Enter the target number: ")) 
position = binareSearch(a, target, 0, len(a)-1)

print(target)

if position != -1: 
    print("Die Position der gescuhten Zahl ist ",  position)
else:
    print( "Zahl nicht gefunden.")

