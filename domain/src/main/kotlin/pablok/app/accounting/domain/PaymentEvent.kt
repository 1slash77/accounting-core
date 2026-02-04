package pablok.app.accounting.domain

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

/**
 * Canonical "payment event" (what the app believes happened after merging sources).
 *
 * Intentionally bank-independent: represents one money movement.
 * Later you can attach receipt items and allocations/splits to this event.
 */
data class PaymentEvent(
    /** Stable id in your domain (not necessarily the bank's id). */
    val id: String = UUID.randomUUID().toString(),

    /** Operation time if known (maybe null for date-only sources). */
    val occurredAt: Instant? = null,

    /** Posting/settlement time if known. */
    val postedAt: Instant? = null,

    /** Absolute amount; direction is stored separately. */
    val amount: BigDecimal,

    /** Currency code, e.g. "RUB", "USD". */
    val currency: String,

    /** IN (credit) or OUT (debit) relative to the account. */
    val direction: Direction,

    /** Posted / Hold / Unknown at the canonical level. */
    val status: PostingStatus = PostingStatus.UNKNOWN,

    /** Statement description, as human-readable text. */
    val description: String,

    /** Normalized counterparty/merchant if available. */
    val counterpartyName: String? = null,

    /** Merchant Category Code if available. */
    val mcc: String? = null,

    /** Bank-independent semantic hints derived from sources (optional). */
    val opHints: Set<OpSubClass> = emptySet(),

    /** Stable fingerprint used for dedup/merge. */
    val fingerprint: String
)
