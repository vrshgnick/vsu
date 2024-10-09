#include <iostream>
#include <string>

std::string remove_every_second_triplet(const std::string& input_string) {
    std::string output_string;
    int length = input_string.length();
    for (int i = 0; i < length; i += 3) {
        if ((i / 3) % 2 == 0) {
            if (i + 2 < length)
                output_string += input_string.substr(i, 3);
            else
                output_string += input_string.substr(i);
        }
    }
    return output_string;
}

int main() {
    std::string input_str;
    std::cout << "Введите строку: ";
    std::cin >> input_str;
    std::string output_str = remove_every_second_triplet(input_str);
    std::cout << output_str << std::endl;

    return 0;
}