import csv

with open('sample.csv', newline = '') as csvFile:
    sampleReader = csv.reader(csvFile)
    sampleData = list(sampleReader)

csvFile = open('michigan.csv', 'w', newline='')
sampleWriter = csv.writer(csvFile)
sampleWriter.writerow(sampleData[0])

for i in sampleData:
    if i.__contains__("MI"):
        sampleWriter.writerow(i)

csvFile.close()