#include <stdio.h>
#include "WordList.h"

int main() {
    struct WordList list;
    initWordList(&list);

    char input[100];
    int choice;

    do {
        printf(" ");
        printf("----------------------------------------------------\n");
        printf("1. Добавить слово\n");
        printf("2. Удалить дубликаты\n");
        printf("3. Список слов\n");
        printf("----------------------------------------------------\n");
        printf("Выбрать опцию: ");
        printf(" ");
        scanf("%d", &choice);

        if (choice == 1) {
            printf("Введите слово: ");
            scanf("%s", input);
            addWord(&list, input);
        } else if (choice == 2) {
            removeDuplicates(&list);
            printf("----------------------------------------------------\n");
            printWordList(&list);
            printf("----------------------------------------------------\n");
        } else if (choice == 3) {
            printf("----------------------------------------------------\n");
            printWordList(&list);
            printf("----------------------------------------------------\n");
        } else {
            printf("Неверный выбор\n");
        }

    } while (choice != 4);

    return 0;
}


