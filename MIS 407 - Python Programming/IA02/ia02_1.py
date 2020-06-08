import csv

with open('sample.csv', newline= '') as csvFile:
    sampleReader = csv.reader(csvFile)
    sampleData = list(sampleReader)
    print(sampleData)