public int intMax(int a, int b, int c) {
  int max;
  
  if (a > b) {
    max = a;
  } else {
    max = b;
  }
  
  if (c > max) {
    max = c;
  }
  
  return max;
}