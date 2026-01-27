package pablok.app.accounting.ingestion

import java.time.Instant
import java.util.UUID

data class RawExtractedItem(
    /** Primary key (UUID). Stable identifier of this evidence atom. */
    val id: String = UUID.randomUUID().toString(),

    /** Order of this item within the batch (0..N-1). Preserves original extraction sequence. */
    val itemIndex: Int,

    /** What kind of evidence this is (PDF row, header KV, UI item, etc.). */
    val itemKind: RawItemKind,

    /** Optional page number in the PDF (convention: 1-based unless extractor decides otherwise). */
    val page: Int? = null,

    /** Optional raw text line as extracted (debug + exact reproduction). */
    val rawLine: String? = null,

    /** Optional JSON blob representing extracted table cells. */
    val cellsJson: String? = null,

    /** Optional JSON blob with extra structured details (extractor-specific). */
    val detailsJson: String? = null,

    /** Optional JSON blob for UI sources. */
    val uiMetaJson: String? = null,

    /** Timestamp (ms since epoch) when this evidence item was created in-memory. */
    val createdAtMs: Long = Instant.now().toEpochMilli()
)
