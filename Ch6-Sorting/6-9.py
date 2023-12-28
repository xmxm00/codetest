# sorted function

array = [('바나나', 2), ('사과', 5), ('당근', 3)]
array = [
  {"id": 4, "name": "Baek", "major": "Software"},
  {"id": 1, "name": "Kim", "major": "Nano Engineering"},
  {"id": 5, "name": "Joo", "major": "Electrical Engineering"},
  {"id": 3, "name": "Choi", "major": "Mathematics"}
]

print(sorted(array, key=lambda x: x["id"]))