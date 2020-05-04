abstract class StockUnit(var quantity: Int, val daysBeforeExpiration: Int) {
    private var isExpired: Boolean = false
    private var isExpiringSoon: Boolean = false

}
