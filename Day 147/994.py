# 994. Rotting Oranges

# You are given an m x n grid where each cell can have one of three values:

# 0 representing an empty cell,
# 1 representing a fresh orange, or
# 2 representing a rotten orange.
# Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

# Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

from collections import deque

# Function to calculate minimum minutes to rot all oranges
def orangesRotting(grid):

    # If grid is empty, return 0
    if not grid:
        return 0

    # Get number of rows and columns
    m, n = len(grid), len(grid[0])

    # Queue to store rotten oranges
    rotten = deque()

    # Count of total oranges (fresh + rotten)
    total = 0

    # Count of oranges rotted during BFS
    count = 0

    # Traverse the grid to count and collect initial rotten oranges
    for i in range(m):
        for j in range(n):
            
            # Count any fresh or rotten orange
            if grid[i][j] != 0:
                total += 1

            # Add rotten orange to queue
            if grid[i][j] == 2:
                rotten.append((i, j))

    # Direction vectors for 4 directions
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    # Variable to count minutes
    days = 0

    # BFS loop
    while rotten:
        
        # Number of oranges to process this minute
        k = len(rotten)
        count += k

        # Process all rotten oranges at this level
        for _ in range(k):
            x, y = rotten.popleft()

            # Check all 4 directions
            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                # Skip if out of bounds or not a fresh orange
                if nx < 0 or ny < 0 or nx >= m or ny >= n or grid[nx][ny] != 1:
                    continue

                # Mark orange as rotten
                grid[nx][ny] = 2

                # Add to queue for next round
                rotten.append((nx, ny))

        # If queue still has items, increment minutes
        if rotten:
            days += 1

    # Return minutes if all rotted, else -1
    return days if count == total else -1

# Driver code
grid = [
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1]
]

# Call the function and print result
result = orangesRotting(grid)
print("Minimum Number of Minutes Required", result)
