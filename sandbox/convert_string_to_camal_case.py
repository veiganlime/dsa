# DESCRIPTION:

# Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.

# Examples

# "the-stealth-warrior" gets converted to "theStealthWarrior"

# "The_Stealth_Warrior" gets converted to "TheStealthWarrior"

# "The_Stealth-Warrior" gets converted to "TheStealthWarrior"


def camal_case(text):
    if not text:
        return ""
    words = text.replace("-", " ").replace("_", " ").split()
    first_word = words[0]
    camal_cased = [first_word] + [word.capitalize() for word in words[1:]]
    return ''.join(camal_cased)


to_camal_case = camal_case("The_Stealth_Warrior")
print(to_camal_case)