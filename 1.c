#include <stdio.h>
int main() {
    char *str = "Hello World";
    int i = 0;
    printf("Original String: %s\n", str);
    printf("\nBitwise AND with 127:\n");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c ", str[i] & 127);
    }
    printf("\n\nBitwise OR with 127:\n");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c ", str[i] | 127);
    }
    printf("\n\nBitwise XOR with 127:\n");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c ", str[i] ^ 127);
    }
    printf("\n");
    return 0;
}
