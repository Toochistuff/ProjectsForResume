def matrix(mykey):
    mykey = mykey.upper()
    thematrix = [[0 for i in range(5)] for j in range(5)]
    thelettersadded = []
    rows = 0
    columns = 0

    for letter in mykey:
        if letter not in thelettersadded:
            thematrix[rows][columns] = letter
            thelettersadded.append(letter)
        else:
            continue
        if (columns == 4):
            columns = 0
            rows += 1
        else:
            columns += 1

    for letter in range(65, 91):
        if letter == 74:
            continue
        if chr(letter) not in thelettersadded:
            thelettersadded.append(chr(letter))

    index = 0
    for i in range(5):
        for j in range(5):
            thematrix[i][j] = thelettersadded[index]
            index += 1
    return thematrix


def encryptionpart(keymatrix, listofchars):
    inc = 1
    keymatrix = keymatrix.upper()
    keymatrix = keymatrix.replace(' ', '')
    keymatrix = separatesameletters(keymatrix)
    cipher_text = ''
    for (l1, l2) in zip(keymatrix[0::2], keymatrix[1::2]):
        row1, col1 = indexOf(l1, listofchars)
        row2, col2 = indexOf(l2, listofchars)
        if row1 == row2:
            cipher_text += listofchars[row1][(col1 + inc) % 5] + listofchars[row2][(col2 + inc) % 5]
        elif col1 == col2:
            cipher_text += listofchars[(row1 + inc) % 5][col1] + listofchars[(row2 + inc) % 5][col2]
        else:
            cipher_text += listofchars[row1][col2] + listofchars[row2][col1]

    print(cipher_text)


def indexOf(letter, matrix):
    for i in range(5):
        try:
            index = matrix[i].index(letter)
            return (i, index)
        except:
            continue



def decryptionpart(cl, key):
    inc = -1
    MATRIXXX = matrix(key)
    cl = cl.upper()
    cl = cl.replace('', '')
    cl = separatesameletters(cl)
    plain_text = ''
    for (l1, l2) in zip(cl[0::2], cl[1::2]):
        row1, col1 = indexOf(l1, matrix)
        row2, col2 = indexOf(l2, matrix)
        if row1 == row2:
            plain_text += matrix[row1][(col1 + inc) % 5] + matrix[row2][(col2 + inc) % 5]
        elif col1 == col2:
            plain_text += matrix[(row1 + inc) % 5][col1] + matrix[(row2 + inc) % 5][col2]
        else:
            plain_text += matrix[row1][col2] + matrix[row2][col1]
            print(plain_text)


def separatesameletters(message):
    index = 0
    while (index < len(message)):
        l1 = message[index]
        if index == len(message) - 1:
            message = message + 'X'
            index += 2
            continue
        l2 = message[index + 1]
        if l1 == l2:
            message = message[:index + 1] + "X" + message[index + 1:]
        index += 2
    return message


def main():
    key = str(input("Enter the key:"))
    key = key.lower()
    themainmatrix = matrix(key)
    print(themainmatrix)
    while (1):
        choice = int(input("1.Encryption \n2.Decryption: \n3.EXIT\n"))
        if choice == 1:
            PP = str(input("Enter the Plain text:"))
            PP = PP.lower()
            encryptionpart(PP, themainmatrix)
        elif choice == 2:
            CC = str(input("Enter the Cipher text:"))
            CC = CC.lower()
            decryptionpart(CC, key)
        elif choice == 3:
            break
        else:
            print("Choose correct choice")


main()