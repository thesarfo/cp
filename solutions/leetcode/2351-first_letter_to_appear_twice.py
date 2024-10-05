class Solution(object):
    def repeatedCharacter(self, s):
        strArray = list(s)
        newArray = []

        for char in strArray:
            if char in newArray:
                return char
            else:
                newArray.append(char)