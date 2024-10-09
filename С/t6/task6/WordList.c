#include "WordList.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
    char data[100];
    struct Node* next;
};

void initWordList(struct WordList* list) {
    list->head = NULL;
    list->tail = NULL;
}

void addWord(struct WordList* list, const char* data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Ошибка выделения памяти\n");
        exit(1);
    }
    strcpy(newNode->data, data);
    newNode->next = NULL;

    if (list->head == NULL) {
        list->head = newNode;
        list->tail = newNode;
    } else {
        list->tail->next = newNode;
        list->tail = newNode;
    }
}

void removeDuplicates(struct WordList* list) {
    struct Node *current = list->head;
    while (current != NULL) {
        struct Node *nextElement = current->next;
        while (nextElement != NULL && strcmp(current->data, nextElement->data) == 0) {
            nextElement = nextElement->next;
        }
        current->next = nextElement;
        list->tail = current;
        current = nextElement;
    }
}

void printWordList(struct WordList* list) {
    struct Node* current = list->head;
    while (current != NULL) {
        printf("%s ", current->data);
        current = current->next;
    }
    printf("\n");
}