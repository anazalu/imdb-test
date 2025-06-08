package org.example.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AllureAttachments {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        try {
            File screenshot = Screenshots.getLastScreenshot();
            if (screenshot == null) {
                return new byte[0];
            }
            return Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
