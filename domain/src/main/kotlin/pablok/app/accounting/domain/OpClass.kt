package pablok.app.accounting.domain

/** High-level semantic class of an operation (bank-independent taxonomy). */
enum class OpClass {
    CARD,
    TRANSFER,
    CASH,
    FEE,
    INCOME,
    DEPOSIT,
    LOAN,
    TAX_GOV,
    BILL,
    NON_OPERATION,

    UNKNOWN
}
