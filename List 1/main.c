#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int numerator;
    int denominator;
}Fraction;

int NWD(int a, int b)
{
    int t;
    while (b)
    {
        t = b;
        b = a%b;
        a = t;
    }

    return a;
}

void printFraction(Fraction tmpFra)
{

    if (tmpFra.denominator == 0)
        printf("Nie dziel przez 0!\n");

    else if (tmpFra.numerator == 0)
        printf("%d\n", tmpFra.numerator);

    else if (tmpFra.denominator == 1)
        printf("%d\n", tmpFra.numerator);

    else
        printf("%d/%d\n", tmpFra.numerator, tmpFra.denominator);

}

Fraction shortFraction(Fraction tmpFra)
{
    int nwd = NWD(tmpFra.denominator, tmpFra.numerator);

    tmpFra.numerator = tmpFra.numerator/nwd;
    tmpFra.denominator = tmpFra.denominator/nwd;

    return tmpFra;
}

Fraction changeSign(Fraction tmpFra)
{
    if (tmpFra.denominator < 0)
    {
        tmpFra.numerator *= -1;
        tmpFra.denominator *= -1;
    }

    return tmpFra;
}

Fraction addFractions(Fraction fra1, Fraction fra2)
{
    if (fra1.denominator == fra2.denominator)
    {
        fra2.numerator += fra1.numerator;
    }

    else
    {
        int num = fra2.numerator, den = fra2.denominator;
        fra2.numerator = fra1.numerator*den + num*fra1.denominator;
        fra2.denominator *= fra1.denominator;

        fra2 = shortFraction(fra2);

        fra2 = changeSign(fra2);
    }

    return fra2;
}

Fraction subFractions(Fraction fra1, Fraction fra2)
{
    if (fra1.denominator == fra2.denominator)
    {
        int num = fra2.numerator;
        fra2.numerator = fra1.numerator - num;
    }

    else
    {
        int num = fra2.numerator, den = fra2.denominator;
        fra2.numerator = fra1.numerator*den - num*fra1.denominator;
        fra2.denominator *= fra1.denominator;

        fra2 = shortFraction(fra2);

        fra2 = changeSign(fra2);
    }

    return fra2;
}

Fraction * multFractions(Fraction fra1, Fraction fra2)
{
    Fraction *tmpFra = malloc(sizeof(Fraction));

    tmpFra->numerator = fra1.numerator*fra2.numerator;
    tmpFra->denominator = fra1.denominator*fra2.denominator;

    *tmpFra = shortFraction(*tmpFra);

    *tmpFra = changeSign(*tmpFra);

    return tmpFra;
}

Fraction * divFractions(Fraction fra1, Fraction fra2)
{
    Fraction *tmpFra = malloc(sizeof(Fraction));

    tmpFra->numerator = fra1.numerator*fra2.denominator;
    tmpFra->denominator = fra1.denominator*fra2.numerator;

    *tmpFra = shortFraction(*tmpFra);

    *tmpFra = changeSign(*tmpFra);

    return tmpFra;
}

int main() {

    Fraction tmpFra, tmpFra2;

    printf("Podaj licznik: ");
    scanf("%d", &tmpFra.numerator);

    printf("Podaj mianownik: ");
    scanf("%d", &tmpFra.denominator);

    printf("Podaj licznik: ");
    scanf("%d", &tmpFra2.numerator);

    printf("Podaj mianownik: ");
    scanf("%d", &tmpFra2.denominator);


    Fraction aftAddFra = addFractions(tmpFra, tmpFra2);

    printf("Ulamek po dodaniu: ");
    printFraction(aftAddFra);

    Fraction aftSubFra = subFractions(tmpFra, tmpFra2);

    printf("Ulamek po odejmowaniu: ");
    printFraction(aftSubFra);

    Fraction *aftMultFra = multFractions(tmpFra, tmpFra2);

    printf("Ulamek po mnożeniu: ");
    printFraction(*aftMultFra);

    Fraction *aftDivFra = divFractions(tmpFra, tmpFra2);

    printf("Ulamek po dzieleniu: ");
    printFraction(*aftDivFra);


    return 0;
}