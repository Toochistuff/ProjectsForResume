import binascii


def listofchars(entirename):
    z = [i for i in entirename]
    print(z)

def asciilist(entirename):
    res = []
    for ele in entirename:
        res.extend(ord(num) for num in ele)

    print(str(res))


def asciitobinary(theasciilist):
    binary_list = []
    for char in theasciilist:
        asciicode = ord(char)
        binarystring = bin(asciicode)[2:]

        binary_list.append(binarystring)
    return binary_list

def binarytostring(binary_list):
    ascii_list = []
    for binarystring in binary_list:
        asciicode = int(binarystring, 2)
        characters = chr(asciicode)
        ascii_list.append(characters)
    return ''.join(ascii_list)




def main ():
    entirename = input("What is your input? ")

    listofchars(entirename)
    asciilist(entirename)
    binarylist = asciitobinary(entirename)
    print(binarylist)
    stringlist = binarytostring(binarylist)
    print(stringlist)
    listofchars(stringlist)
    asciilist(stringlist)

main()

