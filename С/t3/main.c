#include <stdio.h>

#define MAX_ROWS 100

void printRelation(int relation[MAX_ROWS][2], int rows) {
    for (int i = 0; i < rows; i++) {
        printf("(%d, %d)\n", relation[i][0], relation[i][1]);
    }
}

int isInRelation(int key, int relation[MAX_ROWS][2], int rows) {
    for (int i = 0; i < rows; i++) {
        if (relation[i][0] == key) {
            return 1; // найдено
        }
    }
    return 0; // не найдено
}

void difference(int relation1[MAX_ROWS][2], int rows1, int relation2[MAX_ROWS][2], int rows2, int result[MAX_ROWS][2], int *resultRows) {
    *resultRows = 0;
    for (int i = 0; i < rows1; i++) {
        if (!isInRelation(relation1[i][0], relation2, rows2)) {
            result[*resultRows][0] = relation1[i][0];
            result[*resultRows][1] = relation1[i][1];
            (*resultRows)++;
        }
    }
}

int main() {
    int relation1[MAX_ROWS][2];
    int relation2[MAX_ROWS][2];

    int rows1, rows2;

    // Ввод первой таблицы
    printf("Введите количество строк в первой таблице: ");
    scanf("%d", &rows1);
    printf("Введите данные для первой таблицы (ключ, значение):\n");
    for (int i = 0; i < rows1; i++) {
        printf("Строка %d: ", i + 1);
        scanf("%d %d", &relation1[i][0], &relation1[i][1]);
    }

    // Ввод второй таблицы
    printf("Введите количество строк во второй таблице: ");
    scanf("%d", &rows2);
    printf("Введите данные для второй таблицы (ключ, значение):\n");
    for (int i = 0; i < rows2; i++) {
        printf("Строка %d: ", i + 1);
        scanf("%d %d", &relation2[i][0], &relation2[i][1]);
    }

    int result[MAX_ROWS][2];
    int resultRows;

    difference(relation1, rows1, relation2, rows2, result, &resultRows);

    printf("Результат операции разности:\n");
    printRelation(result, resultRows);

    return 0;
}