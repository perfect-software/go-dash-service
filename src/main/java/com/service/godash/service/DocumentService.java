package com.service.godash.service;

import com.service.godash.payload.DocumentRequest;

public interface DocumentService {
    void writeToHTMLContent(DocumentRequest documentRequest,String templateType) throws Exception;
}
