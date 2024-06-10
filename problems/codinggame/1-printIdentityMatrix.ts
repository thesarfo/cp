function printIdentityMatrix(size: number) {
    for (let i = 0; i < size; i++) {
        let row = '';
        for (let j = 0; j < size; j++) {
            if (i === j) {
                row += '1';
            } else {
                row += '0';
            }
            if (j < size - 1) {
                row += ' ';
            }
        }
        console.log(row);
    }
}

printIdentityMatrix(n);
