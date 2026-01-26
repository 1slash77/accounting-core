# accounting-core

Clean-ish core modules for the personal finance pipeline.

Modules:
- :domain — canonical domain entities (bank-independent)
- :ingestion-contracts — source claims + evidence DTOs
- :application-api — ports + use-case API (no DB, no PDF libs)

Intended to be included as a composite build from other repos.