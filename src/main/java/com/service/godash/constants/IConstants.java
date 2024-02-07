package com.service.godash.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IConstants {
    public static final String EMAIL_REGEX="^\\S+@\\S+\\.\\S+$";

    public static final String ERR_EMAIL_LENGTH="Invalid Email";

    public static final String PHONE_REGEX="^&";

    public static final String ERR_PHONE_LENGTH="Invalid Phone Number";

    public static final String BUYER="BUYER";

    public static final String SUPPLIER="SUPPLIER";

    public static final Path rootLocationArticleDir = Paths.get("D:/service/go-dash-images/article/");

    public static final Path rootLocationSampleRequestDir = Paths.get("D:/service/go-dash-images/sample_request/");

    public static String imagePathArticleDir="D:/service/go-dash-images/article/";

    public static String imagePathSampleRequestDir="D:/service/go-dash-images/sample_request/";

}
