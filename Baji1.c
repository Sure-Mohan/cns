#include <stdio.h>
int main() {
char *str = "Hello World";
int i = 0;
while(str[i] != '\0') {
printf("AND=%c OR=%c XOR=%c\n", str[i] & 127, str[i] | 127, str[i] ^ 127);
i++;
}
}
