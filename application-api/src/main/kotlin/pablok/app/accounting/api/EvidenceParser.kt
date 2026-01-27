package pablok.app.accounting.api

import pablok.app.accounting.ingestion.ParsedTransaction
import pablok.app.accounting.ingestion.RawExtractedItem

/** Parser is meaning-aware: it converts evidence atoms into source claims. */
fun interface EvidenceParser {
    fun parse(items: List<RawExtractedItem>): List<ParsedTransaction>
}
