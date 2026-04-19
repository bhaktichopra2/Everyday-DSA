# 401. Binary Watch

# A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

# For example, the below binary watch reads "4:51".


# Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

# The hour must not contain a leading zero.

# For example, "01:00" is not valid. It should be "1:00".
# The minute must consist of two digits and may contain a leading zero.

# For example, "10:2" is not valid. It should be "10:02".
 
def readBinaryWatch(turnedOn):
    result = []

    for h in range(12):          # valid hours
        for m in range(60):      # valid minutes

            # total LEDs ON should equal turnedOn
            if h.bit_count() + m.bit_count() == turnedOn:
                result.append(f"{h}:{m:02d}")

    return result


def main():
    turnedOn = 1
    print(readBinaryWatch(turnedOn))


if __name__ == "__main__":
    main()