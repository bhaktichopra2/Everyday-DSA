# 746. Min Cost Climbing Stairs

# You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

# You can either start from the step with index 0, or the step with index 1.

# Return the minimum cost to reach the top of the floor.

def minCostClimbingStairs(cost):
    n = len(cost)

    first = cost[0]
    second = cost[1]

    if n <= 2:
        return min(first, second)

    for i in range(2, n):
        curr = cost[i] + min(first, second)
        first = second
        second = curr

    return min(first, second)


def main():
    cost = [10, 15, 20]
    print(minCostClimbingStairs(cost))


if __name__ == "__main__":
    main()