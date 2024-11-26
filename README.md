# DemoSelenium
Selenium Demo project

What you need to run project:
- Allure cli
- Java
- IDE for java, nice to have

  When you download project load maven dependencies. When all dependencied downloaded you can go to file src\test\java\tests and find package scenario where you will find test scenario:
![image](https://github.com/user-attachments/assets/2e0d5160-0ea6-430a-8943-d41043a17e60)

You can run all tests in one run click on class, or choose one test to run. Every time when you run tests file with allure reports automatically clear.
If you need to look on allure report you can type in command line command: allure serve allure-results after few seconds will open allure report file.
![image](https://github.com/user-attachments/assets/aca68616-25ac-4366-96d2-ba9c68b44553)

Opportunities to develop project:
- add spring boot to run tests from api, easier to setting permission and user don't need to download code,
- add gherkin to have step definition typical for gherkin, better to present tests and give opportunity to write tests for no technical coworkers,
- put credentials to something like secrets for security
- add additional exception handling like make screenshoots or rethrow exceptions(that sounds good but need more unstable app to do that)
- 
