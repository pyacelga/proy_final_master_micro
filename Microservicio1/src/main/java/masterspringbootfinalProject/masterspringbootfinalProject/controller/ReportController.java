package masterspringbootfinalProject.masterspringbootfinalProject.controller;

import jakarta.servlet.http.HttpServletResponse;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.APIResponseDto;
import masterspringbootfinalProject.masterspringbootfinalProject.service.PdfService;
import masterspringbootfinalProject.masterspringbootfinalProject.service.UserService;
import masterspringbootfinalProject.masterspringbootfinalProject.service.impl.UserServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportController {

    final Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private PdfService pdfService;

    @Autowired
    private UserService userService;

    @GetMapping("/pdf")
    public void generatePdf(@RequestParam("userIdNumb") String userIdNumb, HttpServletResponse response) throws Exception {
        APIResponseDto responseDto = userService.getGralInfoAccount(userIdNumb);

        logger.info("VALOR RECIBIDO: "+userIdNumb);
        byte[] pdf = pdfService.generatePdf("reportAccount", responseDto);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=ReporteFinanciero.pdf");
        response.getOutputStream().write(pdf);
    }
}

