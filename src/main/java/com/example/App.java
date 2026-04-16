package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        // Set Chrome options for Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // ✅ FIX: correct Chrome binary path
        options.setBinary("/usr/bin/google-chrome-stable");

        // Initialize driver
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");

            // Print title (for Jenkins console)
            System.out.println("Page Title: " + driver.getTitle());

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
