package com.service.godash.service.impl;

import com.service.godash.payload.DocumentRequest;
import com.service.godash.service.DocumentService;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.context.Context;

import java.io.*;

import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public void writeToHTMLContent(DocumentRequest documentRequest,String templateType) throws Exception {
        String templateName= validateTemplate(templateType);
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("/document/assets");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("PO",documentRequest);
        String htmlOutput=templateEngine.process(templateName,context);
        String pdfFileName="abc";
        String outputPathHtml="/document/html/abc.html";
        generateHTMLFile(outputPathHtml,htmlOutput);
        convertToPDF(htmlOutput,pdfFileName);
    }

    private void convertToPDF(String htmlOutput, String pdfFileName) throws Exception {
        try {
            String baseUrl="file:///"+"/document/assets/";
            String fullPath="/document/pdfs/"+pdfFileName+".pdf";
            Document document= Jsoup.parse(htmlOutput);
            document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            OutputStream os = new FileOutputStream(fullPath);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(document.html(),baseUrl);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        }
        catch (Exception ex){
            throw new Exception("Could not generate PDF");
        }
    }

    private void generateHTMLFile(String outputPathHtml, String htmlOutput) throws Exception {
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter(outputPathHtml));
            writer.write(htmlOutput);
            writer.close();
        }
        catch (Exception ex){
            throw new Exception("Could not generate HTML");
        }
    }

    private String validateTemplate(String templateType) throws Exception {
        String templateName=templateType+"_"+"document";
        String fileName="/document/assets/"+templateName+".html";
        File file = new File(fileName);
        if(!file.exists()) {
            throw new Exception("File does not exists");
        }
        return templateName;
    }

}
