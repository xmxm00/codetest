# Quick Sort

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def qSort(array, start, end):
  if start >= end:
    return
  pivot = start
  left, right = start + 1, end
  while left <= right:
    while left <= end and array[left] < array[pivot]:
      left += 1
    while left <= end and array[right] > array[pivot]:
      right -= 1
    if left > right:
      array[pivot], array[right] = array[right], array[pivot]
    else:
      array[right], array[left] = array[left], array[right]

  qSort(array, start, right-1)
  qSort(array, right+1, end)
  

qSort(array, 0, len(array)-1)
print(array)