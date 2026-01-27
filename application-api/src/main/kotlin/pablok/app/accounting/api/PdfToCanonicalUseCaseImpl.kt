package pablok.app.accounting.api

class PdfToCanonicalUseCaseImpl(
    private val extractor: EvidenceExtractor,
    private val parser: EvidenceParser,
    private val merger: CanonicalMerger
) : PdfToCanonicalUseCase {

    override fun run(pdfPath: java.nio.file.Path): PdfImportResult {
        val evidence = extractor.extract(pdfPath)
        val parsed = parser.parse(evidence)
        val canonical = merger.merge(parsed)
        return PdfImportResult(evidence, parsed, canonical)
    }
}
