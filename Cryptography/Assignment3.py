def feistel_round(input_bits, key):
    # divide the input into 2
    left = input_bits[:4]
    right = input_bits[4:]

    # the mathmatical side of the function
    left_new = right
    f_result = (2 * (int(right, 2) ** int(key, 2))) % 16
    right_new = bin(int(left, 2) ^ f_result)[2:].zfill(4)
    output_bits = right_new + left_new

    return output_bits

def text_converter_with_feistel(text, key):
    result = ""
    for char in text:
        # char to binary
        char_bits = bin(ord(char))[2:].zfill(8)

        #  Feistel cipher round to the char
        feistel_result = feistel_round(char_bits, key)

        result += chr(int(feistel_result, 2))

    return result

def main():


    key = (input("Whats's the key? "))  # 4-bit key

    plaintext = input("What's the input? ")


    ctext = text_converter_with_feistel(plaintext,key)
    print("The ciphertext is:" + ctext)



main()