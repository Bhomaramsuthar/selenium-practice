
## 🏗️ Architecture
This framework is built using the **Page Object Model (POM)** design pattern to ensure code reusability, maintainability, and clear separation between test logic and page interactions. 

### Directory Structure
- `part3_4.com.demoqa.base`: Contains all Page Classes. Responsible for locators (XPath, CSS Selectors) and explicit wait strategies.
- `part3_4.com.demoqa.tests`: Contains TestNG execution classes. Responsible for test flows, assertions, and browser lifecycle management.

## 🚀 Key Features & Modules Tested

**1. Core Web Elements**
- **Check Boxes:** Handled dynamic React element rendering using Explicit Waits (`WebDriverWait`).
- **Radio Buttons:** Bypassed hidden `<input>` tags by targeting interactable `<label>` elements.
- **Web Tables:** Executed full CRUD workflows (Search, Edit, Submit) and validated dynamic DOM table body refreshes.

**2. Alerts, Frames, and Windows**
- **Browser Windows:** Managed WebDriver context switching between multiple active tabs and popup windows.
- **JavaScript Alerts:** Handled timed alerts and confirmation dialog boxes using `driver.switchTo().alert()`.
- **iFrames:** Navigated independent HTML documents embedded within the main page.
- **Nested Frames:** Achieved multi-level frame indexing and seamless context resets (`defaultContent()`).
- **Modal Dialogs:** Validated standard HTML/CSS modal popup workflows.

**3. Widgets**
- **Accordians:** Synchronized test execution with CSS slide-down animations to ensure accurate text retrieval.

## 💻 Tech Stack
- **Language:** Java 25
- **Automation Tool:** Selenium WebDriver 4.44.0
- **Testing Framework:** TestNG 7.10.2
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

## ⚙️ Setup and Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Bhomaramsuthar/selenium-practice

    ```

2. **Install dependencies:**
   Ensure Maven is installed and reload the `pom.xml` to download Selenium and TestNG dependencies.
3. **Run the tests:**
* Execute individual tests directly from IntelliJ by clicking the run icon next to any `@Test` annotation.
* Or, run the full suite via Maven:
```bash
mvn clean test

```





## 🛡️ Automation Strategies Implemented

* **Robust Locators:** Prioritized stable accessibility tags (e.g., `role="row"`) and semantic CSS over fragile class names.
* **Active Synchronization:** Eliminated flaky `Thread.sleep()` and `implicitlyWait()` calls in favor of precise `WebDriverWait` explicit conditions (e.g., `elementToBeClickable`, `visibilityOfElementLocated`).

---

### Author

**Bhomaram Balaram Suthar**
📧 bhomaramsuthar1027@gmail.com



