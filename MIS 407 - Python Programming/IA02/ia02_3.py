import csv

with open('sample.csv', newline = '') as csvFile:
    sampleReader = csv.reader(csvFile)
    sampleData = list(sampleReader)

csvFile = open('selected_cols.csv', 'w', newline = '')
sampleWriter = csv.writer(csvFile)
sampleWriter.writerow(sampleData[0])
    
for row in sampleData:
    columnsSelected = [row[0], row[1], row[-1]]
    sampleWriter.writerow(columnsSelected)

csvFile.close()

