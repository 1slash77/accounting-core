package pablok.app.accounting.api

import pablok.app.accounting.domain.PaymentEvent
import pablok.app.accounting.ingestion.ParsedTransaction

/** Bank-independent merge policy: merges source claims into canonical payment events. */
fun interface CanonicalMerger {
    fun merge(source: List<ParsedTransaction>): List<PaymentEvent>
}
