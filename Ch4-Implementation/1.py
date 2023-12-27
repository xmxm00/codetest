n = int(input())
commands = input().split()

pos = {"x": 0, "y": 0}

for command in commands:
    if command == 'R':
        pos["x"] = pos["x"] + 1 if pos["x"] < (n-1) else pos["x"]
    elif command == 'L':
        pos["x"] = pos["x"] - 1 if pos["x"] > 0 else pos["x"]
    elif command == 'D':
        pos["y"] = pos["y"] + 1 if pos["y"] < (n-1) else pos["y"]
    elif command == 'U':
        pos["y"] = pos["y"] - 1 if pos["y"] > 0 else pos["y"]
    else:
        print("Wrong Command: ", command, " is not allowed.")

print(pos["y"] + 1, pos["x"] + 1)