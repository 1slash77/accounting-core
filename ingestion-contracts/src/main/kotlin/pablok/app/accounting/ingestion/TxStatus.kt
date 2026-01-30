package pablok.app.accounting.ingestion

/** Source-level posting status as seen in a statement/source. */
enum class TxStatus {
    POSTED,
    HOLD,
    REVERSAL,
    UNKNOWN
}
