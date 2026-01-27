package pablok.app.accounting.api

import pablok.app.accounting.ingestion.RawExtractedItem
import java.nio.file.Path

/** Extractor is layout-aware but meaning-agnostic: it emits evidence atoms. */
fun interface EvidenceExtractor {
    fun extract(pdfPath: Path): List<RawExtractedItem>
}
