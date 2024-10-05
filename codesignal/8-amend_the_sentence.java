String solution(String s) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);

        if (Character.isUpperCase(currentChar)) {
            char lowercaseChar = Character.toLowerCase(currentChar);

            if (i > 0) {
                result.append(" ");
            }

            result.append(lowercaseChar);
        } else {
            result.append(currentChar);
        }
    }

    return result.toString();
}
