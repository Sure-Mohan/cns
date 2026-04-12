#include <stdio.h>
int main() {
    char *str = "Hello World";
    int i = 0;
    printf("Original String: %s\n", str);
    printf("After XOR with 0: ");
    while (str[i] != '\0') {
        printf("%c", str[i] ^ 0);
        i++;
    }

   return 0;
}
