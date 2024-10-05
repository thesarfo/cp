function clearDigits(s: string): string {
    let stack: string[] = [];
    
    for (let char of s) {
        if (/\d/.test(char)) {
            if (stack.length > 0) {
                stack.pop();
            }
        } else {
            stack.push(char);
        }
    }
    
    return stack.join('');
}

