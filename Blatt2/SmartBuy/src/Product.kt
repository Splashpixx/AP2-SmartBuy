class Product (val productName: String, var basePrice: Float, var salesPrice: Float, var descrip: String? = null, quantity: Int, daysBeforeExpiration: Int ):
    StockUnit(quantity, daysBeforeExpiration), Review {

    override fun stars () : Int = 0
    override fun info() : String = ""

    var profitPerItem: Float? = null
    var valueOfAllItems: Float = 0F
    var salesValueOfAllItems: Float = 0F
    var availableItems: Int = 0


    var reviews = mutableListOf<Review>()
    var stock = mutableListOf<StockUnit>()
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

    override fun toString(): String {
        return "$productName $salesPrice Euro. $descrip"
    }


    fun addStock(items : StockUnit){
       // stock.add(place,this.quantity,this.daysBeforeExpiration)
    }

    fun cleanStock(){
        return
    }

    fun isPreferredQuantityAvailable(preferedQuantity: Int){
        return
    }

    fun takeItems(preferredQuantity: Int) {
        return
    }
}


// @TODO reviews, StockUnits, profitProUnit, ValueOfAll, SaleValueOfAll,