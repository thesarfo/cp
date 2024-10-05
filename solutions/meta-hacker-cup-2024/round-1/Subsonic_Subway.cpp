#include <iostream>
#include <vector>
#include <cmath>
#include <fstream>

const int MAX_N = 10000000;

std::vector<bool> is_prime(MAX_N + 1, true);
std::vector<int> primes;

void sieve_of_eratosthenes() {
    is_prime[0] = is_prime[1] = false;
    for (int i = 2; i * i <= MAX_N; i++) {
        if (is_prime[i]) {
            for (int j = i * i; j <= MAX_N; j += i) {
                is_prime[j] = false;
            }
        }
    }
    for (int i = 2; i <= MAX_N; i++) {
        if (is_prime[i]) {
            primes.push_back(i);
        }
    }
}

int count_subtractorizations(int N) {
    int count = 0;
    int N_squared = N * N;
    
    for (int i = 0; i < primes.size() && primes[i] <= N_squared; i++) {
        for (int j = i; j < primes.size() && primes[j] <= N_squared; j++) {
            int diff = primes[j] - primes[i];
            if (diff > 0 && diff <= N_squared && is_prime[diff]) {
                count++;
            }
        }
    }
    
    return count;
}

int main() {
    sieve_of_eratosthenes();
    
    std::ifstream input_file("input.txt");
    std::ofstream output_file("output.txt");
    
    if (!input_file.is_open() || !output_file.is_open()) {
        std::cerr << "Error opening files!" << std::endl;
        return 1;
    }
    
    int T;
    input_file >> T;
    
    for (int case_num = 1; case_num <= T; case_num++) {
        int N;
        input_file >> N;
        
        int result = count_subtractorizations(N);
        
        output_file << "Case #" << case_num << ": " << result << std::endl;
    }
    
    input_file.close();
    output_file.close();
    
    return 0;
}