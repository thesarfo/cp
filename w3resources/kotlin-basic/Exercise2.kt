fun main(args: Array) {
    if (args.isNotEmpty()) {
        val name = args[0]
        println("Entered name: $name")
    } else {
        println("No name provided. Please provide a name as a command-line argument.")
    }
} 