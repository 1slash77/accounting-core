package pablok.app.accounting.ingestion

import pablok.app.accounting.domain.Direction
import pablok.app.accounting.domain.OpSubClass
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate

/**
 * Meaning-aware source claim produced by a parser for a single source artifact (PDF/UI).
 *
 * Not canonical truth: multiple ParsedTransactions may later merge into one PaymentEvent.
 */
data class ParsedTransaction(
    val occurredDate: LocalDate? = null,
    val occurredAt: Instant? = null,
    val postedDate: LocalDate? = null,
    val postedAt: Instant? = null,

    val status: TxStatus = TxStatus.UNKNOWN,

    /** Absolute monetary amount (direction is stored separately). */
    val amount: BigDecimal,

    val currency: String,
    val direction: Direction,

    val description: String,
    val counterpartyName: String? = null,
    val mcc: String? = null,

    /** Source-flavored category label, not stable taxonomy. */
    val categoryHint: String? = null,

    val rawOperationId: String? = null,

    /** Bank-independent semantic hint tokens inferred by bank-specific logic. */
    val opHints: Set<OpSubClass> = emptySet()
)
