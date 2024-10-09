#ifndef WORDLIST_H
#define WORDLIST_H

struct WordList {
    struct Node* head;
    struct Node* tail;
};

void initWordList(struct WordList* list);
void addWord(struct WordList* list, const char* data);
void removeDuplicates(struct WordList* list);
void printWordList(struct WordList* list);

#endif /* WORDLIST_H */
