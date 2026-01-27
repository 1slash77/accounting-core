package pablok.app.accounting.api

import pablok.app.accounting.domain.PaymentEvent
import pablok.app.accounting.ingestion.ParsedTransaction
import pablok.app.accounting.ingestion.RawExtractedItem
import java.nio.file.Path

interface PdfToCanonicalUseCase {
    fun run(pdfPath: Path): PdfImportResult
}

data class PdfImportResult(
    val evidence: List<RawExtractedItem>,
    val parsed: List<ParsedTransaction>,
    val canonical: List<PaymentEvent>
)
