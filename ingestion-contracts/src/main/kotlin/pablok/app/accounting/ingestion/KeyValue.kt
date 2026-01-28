package pablok.app.accounting.ingestion

import kotlinx.serialization.Serializable

/** Generic evidence KV (e.g., PDF header fields, UI labels). */
@Serializable
data class KeyValue(val key: String, val value: String)
