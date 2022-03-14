const val DISCOUNT_LOWER = 100_00
const val DISCOUNT_HIGHER_PERCENT = 5
const val DISCOUNT_BONUS_PERCENT = 1

fun main() {
    print("Введите сумму предыдущей покупки в рублях ")
    val lastAmount = (readLine()?.toInt() ?: return) * 1_00
    print("введите,сколько дней назад была сделана предыдущая покупка ")
    val lastBonus = readLine()?.toInt() ?: return
    print("Введите сумму, на которую хотите сейчас совершить покупку ")
    val nowAmount = (readLine()?.toInt() ?: return) * 1_00

    val discount = if (lastAmount <= 1000_00) {
        nowAmount
    } else if (lastAmount > 1000_00 && lastAmount <= 10000_00) {
        nowAmount - DISCOUNT_LOWER
    } else {
        nowAmount - ((nowAmount * DISCOUNT_HIGHER_PERCENT) / 100)
    }

    val totalDiscount = if (lastBonus > 30) discount else discount - ((discount * DISCOUNT_BONUS_PERCENT) / 100)
    val totalPrice = if ((totalDiscount % 100) >= 50) totalDiscount / 100 + 1 else totalDiscount / 100
    print("Сумма Вашей покупки с учетом скидки составляет $totalPrice рублей")
}