
class DiscountProduct(productName: String,
                      basePrice: Float,
                      salesPrice: Float,
                      descrip: String? = null,
                      quantity: Int,
                      daysBeforeExpiration: Int
):
    Product(productName, basePrice, salesPrice, descrip, quantity, daysBeforeExpiration)
{
    val discount = mutableListOf<DiscountType>(DiscountType.BLACKFRIDAY, DiscountType.SUMMER, DiscountType.SHORTLIFETIME, DiscountType.NODISC)

}