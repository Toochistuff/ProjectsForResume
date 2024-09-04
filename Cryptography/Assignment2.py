import random
import math
from sympy import isprime
from typing import List, Tuple
from functools import reduce

class RSA:
    MIN_PRIME = 100
    MAX_PRIME = 1000

    @staticmethod
    def main():
        keypair = RSA.key_gen()
        message = input("What's the message? ")

        encryptedmess = RSA.encrypt(message, keypair[0])
        decryptedmess = RSA.decrypt(encryptedmess, keypair[1])

        print("Original message:", message)
        print("Encrypted message:", encryptedmess)
        print("Decrypted message:", decryptedmess)

    @staticmethod
    def key_gen() -> Tuple[Tuple[int, int], Tuple[int, int]]:
        p = RSA.generate_prime()
        q = RSA.generate_prime()

        n = p * q
        phi_n = (p - 1) * (q - 1)

        e = RSA.generate_coprime(phi_n)
        d = pow(e, -1, phi_n)

        publickey = (e, n)
        privatekey = (d, n)

        return publickey, privatekey

    @staticmethod
    def encrypt(message: str, public_key: Tuple[int, int]) -> List[int]:
        e, n = public_key
        encryptedmess = [pow(ord(c), e, n) for c in message]
        return encryptedmess

    @staticmethod
    def decrypt(encryptedmess: List[int], private_key: Tuple[int, int]) -> str:
        d, n = private_key
        decryptedmess = ''.join(chr(pow(c, d, n)) for c in encryptedmess)
        return decryptedmess

    @staticmethod
    def generate_prime() -> int:
        while True:
            prime_candidate = random.randint(RSA.MIN_PRIME, RSA.MAX_PRIME)
            if isprime(prime_candidate):
                return prime_candidate

    @staticmethod
    def generate_coprime(phi_n: int) -> int:
        while True:
            e = random.randint(2, phi_n - 1)
            if math.gcd(e, phi_n) == 1:
                return e

if __name__ == "__main__":
    RSA.main()