
open class StockUnit(var quantity: Int, var daysBeforeExpiration: Int) {
    private var isExpired: Boolean = false
    private var isExpiringSoon: Boolean = false
}
