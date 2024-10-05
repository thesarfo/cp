public boolean or35(int n) {
  if (n < 0) {
    return false;
  }
  return (n % 3 == 0) || (n % 5 == 0);
}
