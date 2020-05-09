
open class Product (val productName: String, var basePrice: Float, var salesPrice: Float, var descrip: String? = null, quantity: Int, daysBeforeExpiration: Int ):
    StockUnit(quantity, daysBeforeExpiration), Review {

    override fun stars () : Int = 0
    override fun info() : String = ""

    var profitPerItem: Float? = null
    var valueOfAllItems: Float = 0F
    var salesValueOfAllItems: Float = 0F
    var availableItems: Int = 0


    val reviews = mutableListOf<Review>()
    val stock = mutableListOf<StockUnit>()
         // Calculate stuff
    init {
             println(this.productName + " wurde im sortiment aufgenommen")
             valueOfAllItems = basePrice * quantity
             salesValueOfAllItems = salesPrice * quantity
             availableItems = quantity
             println("Value of all items :" + this.valueOfAllItems)
             println("Sales value of all items :" + this.salesValueOfAllItems)
             println("Availible Items :" + this.availableItems)
    }

    override fun toString () : String = "$productName $salesPrice Euro. $descrip"


    fun addStock( items : StockUnit ){
        if(this.quantity > 0 &&  this.daysBeforeExpiration > 0){
            stock.add(items)
            availableItems += quantity
            stockSort()
        } else {
            println("nope")
        }
    }

    fun addReview( review : Review) = reviews.add(review)


    fun cleanStock(){
        stockSort()
        var si = stock.iterator()
        for (i in si){
            var x: Int  = 0
            if(i.quantity == 0 || i.daysBeforeExpiration == 0){
                stock.removeAt(x)
            }
            x += 1
        }
        stockSort()
    }


    fun isPreferredQuantityAvailable(preferedQuantity: Int) = preferedQuantity >= availableItems


    fun takeItems(preferedQuantity: Int) {
        if (preferedQuantity >= availableItems){
            availableItems -= preferedQuantity
            takeOut(preferedQuantity)
        } else {
            var eingabe: String? =  readLine()
            eingabe = eingabe?.toUpperCase()
            if (eingabe == "YES") {
                takeOut(availableItems)
                availableItems = 0
                this.cleanStock()
            } else {
                println("Maybe Next Time")
            }
        }
    }

    private fun takeOut(ammount : Int){
        var countDown = ammount
        while (countDown != 0){
            var x = this.stock[0]
            var currentAmmount: Int = countDown
            countDown -= x.quantity
            var loss:Int = currentAmmount - countDown
            if(loss != 0){
                this.stock.removeAt(0)
                stockSort()
            } else  {
                this.stock[0].quantity -= loss
                println("finish")
            }
        }
    }

    private fun stockSort() = this.stock.sortedWith(compareBy{it.daysBeforeExpiration}).reversed()


}