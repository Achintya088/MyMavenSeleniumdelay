package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--remote-debugging-port=9222");

        // 🔥 CRITICAL FIX (Snap Jenkins workaround)
        options.addArguments("--user-data-dir=/tmp/chrome-user-data");
        options.addArguments("--data-path=/tmp/chrome-data");

        options.setBinary("/usr/bin/google-chrome-stable");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            System.out.println("Page Title: " + driver.getTitle());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
