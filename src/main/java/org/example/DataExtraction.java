package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    @Test
    public void task() throws IOException {
//        File file=new File("C:\\Users\\Emp ID - 1485\\Downloads\\sample-pdf-file.pdf");
//        FileInputStream fis=new FileInputStream(file);
//        PDDocument document=PDDocument.load(fis);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/search?q=pdf+file+for+sample&oq=pdf+file+for+sam&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBggBEEUYOTIICAIQABgWGB4yCAgDEAAYFhgeMggIBBAAGBYYHjIICAUQABgWGB4yCAgGEAAYFhgeMggIBxAAGBYYHjIICAgQABgWGB4yCggJEAAYhgMYigXSAQg5NTk2ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("//h3[contains(text(),'Simple')]")).click();
        String urlstring=driver.getCurrentUrl();
        URL url=new URL(urlstring);
        PDDocument document=PDDocument.load(url.openStream());




        System.out.println(document.getPages().getCount());
        PDFTextStripper pdfTextStripper=new PDFTextStripper();
        String doctext=pdfTextStripper.getText(document);
        Assert.assertTrue(doctext.contains("use"));
        System.out.println(doctext);
        document.close();
        driver.close();



    }

}
