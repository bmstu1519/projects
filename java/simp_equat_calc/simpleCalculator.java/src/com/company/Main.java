package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String inp = scan.nextLine();
    inp = inp.replaceAll("\\s+","");
    int sum = 0;
    int flag = 1;
    int diff = 0;
    int digit = 0;
    int x = inp.indexOf('x');
    for (int i = 0; i < inp.length(); i++){
        while (inp.charAt(i) >= '0' && inp.charAt(i) <= '9') {
            if (i > 0 && digit == 0 && inp.charAt(i - 1) == '-') digit = i;
            else if ( i > 0 && digit == 0 && inp.charAt(i - 1) != '-' && i > inp.indexOf('=')) digit = i;
            diff = diff * 10 + inp.charAt(i) - '0';
            if (i == inp.length() - 1) break;
            else i++;
        }
        if (digit > 0 && digit < inp.indexOf('=') || digit > inp.indexOf('=') &&  inp.charAt(digit - 1) != '-') flag *= -1;
        if (diff != 0) {
            sum += diff * flag;
            flag = 1;
            diff = digit = 0;
        }
    }
        sum *= (x > 0 && (inp.charAt(x - 1) == '-' && x > inp.indexOf('=')
                || inp.charAt(x - 1) != '-' && x < inp.indexOf('=')) || x == 0 && x < inp.indexOf('=')) ? -1 : 1;
        System.out.println(sum);
    }
}