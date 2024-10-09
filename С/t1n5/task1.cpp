#include <iostream>
#include <cmath>

double factorial(int n) {
    if (n == 0)
        return 1;
    double result = 1;
    for (int i = 1; i <= n; ++i) {
        result *= i;
    }
    return result;
}

double calculateSeriesSum(int n) {
    double sum = 0;
    for (int i = 0; i <= n; ++i) {
        sum += 1 / factorial(2 * i);
    }
    return sum;
}

int main() {
    int n;
    std::cout << "Введите количество итераций для вычисления суммы ряда: ";
    std::cin >> n;

    double sum = calculateSeriesSum(n);

    std::cout << "Значение суммы ряда: " << sum << std::endl;

    return 0;
}