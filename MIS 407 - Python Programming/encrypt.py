import sys

letters = input("Enter key (26 letters): ")
text = input("Enter text to encrypt: ")

alphabetArr = ["a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o","p",
                "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"]

encryptedText = ""

if len(letters) == len(alphabetArr):
    for i in range(len(encryptedText)):
        if letters[i] not in alphabetArr:
            print("Error! Encryption key is not 26 letters or does not contain all letters a-z")
            sys.exit()
if len(letters) == len(alphabetArr):
    for i in range (len(text)):
        if text[i].isupper():
            encryptedText += letters[alphabetArr.index(text[i].lower())]
        elif text[i] not in alphabetArr:
            encryptedText += text[i]
        else:
            encryptedText += letters[alphabetArr.index(text[i])]

print("Encrypted text: ", encryptedText)
