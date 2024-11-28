package lotto

class User(
    private var amount: Amount,
    private var manualLottos: Lottos = Lottos(emptyList()),
    private var autoLottos: Lottos = Lottos(emptyList())
) {
    val totalLottos: Lottos
        get() = manualLottos.merge(autoLottos)
    val autoLottoSize: Int
        get() = autoLottos.size
    val manualLottoSize: Int
        get() = manualLottos.size
    val totalLottoSize: Int
        get() = totalLottos.size
    val totalBuyAmount: Amount
        get() = totalLottos.totalAmount

    fun buyManualLottos(lottos: Lottos) {
        val requiredAmount = lottos.totalAmount
        if (amount.isLessThan(requiredAmount)) {
            throw IllegalArgumentException("수동 구매 금액이 부족합니다.")
        }
        manualLottos = lottos
        amount = amount.minus(requiredAmount)
    }

    fun buyAutoLotto(autoMachine: (amount: Amount) -> Lottos) {
        autoLottos = autoMachine(amount)
        amount = amount.minus(autoLottos.totalAmount)
    }

    fun match(
        lastWeekNumbers: Lotto,
        bonus: Boolean,
    ): Ranks {
        return Ranks.fromGroupBy(totalLottos.match(lastWeekNumbers, bonus))
    }
}
