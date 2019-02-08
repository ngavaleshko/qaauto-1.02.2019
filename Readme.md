# Readme

Explanation of all tools that needs to be installed/configured to work with your project

  1. Visit the site below and download java accordionly to your PC requirements: [www.oracle.com](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html )
  2. Install java
  3. Open cmd and check java -version
  4. Download [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/#section=windows) for free
  4. Install IntelliJ IDEA
  5. Then create your own project :
  > Maven -> next
  > Group Id -> com.skillUp (for commercial) (org. for free)
  > Artifact Id -> qaauto-1.02.2019
  > Project Location
  > Maven Prject need to be imported: enable auto import
  > folder idea - settings/ temporary files
  >        java- resourses
  >  folder tests -autotests for product

  6. For Browser running you need to download: [ChromeDriver](http://chromedriver.chromium.org/downloads)
  7. Also we need Maven Selenium [MVNrepository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)
  * Copy maven xml
  * add it to pom.xlm
  * Add
  ```sh
   <dependencies>
  ....
    </dependencies>
  ```

## Some tips!

| Commands | response |Note|
| ------ | ------ | ------ |
| psv |public static void main |method |
| sou |sistem.out.println |method |
|searchField.clear();| to clean the field||
|driver.close();|to stop the driver|
|driver.quit();|to quite the browser|
