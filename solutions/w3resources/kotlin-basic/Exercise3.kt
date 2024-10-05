fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val number = args[0].toIntOrNull()
        
        if (number != null) {
            if (number % 2 == 0) {
                println("$number is even.")
            } else {
                println("$number is odd.")
            }
        } else {
            println("Invalid input. Please enter a valid number.")
        }
    } else {
        println("No input provided. Please provide a number as a command-line argument.")
    }
}
