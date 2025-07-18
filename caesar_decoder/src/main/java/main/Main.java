package main;

import java.util.Scanner;

public class Main {

        public static void decrypt(String cipherText) {

            cipherText = cipherText.toUpperCase();

            for (int shift = 1; shift < 26; shift++) {
                StringBuilder decrypted = new StringBuilder();

                for (char c : cipherText.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char base = 'A';
                        int shifted = (c - base - shift + 26) % 26 + base; //deciphering: basically takes the letter as a char and subtract the base and then subtract the shift
                        decrypted.append((char) shifted);                   //+26 should avoid negatives while modulo will keep it in range and the last base which is A should add to the value get the correct ASCII value
                    } else {
                        decrypted.append(c);
                    }
                }

                System.out.println("Shift " + shift + ": " + decrypted);
            }
        }

        public static void main(String[] args) {

            Scanner scn = new Scanner(System.in);
            String encrypted = scn.nextLine();
            decrypt(encrypted);
        }
    }
