package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // ✅ Correct syntax (comma-separated)
        options.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--remote-allow-origins=*"
        );

        options.setBinary("/usr/bin/google-chrome-stable");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            System.out.println("Title: " + driver.getTitle());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
