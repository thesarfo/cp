public String backAround(String str) {
      
  String newStr = str.substring(str.length() - 1);
  
  return (newStr + str + newStr);
}
