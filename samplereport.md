# Unit Testing Report: Parking System Management

## 0) Team Members

* **011201YYY** - Jane Doe
* **011201ZZZ** - John Smith
* **011201AAA** - Alice Brown

---

## A) Test Case List

| Test ID | Class.Method Under Test | Why this test? | Verdict | Comments/Observations |
| --- | --- | --- | --- | --- |
| **TC-01** | `Book.setISBN` | Verify if the ISBN format (13 digits) is validated. | **FAIL** | System accepts 5-digit strings without error. |
| **TC-02** | `Member.borrowBook` | Test if a member can borrow more than the limit (5 books). | **PASS** | Correctly returns `False` when the 6th book is added. |

---

## B) Defects List

### **Defect ID: BUG-01**

* **Class.Method:** `Book.setISBN(String isbn)`
* **Description:** The system lacks a length and format check for ISBN strings. This allows invalid data entry into the database, which could break future search queries.
* **Suggested Fix:** Implement a Regular Expression (Regex) check to ensure the input is exactly 13 digits.

### **Defect ID: BUG-02**

* **Class.Method:** `Fine.calculate(int daysLate)`
* **Description:** The logic used to calculate fines starts the multiplier at 1 even if `daysLate` is 0. This results in users being charged for on-time returns.
* **Suggested Fix:** Change the conditional logic to return 0 immediately if `daysLate <= 0`.

---

## C) Individual Contribution

* **Jane Doe:** Focused on `MemberTest.java` and conducted boundary value analysis on borrowing limits.
* **John Smith:** Developed `LibraryTest.java` and performed integration testing for the search functionality.
* **Alice Brown:** Wrote `FineTest.java`, discovered the fine calculation logic error (BUG-02), and compiled the final Markdown report.

---
