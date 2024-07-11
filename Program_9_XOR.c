#include <stdio.h>
int main()
{
    // Initialize the string
    char *str = "Hello world";
    // Print the original string
    printf("Original string: %s\n", str);
    // Perform OR, AND, and XOR operations with 127 and display the results
    printf("Character\tOR with 127\tAND with 127\tXOR with 127\n");
    printf("---------\t-----------\t-------------\t-------------\n");
    for (int i = 0; str[i] != '\0'; i++)
    {
        char orResult = str[i] | 127;
        char andResult = str[i] & 127;
        char xorResult = str[i] ^ 127;
        printf("%c\t\t%c\t\t%c\t\t%c\n", str[i], orResult, andResult, xorResult);
    }
    return 0;
}
