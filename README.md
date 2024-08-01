# Pay Slip Generation Script

This project provides a Google Apps Script for generating pay slips using a Google Document template. The script processes JSON data, generates pay slips for a specified salary period, and saves them to Google Drive.

## Overview

The script performs the following tasks:
1. **Receive and Parse JSON Data**: Extracts data from a JSON object.
2. **Generate Salary Months**: Creates a list of months within the salary period.
3. **Generate Pay Slips**: Creates pay slips by replacing placeholders in a Google Document template.
4. **Save Pay Slips to Google Drive**: Saves the generated pay slips as PDF files in Google Drive.

## Setup

1. **Create a Google Document Template**:
   - Design your template in Google Docs.
   - Use placeholders as described below.

2. **Deploy the Google Apps Script**:
   - Create a new Google Apps Script project.
   - Copy and paste the provided script into the project.
   - Set up a web app deployment to receive HTTP requests.

## Script Functions

### `doGet(e)`

Handles incoming HTTP GET requests. Parses JSON data, extracts relevant information, and calls the `paymentSlip` function.

**Parameters**:
- `e` - HTTP request object containing `responseJson`.

**Returns**:
- A text response indicating success or failure.

### `generateSalaryMonths(salaryFrom, salaryTo)`

Generates a list of formatted month-year strings between `salaryFrom` and `salaryTo`.

**Parameters**:
- `salaryFrom` - Start date of the salary period.
- `salaryTo` - End date of the salary period.

**Returns**:
- An array of month-year strings.

### `paymentSlip(template)`

Generates pay slips by replacing placeholders in the template document and saves them as PDFs in Google Drive.

**Parameters**:
- `template` - An object containing candidate and salary details.

**Returns**:
- An array of `Blob` objects representing the generated PDF files.

### `createFolders(parentFolderName, folderNames)`

Creates specified folders under a given parent folder in Google Drive.

**Parameters**:
- `parentFolderName` - Name of the parent folder.
- `folderNames` - Array of folder names to create.

**Returns**:
- An array of created folders.

### `deleteFolderContents(folder)`

Deletes all files within a specified folder.

**Parameters**:
- `folder` - The folder to clean.

## Template Placeholders

The following placeholders should be included in your Google Docs template:

- **`{Name}`**: Candidate's full name.
- **`{SalaryMonths}`**: Formatted month and year for the salary period.
- **`{CompanyName}`**: Name of the company.
- **`{OfferDate}`**: Date when the offer was made.
- **`{JoiningDate}`**: Date of joining.
- **`{JobTitle}`**: Job title.
- **`{EmployeeCode}`**: Unique employee code.
- **`{SalaryInWord}`**: Salary amount in words.
- **`CTC`**: Cost to Company amount.
- **`EPF`**: Employee Provident Fund amount.
- **`Gratuity`**: Gratuity amount.
- **`HRA`**: House Rent Allowance amount.
- **`ProfTax`**: Professional Tax amount.
- **`InTax`**: Income Tax amount.
- **`MediInsu`**: Medical Insurance amount.
- **`Invest80C`**: Investment under Section 80C amount.
- **`PerfBonus`**: Performance Bonus amount.
- **`GrossSalary`**: Total gross salary.
- **`InHSalary`**: In-hand salary.
- **`MonGrSalary`**: Monthly gross salary.
- **`MonInHSalary`**: Monthly in-hand salary.
- **`{PanNumber}`**: PAN (Permanent Account Number) of the candidate.

## Example Template Document

Here’s an example of how your template document might look:

