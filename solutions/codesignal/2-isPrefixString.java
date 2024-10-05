static boolean[] solution(String[] strings, String[] sources) {
    boolean[] output = new boolean[sources.length];

    for (int i = 0; i < sources.length; i++) {
        output[i] = isPrefixString(strings, sources[i]);
        }

    return output;
    }

static boolean isPrefixString(String[] strings, String source) {
    StringBuilder prefix = new StringBuilder();
        
    for (String str : strings) {
        prefix.append(str);
        if (prefix.toString().equals(source)) {
            return true;
        } else if (prefix.length() > source.length()) {
            return false;
        }
    }

    return false;
}