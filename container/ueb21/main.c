#include <stdio.h>
#include <limits.h>

/**
 * @author Tim Mueller / Yannick Gross
 * @version 28.06.23 / 6:00Uhr
 */
 int fibonacci(void);
 int bruttoRechner(void);
int minMaxFinder(void);
int callByValue(void);
int verdoppeln(int value);

/**
 * Main Methode welche die Aufgaben 2-5 beinhaltet.
 */

int main() {
    while(1){
        //Menue-Prompt
        printf("\n%s\n%-3d : %s\n","Bitte waehlen Sie aus:", 1, "Dialog beenden");
        for(int i = 2; i < 6; i++){
            printf("%-3d : %7s %d\n", i, "Aufgabe", i);
        }

        //Eingabe-Ueberpruefung
        int errorCode = 0;
        int menuaWahl = 0;
        while (!errorCode) {
            printf("%s\n","Geben Sie die Aufgabennummer ein: ");
            errorCode = scanf("%d", &menuaWahl);
            if(errorCode < 1 ||
                menuaWahl < 1 ||
                menuaWahl > 5){
                printf("%s\n", "Bitte eine Ganzzahl zwischen 1 und 5 eingeben:");
                char dummy;
                scanf("%c", &dummy);
            }
        }
        printf("\n");

        switch (menuaWahl) {
            case 1:
                return 0;

            case 2:
                bruttoRechner();
                break;

            case 3:
                fibonacci();
                break;

            case 4:
                minMaxFinder();
                break;

            case 5:
                callByValue();
                break;

            default:
                printf("%s\n","Unerwarteter Fehler");
                break;
        }
    }

}

/**
 * Aufgabe 2:
 * Berechnet zu einem eingegebenen Preis 20% Mehrwertsteuer dazu, zieht dann 2% Skonto ab und gibt jeden
 * Rechnungsschritt formatiert aus.
 *
 * @return 0
 */
int bruttoRechner(void){
    double nettopreis, bruttopreis, mwst, skonto;
    int errorCode = 0;

    // Eingabe des Nettopreises
    while (!errorCode) {
        printf("%s\n","Geben Sie den Nettopreis in Euro ein: ");
        errorCode = scanf("%lf", &nettopreis);
        if(errorCode < 1){
            printf("%s\n", "Bitte eine Gleitkommazahl eingeben:");
            char trash;
            scanf("%c", &trash);
        }
    }


    // Berechnung der Mehrwertsteuer
    mwst = 0.2 * nettopreis;

    // Berechnung des Bruttopreises
    bruttopreis = nettopreis + mwst;

    // Berechnung des Skontos
    skonto = 0.02 * bruttopreis;

    // Ausgabe der Ergebnisse
    printf("%-15s%15s%8.2f\n", "Nettopreis", "Euro",nettopreis);
    printf("%-15s%15s%8.2f\n", "+20%MwSt", "Euro", mwst);
    printf("%37s\n", "=====================================");
    printf("%-15s%15s%8.2f\n","Bruttopreis", "Euro", bruttopreis);
    printf("%-15s%15s%8.2f\n","-2% Skonto", "Euro", skonto);
    printf("%37s\n", "=====================================");
    printf("%-15s%15s%8.2f\n", "Rechnungsbetrag","Euro", bruttopreis - skonto);

    return 0;
}

/**
 * Aufgabe 3
 * Gibt die Fibonacci-Folge aus bis zum gewuenschten Index.
 *
 * @return 0
 */
int fibonacci(void){
    int fibonacciEnde;
    int errorCode = 0;
    int fibA = 0;
    int fibB = 1;
    int fibC;

    printf("%s\n", "Bitte gebe die Zahl ein bis wohin die Fibonacci-Folge abgebildet werden soll:");

    //Fragt nach einer oberen Schranke bis eine Ganzzahl eingegeben wurde
    while (!errorCode){
        errorCode = scanf("%d", &fibonacciEnde);
        if(errorCode < 1){
            printf("%s\n", "Bitte gebe eine Ganzzahl ein:");
            char trash;
            scanf("%c", &trash);
        }
    }

    //Gibt die Folge aus und berechnet sie iterativ, fortlaufend weiter
    for(int i = 0; i <= fibonacciEnde; i++){
        printf("%d - ", fibA);
        fibC = fibA + fibB;
        fibA = fibB;
        fibB = fibC;
    }

    return 0;
}

/**
 * Aufgabe 4
 * Findet die minimalen und maximalen Werte die (unsigned) char, (unsigned) short und (unsigned) int annehmen koennen
 * und printet sie aus. Mit dem Vergleich aus der LIMITS Library.
 *
 * @return 0
 */
int minMaxFinder(void){
    printf("%-15s%15s%15s\n","Daten-Typ","Min-Wert","Max-Wert");

    char charMax = 0;
    do{
        charMax++;
    }
    while(charMax > 0);
    printf("%-15s%15d","char", charMax);
    charMax--;
    printf("%15d\n",charMax);


    short shortMax = 0;
    do{
        shortMax++;
    }
    while(shortMax > 0);
    printf("%-15s%15d","short", shortMax);
    shortMax--;
    printf("%15d\n", shortMax);


    int intMax = 0;
    do{
        intMax++;
    }
    while(intMax > 0);
    printf("%-15s%15d","int", intMax);
    intMax--;
    printf("%15d\n",intMax);


    unsigned char unsignedCharMax = 0;
    printf("%-15s%15d","unsigned char", unsignedCharMax);
    unsignedCharMax--;
    printf("%15d\n",unsignedCharMax);


    unsigned short unsignedShortMax = 0;
    printf("%-15s%15d","unsigned short", unsignedShortMax);
    unsignedShortMax--;
    printf("%15d\n",unsignedShortMax);


    unsigned int unsignedIntMax = 0;
    printf("%-15s%15d","unsigned int", unsignedIntMax);
    unsignedIntMax--;
    printf("%15d\n", unsignedIntMax);

    printf("\n%s\n","Aus limits-library:");
    printf("%-15s%15s%15s\n","Daten-Typ","Min-Wert","Max-Wert");
    printf("%-15s%15d%15d\n","char", CHAR_MIN, CHAR_MAX);
    printf("%-15s%15d%15d\n","short", SHRT_MIN, SHRT_MAX);
    printf("%-15s%15d%15d\n","int", INT_MIN, INT_MAX);
    printf("%-15s%15d%15d\n","unsigned char", 0, UCHAR_MAX);
    printf("%-15s%15d%15d\n","unsgined short", 0, USHRT_MAX);
    printf("%-15s%15d%15d\n","unsgined int", 0, UINT_MAX);

    return 0;
}

int callByValue(void){
    short value = 2;
    printf("%-50s%2d\n","Wert der Variable vor Funktionsaufruf:", value);
    verdoppeln(value);
    printf("%-50s%2d\n","Wert der Variable nach Funktionsaufruf:", value);

    return 0;
}

int verdoppeln(int value){
    printf("%-50s%2d\n","Wert der Variable in der Funktion:", value);
    value = value * 2;
    printf("%-50s%2d\n","Wert der Variable in der Funktion, nach Verdopplung:", value);

    return 0;
}