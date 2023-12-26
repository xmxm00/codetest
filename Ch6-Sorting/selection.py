array = [7,5,9,0,3,1,6,2,4,8]

for i in range(len(array) - 1):
  min = i
  for j in range(i + 1, len(array)):
    if array[min] > array[j]:
      min = j
  
  tmp = array[i]
  array[i] = array[min]
  array[min] = tmp

print(array)