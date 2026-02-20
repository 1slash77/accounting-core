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

    val counterpartyName: String? = null,
    val mcc: String? = null,

    /** Source-flavored category label, not stable taxonomy. */
    val categoryHint: String? = null,

    val rawOperationId: String? = null,

    /** Bank-independent semantic hint tokens inferred by bank-specific logic. */
    val opHints: Set<OpSubClass> = emptySet(),

    val description: String,

    /** Optional JSON blob with extra structured details. */
    val detailsJson: String? = null,
) {
    enum class DetailKey(key: String) {
        UNPARSED("unparsed"),
        CARD("card"),
        PAYMENT_METHOD("payment_method"),
        EXPECTED_UNBLOCK_DATE("expected_unblock_date"),
        RESERVED_AMOUNT("reserved_amount"),
        CITY("city"),
        BANK_REF("bank_ref"),

        MERCHANT_REF("merchant_ref"),
        MERCHANT_COUNTRY("merchant_country"),
        MERCHANT_CITY("merchant_city"),
        MERCHANT_LOCALITY("merchant_locality"),
        MERCHANT_TAG("merchant_tag"),
        MERCHANT_SITE_ID("merchant_site_id"),
        MERCHANT_QUALIFIER("merchant_qualifier"),
    }
}
