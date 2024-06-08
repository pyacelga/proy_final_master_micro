package masterspringbootfinalProject.masterspringbootfinalProject.service;

import masterspringbootfinalProject.masterspringbootfinalProject.domain.APIResponseDto;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Service
public class PdfService {

    private final TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(String templateName, APIResponseDto responseDto) throws Exception {
        Context context = new Context();
        context.setVariable("responseDto", responseDto);

        String htmlContent = templateEngine.process(templateName, context);

        try (OutputStream os = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, "/");
            builder.toStream(os);
            builder.run();

            return ((ByteArrayOutputStream) os).toByteArray();
        }
    }
}

