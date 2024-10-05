public String missingChar(String str, int n) {
    String newStr = str.substring(0, n);
    String anotherStr = str.substring(n+1, str.length());
    
    return newStr + anotherStr;
  }  