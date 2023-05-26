import java.util.Scanner;

public class ITHINKER_GROUP{
    public static String hashingFunction(String input) {
        char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int inputLength = input.length();
        char[] newInput = new char[inputLength];
        int[] tempResult = new int[100];
        char[] hash = new char[hex.length];

        for (int i = 0; i < inputLength; i++) {
            newInput[i] = input.charAt(i);
        }

        int temp = 0;
        int count = 0;


        if (inputLength > hex.length) {

            for (int i = 0; i < inputLength; i++) {

                if (i < hex.length) {
                    temp = (int) newInput[i];
                    temp = (temp + 3) % hex.length;
                    tempResult[i] = temp;
                } else {
                    if (count == 16) {
                        count = 0;
                    }
                    temp = (int) newInput[i];
                    temp = (temp + 3) % hex.length;
                    tempResult[count] = temp;
                    count++;
                }

            }

            temp = 0;
            for (int i = 0; i < hex.length; i++) {
                temp = tempResult[i];
                tempResult[i] = hex[temp];
                hash[i] = (char) tempResult[i];
            }
        } else {

            for (int i = 0; i < hex.length; i++) {

                if (inputLength <= i) {
                    temp = (temp + 3) % hex.length;
                    tempResult[i] = temp;
                } else {
                    temp = (int) newInput[i];
                    temp = (temp + 3) % hex.length;
                    tempResult[i] = temp;
                }
            }

            temp = 0;
            for (int i = 0; i < hex.length; i++) {
                if (hex[i] == 0) {
                    break;
                }
                temp = tempResult[i];
                tempResult[i] = hex[temp];
                hash[i] = (char) tempResult[i];
            }
        }

        String hashed = new String(hash);

        return hashed;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.close();

        System.out.print("Enter a String: ");
        String input = scan.nextLine();

        System.out.println("Hashed: " + hashingFunction(input));
    }

}

