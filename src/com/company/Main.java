package com.company;

import java.io.IOException;
import java.util.Scanner;

class function {

    double f(double x) { return Math.cos(x); }

    // формула Симпсона (прием численного интегрирования)
    //a = нижняя граница; b = верхняя граница
    // n = колчество проходов(чем больше, тем меньше погрешность вычисления)
    double Integral(double a, double b, int n) {
        int i, z; //z = 2 or z = 4 or z = 8 (порядок погрешности)
        double h, s;
        n = n + n;
        s = f(a) * f(b);
        h = (b - a) / n;
        z = 4;
        for (i = 1; i < n; i++) {
            s = s + z * f(a + i * h);
            z = 6 - z;
        }
        return (s * h) / 3;
    }

    //проверка на четность
    int parity (int number){
        if(number %2 != 0){
            System.out.print(number+" ");
            number++;
        }
        else { number += 2;}
        return number;
    }

    //проверка строки на палиндромность
    public boolean isPalindromeRecursive(String text){
        String clean = text.replaceAll("\\s+", "").replaceAll("\\p{Punct}", "").toLowerCase();
        return recursivePalindrome(clean,0,clean.length()-1);
    }

    private boolean recursivePalindrome(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(text, forward + 1, backward - 1);
        }
        return true;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        function func;
        func = new function();

        switch(num){

            case 1: {
                System.out.println("Нечетные элетенты от 1 до 99: ");
                for(int i = 1;i<=99;i++){
                    if(i<100){func.parity(i);}
                    else break;
                }
                break;
            }

            case 2: {
                System.out.println("Массив из 20 чисел Фибоначчи: ");
                int n0 = 1; int n1 = 1; int n2;
                System.out.print(n0+" "+n1+" ");
                for(int i=3; i<=20; i++){
                    n2=n0+n1;
                    System.out.print(n2+" ");
                    n0=n1; n1=n2;
                }
                System.out.println(); break;
            }

            case 3: {
                String line = "Ешь немытого ты меньше";
                boolean result = func.isPalindromeRecursive(line);
                String line1 = "Мама - моя мама";
                boolean result1 = func.isPalindromeRecursive(line1);
                String line2 = "Мат и тут и там";
                boolean result2 = func.isPalindromeRecursive(line2);
                String line3 = "Он щи хлебал, слабел хищно";
                boolean result3 = func.isPalindromeRecursive(line3);
                String line4 = "Искать такси";
                boolean result4 = func.isPalindromeRecursive(line4);

                System.out.println(line+": "+ result);
                System.out.println(line1+": "+ result1);
                System.out.println(line2+": "+ result2);
                System.out.println(line3+": "+ result3);
                System.out.println(line4+": "+ result4);
                break;
            }

            case 4: {
                double a = 0;
                double b = Math.PI;
                int n = 10;
                double result = func.Integral(a,b,n);
                System.out.println("Result: " + result);
                break;
            }

            case 5: {
               // String myString = new String(Files.readAllBytes(Paths.get("C:../Harry.txt")));
                String myString = new String("But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the 'master-builder' of human happiness? No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to-enjoy a pleasure - that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?");
                String myString2 = myString.toLowerCase().replaceAll("\\p{Punct}", "");
                final String[] array = myString2.split(" ");
                for(int i=0; i<=array.length-1;i++) {
                   int count=1;
                    for(int j=i+1; j<array.length;j++){
                        if(array[i].equals(array[j])){
                            count++; array[j]="0";
                        }
                    }
                    if(count>1 && array[i]!="0"){
                        System.out.println(array[i]);}
                }
                break;
            }
            
            default: System.out.println("Error");
        }
    }
}
