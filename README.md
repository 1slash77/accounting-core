# accounting-core

Clean-ish core modules for the personal finance pipeline.

Modules:
- :domain — canonical domain entities (bank-independent)
- :ingestion-contracts — source claims + evidence DTOs
- :application-api — ports + use-case API (no DB, no PDF libs)

Intended to be included as a composite build from other repos.

<br>

### Notes:

#### Entity hierarchy (practical view)

Not “inheritance”, but composition:

<code>
PaymentEvent (canonical transaction)<br>
├── SourceTransaction (claims, provenance) [many] <br>
├── Allocation/Split (personal categorization) [0..many] <br>
└── Receipt (evidence) [0..1..many] <br>
└── ReceiptLineItem [many] <br>
</code>

This structure scales:

 - If you never ingest receipts, allocations can still be manual.

 - If you ingest receipts, allocations can be auto-generated and editable.

##### What becomes “canonical” in your current schema?

Right now your transactions table is serving as canonical. With this new model:

 - Rename conceptually: transactions = payment_events

 - Add new tables later:

 - - allocations (or splits)

 - - receipts, receipt_items

You don’t have to rename right away; just know what it represents.
