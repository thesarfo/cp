/* My solution */
public String front22(String str) {
  if (str.length() < 1){
    return str;
  }
  if (str.length() == 1){
    String third = str.substring(0, 1);
    return (third + str.concat(third));
  }
  if (str.length() > 1){
    String third = str.substring(0, 2);
  
    return (third + str.concat(third));
  }
  return str;
}

/* Standard solution */
public String front22(String str) {
    // First figure the number of chars to take
    int take = 2;
    if (take > str.length()) {
        take = str.length();
    }

    String front = str.substring(0, take);
    return front + str + front;
}