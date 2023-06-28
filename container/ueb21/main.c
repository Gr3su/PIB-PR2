#include <stdio.h>
#include <limits.h>

/**
 * @author Tim Mueller / Yannick Gross
 * @version 28.06.23 / 6:00Uhr
 */

void verdoppeln(int x) {
    x = x * 2;
    printf("Innerhalb der Funktion: %d\n", x);
}

/**
 * Main Methode welche die Aufgaben 2-5 beinhaltet.
 */

int main() {
    double nettopreis, bruttopreis, skonto, mwst;
    int auswahl, fibonacci;
    int zahl = 5;

    printf("\nBitte weahlen sie die Aufgabe aus:\n");

    for (int i = 2; i <= 5; i++) {
        printf("Aufgabe: %1i\n", i);
    }
    printf("Beenden: 6 \n");

    scanf("%i", &auswahl);


    /**
    * Aufgabe 2 welche auf einem eingegebenen Nettopreis 20% Mehrwertsteuer aufrechnet und danach 2% Skonto abzieht.
    */

    if(auswahl == 2) {
        // Eingabe des Nettopreises
        printf("Geben Sie den Nettopreis in Euro ein: ");
        scanf("%lf", &nettopreis);

        // Berechnung der Mehrwertsteuer
        mwst = 0.2 * nettopreis;

        // Berechnung des Bruttopreises
        bruttopreis = nettopreis + mwst;

        // Berechnung des Skontos
        skonto = 0.02 * bruttopreis;

        // Ausgabe der Ergebnisse
        printf("Nettopreis             Euro %8.2f\n", nettopreis);
        printf("+ 20%% MwSt             Euro %8.2f\n", mwst);
        printf("%37s\n", "=====================================");
        printf("Bruttopreis            Euro %8.2f\n", bruttopreis);
        printf("- 2%% Skonto            Euro %8.2f\n", skonto);
        printf("%37s\n", "=====================================");
        printf("Rechnungsbetrag        Euro %8.2f\n", bruttopreis - skonto);

        main();
        return 0;

    }

    /**
    * Aufgabe 3 welche eine n (anzahl) einließt und daraus die ersten Fibonacci Zahlen berechnet.
    */

    if(auswahl == 3) {
        // Eingabe der Anzahl der Fibonacci-Zahlen
        printf("Geben Sie die Anzahl der Fibonacci-Zahlen ein: ");
        scanf("%d", &fibonacci);

        // Überprüfen, ob n gültig ist
        while (fibonacci <= 0) {
            printf("Ungueltige Eingabe. Die Anzahl der Fibonacci-Zahlen muss groeßer als 0 sein.\n");

            printf("Geben Sie die Anzahl der Fibonacci-Zahlen ein: ");
            scanf("%d", &fibonacci);
        }

        // Berechnung und Ausgabe der Fibonacci-Zahlen
        int fib1 = 0;   // Erstes Fibonacci-Zahl
        int fib2 = 1;   // Zweite Fibonacci-Zahl

        printf("Die ersten %d Fibonacci-Zahlen sind:\n", fibonacci);
        printf("%d\n", fib1);   // Ausgabe der ersten Fibonacci-Zahl

        if (fibonacci > 1) {
            printf("%d\n", fib2);   // Ausgabe der zweiten Fibonacci-Zahl

            // Berechnung und Ausgabe der restlichen Fibonacci-Zahlen
            for (int i = 3; i <= fibonacci; i++) {
                int fib = fib1 + fib2;
                printf("%d\n", fib);

                fib1 = fib2;
                fib2 = fib;
            }
        }
        main();
        return 0;
    }

    /**
    * Aufgabe 4 gibt die maximalen und minimalen Werte der Typen char, short, int, unsigned char, unsigned
    *  short und unsigned int aus.
    */

    if(auswahl == 4) {

        printf("maximale und minamale Werte manuell eingegeben: \n\n");


        printf("Datentyp          Min-Wert             Max-Wert\n");
        printf("====================================================\n");

        // char
        printf("char              %2d        %12d\n", -128, 127);

        // short
        printf("short             %2d        %12d\n", -32768, 32767);

        // int
        printf("int               %2d        %12d\n", -2147483648, 2147483647);

        // unsigned char
        printf("unsigned char     %2u        %17u\n", 0, 255);

        // unsigned short
        printf("unsigned short    %2u        %17u\n", 0, 65535);

        // unsigned int
        printf("unsigned int      %2u        %17u\n\n", 0, 4294967295);

        printf("maximale und minamale Werte mit der Bibliothek limits.h: \n\n");


        printf("Datentyp          Min-Wert             Max-Wert\n");
        printf("====================================================\n");

        // char
        printf("char              %2d        %12d\n", CHAR_MIN, CHAR_MAX);

        // short
        printf("short             %2d        %12d\n", SHRT_MIN, SHRT_MAX);

        // int
        printf("int               %2d        %12d\n", INT_MIN, INT_MAX);

        // unsigned char
        printf("unsigned char     %2d        %17u\n", 0, UCHAR_MAX);

        // unsigned short
        printf("unsigned short    %2d        %17u\n", 0, USHRT_MAX);

        // unsigned int
        printf("unsigned int      %2d        %17u\n", 0, UINT_MAX);

        main();
        return 0;
    }

    /**
    * Aufgabe 5 beschreibt mit hilfe einer methode das call-by-value-Prinzip.
    */

    if(auswahl == 5) {
        printf("Vor dem Aufruf der Funktion: %d\n", zahl);

        verdoppeln(zahl);

        printf("Nach dem Aufruf der Funktion: %d\n", zahl);

        main();
        return 0;

    }

    if(auswahl == 6) {
        return 0;
    }

    else{
        printf("Bitte geben sie eine Zahl von 2-6 ein", zahl);

        main();
        return 0;
    }
}
