package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        // Set Chrome options for Jenkins (headless environment)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Run without GUI
        options.addArguments("--no-sandbox"); // Required for Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage"); // Prevent memory issues
        options.addArguments("--disable-gpu"); // Optional but safe
        options.addArguments("--remote-allow-origins=*"); // Avoid connection issues

        // Optional: Set Chrome binary path (if needed)
        options.setBinary("/usr/bin/google-chrome");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open a website
            driver.get("https://www.google.com");

            // Print title (for verification in Jenkins logs)
            System.out.println("Page Title: " + driver.getTitle());

            // Wait for few seconds (simulate your delay)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
