
fun main() {


    val cheese: Product = Product("Käse", 0.5F,2.49F,"Nussig im abgang", 30,25)
    // println(cheese.productName)
    println("-----------------")
    println(cheese)
    println("Hat alles funktioniert")
    cheese.addStock(StockUnit(10,5))

    fun info(){
        println("hi")
    }

    do {
        var eingabe =  readLine()
            eingabe = eingabe?.toUpperCase()
            println(eingabe)
    } while (eingabe == "YES")
}

