import csv

counterMN = 0
counterMO = 0

with open('sample.csv', newline = '') as csvFile:
    sampleReader = csv.reader(csvFile)
    sampleData = list(sampleReader)
    for i in sampleData:
        if i.__contains__("MN"):
            counterMN = counterMN + 1
        elif i.__contains__("MO"):
            counterMO = counterMO + 1

print("MN: total = ", counterMN)
print("MO: total = ", counterMO)