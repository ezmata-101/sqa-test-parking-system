# Assignment Announcement: Unit Testing — Parking Slot Booking (With Intentional Defects)

* **Assignment Type:** Individual or a group of maximum 3 students
* **Deadline:** **Wednesday, October 15, 2025, 11:59 PM**
* **Submission file:** `<student_id>_unit_test.zip` (structure below)

---

## Objective

You will read the provided Java codebase and design comprehensive **JUnit tests** for each class. Your tests must both validate intended behaviors and reveal defects. You will also submit a short report documenting **why** each test exists, its **verdict**, and any **comments/observations**, plus a **separate defects list** with suggested fixes.

> You will find the documentation in `documentation.md` file and the codebase in the `src/` directory.

**Do not modify production code.** Your job is to test it, document behaviors, and recommend fixes.

---

## What to Submit

Submit a **single ZIP** named exactly:

```
<student_id>_unit_test.zip
```

**Inside the ZIP:**

```
test/
  VehicleTest.java
  WalletTest.java
  ParkingSlotTest.java
  BookingTest.java
  ParkingSystemTest.java
<student_id>_unit_test_report.pdf
```

* Put **only your test files** in `test/`. **Do not include** the source code, class files or build files under test.
* The PDF report format is described below.
* **Ensure the ZIP structure is exactly as shown**. As an automated script will check your tests.

---

## Report Requirements (`<student_id>_unit_test_report.pdf`)

### A) Test Case List (table)

For every test you wrote, include a row with the following columns:

* **Test ID**.
* **Class.Method** under test.
* **Why this test?** should state the specific rule/edge case.
* **Verdict** is the test outcome against the current code.
* **Comments/Observations** on behavior, exceptions, edge cases, etc.

### B) Defects List (separate section)

List **each discovered defect** with a suggested fix:
* **Defect ID**.
* **Class.Method** where the defect was found.
* **Description** of the defect.
* **Suggested Fix** (brief, no code needed).


### Running Tests

* Your tests should compile & run in a standard JUnit 5 setup.
* If you use Maven/Gradle locally, keep config simple; **do not** include build files in the ZIP.

---

## Academic Integrity

* **Any form of unfair means** (plagiarism, sharing code, AI-generated tests or collusion, etc.) is strictly prohibited.
* **Penalty:** score **0** on this assignment **and** deduction from other assessments.

---

## Reminders

* **Design tests to be order-independent** and resilient to the system’s static global state.
* Document current behavior even when you believe it’s wrong; reflect that in verdict and defects sections.

---
Best of luck!
