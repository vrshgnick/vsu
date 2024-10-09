#include <stdio.h>
#include <string.h>
#include <locale.h>

typedef struct {
    char name[50];
    int age;
    char major[100];
} Student;

Student students[10];
int count = 0;

void find_student() {
    char name[50];
    printf("Введите имя студента для поиска:\n");
    scanf("%s", name);

    int found = 0;
    for (int i = 0; i < count; i++) {
        if (strcmp(students[i].name, name) == 0) {
            printf("---\n");
            printf("Порядковый номер студента: %d\n", i + 1);
            printf("Имя: %s, ", students[i].name);
            printf("Возраст: %d, ", students[i].age);
            printf("Направление: %s\n", students[i].major);
            printf("---\n");
            found = 1;
        }
    }
    if (!found) {
        printf("Студент с именем %s не найден.\n", name);
    }
}

void add_student() {
    if (count >= 10) {
        printf("Нельзя добавить больше студентов.\n");
        return;
    }

    printf("Введите имя студента: ");
    scanf("%s", students[count].name);
    printf("Введите возраст студента: ");
    scanf("%d", &students[count].age);
    printf("Введите направление студента: ");
    scanf(" %[^\n]s", students[count].major);
    count++;
}

void print_students() {
    if (count == 0) {
        printf("---\n");
        printf("Студенты отсутствуют.\n");
        printf("---\n");
        return;
    }

    for (int i = 0; i < count; i++) {
        printf("---\n");
        printf("Порядковый номер студента: %d\n", i + 1);
        printf("Имя: %s, ", students[i].name);
        printf("Возраст: %d, ", students[i].age);
        printf("Направление: %s\n", students[i].major);
        printf("---\n");
    }
}

void delete_student() {
    int number;
    printf("Введите порядковый номер студента для удаления:\n");
    scanf("%d", &number);
    if (number < 1 || number > count) {
        printf("Неверный порядковый номер. Пожалуйста, попробуйте снова.\n");
        return;
    }
    for (int i = number - 1; i < count - 1; i++) {
        students[i] = students[i + 1];
    }
    count--;
    printf("Студент успешно удален.\n");
}

int main() {
    int choice;
    do {
        printf("---\n");
        printf("1. Добавить студента\n");
        printf("2. Удалить студента\n");
        printf("3. Список студентов\n");
        printf("4. Поиск по имени\n");
        printf("---\n");
        printf("Выбрать опцию: ");
        scanf("%d", &choice);

        if (choice == 1) {
            add_student();
        } else if (choice == 2) {
            delete_student();
        } else if (choice == 3) {
            print_students();
        } else if (choice == 4) {
            find_student();
        } else {
            printf("Команда не существует. Пожалуйста, выберите опцию от 1 до 4.\n");
        }
    } while (choice >= 1 && choice <= 4);

    return 0;
}
