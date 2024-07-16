public String front3(String str) {
    if (str.length() < 3)
        return str + str + str;
    String thr = str.substring(0, 3);
    return thr + thr + thr;
}
