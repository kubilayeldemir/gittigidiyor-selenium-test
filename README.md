# gittigidiyor-selenium-test
gittigidiyor-selenium-test is made with Java-Selenium-jUnit. Tests Turkish e-commerce website gittigidiyor.com with selenium.


## Installation

In order for the project to work, chromedriver.exe appropriate for your chrome version must be added to the root of the project.
Install maven dependencies and run 
```
SeleniumCaseStudy/src/main/java/Test/GittiGidiyorMainTest.java
```
file as jUnit Test.

LaunchChrome.java file was used in early development process. You can ignore it.

## What it does?

- Goes to www.gittigidiyor.com website.
- Checks that the home page is opened. Logins to the site
- Checks Login process.
- Enters the word "bilgisayar"(which means computer in Turkish) in the search box and search.
- Opens the 2nd page from the search results page.
- Check that page 2 is opened.
- According to the result, a random product is chosen from the displayed products.
- Add the selected product to the basket.
- The accuracy of the price on the product page and the price of the product in the basket is compared.
- By increasing the amount of product, verify that the number of products is 2.
- The product is deleted from the basket and it is checked that the basket is empty. 

## Account used in project
I used a mail address from 10 min mail to register to gittigidiyor.com. Account used for test doesn't have any real information. It's a dummy account.


## License
[MIT](https://choosealicense.com/licenses/mit/)
