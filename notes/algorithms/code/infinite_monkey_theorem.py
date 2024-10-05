import random

def generateOne(strlen):
    alphabet = "abcdefghijklmnopqrstuvwxyz "
    res = ""
    for i in range(strlen):
        res = res + alphabet[random.randrange(27)]
    return res

def score(goal, teststring):
    numSame = 0
    for i in range(len(goal)):
        if goal[i] == teststring[i]:
            numSame += 1
    return numSame / len(goal)


def main():
    goalstring = "methinks it is like a weasel"
    newstring = generateOne(28)
    best = 0
    newscore = score(goalstring, newstring)
    iteration_count = 0
    while newscore < 1.0:
        if newscore > best:
            print(newscore, newstring)
            best = newscore
        newstring = generateOne(28)
        newscore = score(goalstring, newstring)
        iteration_count += 1
        if iteration_count % 1000000 == 0:
            print("Iteration:", iteration_count, "Best guess so far:", best, newstring)

main()