#include <iostream>
#include <unordered_set>
using namespace std;

void findUniqueDigits(int num, unordered_set<int>& uniqueDigits);

void findUniqueDigitsHelper(int num, unordered_set<int>& uniqueDigits) {
    if (num > 0) {
        int digit = num % 10;
        uniqueDigits.insert(digit);
        findUniqueDigits(num / 10, uniqueDigits);
    }
}

void findUniqueDigits(int num, unordered_set<int>& uniqueDigits) {
    if (num > 0) {
        findUniqueDigitsHelper(num, uniqueDigits);
    }
}

int main() {
    int number;
    cout << "Введите целое число: ";
    cin >> number;

    unordered_set<int> uniqueDigits;
    findUniqueDigits(number, uniqueDigits);

    cout << "Уникальные цифры в числе " << number << " : ";
    for (int digit : uniqueDigits) {
        cout << digit << " ";
    }
    cout << endl;

    return 0;
}
