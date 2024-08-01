# Let's create a README file with the provided content.

readme_content = """
# Pay Slip and Document Generation Script

This project provides a Google Apps Script for generating pay slips and other documents using Google Document templates. The script processes JSON data, replaces placeholders with actual data, and saves the documents to Google Drive. It also emails the generated documents to the candidate.

## Table of Contents
1. [Overview](#overview)
2. [Setup](#setup)
3. [Script Functions](#script-functions)
    - [doGet(e)](#dogete)
    - [generateSalaryMonths(salaryFrom, salaryTo)](#generatesalarymonthssalaryfrom-salaryto)
    - [paymentSlip(template)](#paymentsliptemplate)
    - [sendEmail(template, attachmentBlobs)](#sendemailtemplate-attachmentblobs)
    - [createCompanyFolder(parentFolderId, companyName)](#createcompanyfolderparentfolderid-companyname)
    - [createCandidateFolder(parentFolder, candidateName)](#createcandidatefolderparentfolder-candidatename)
    - [deleteTempFiles(folder)](#deletetempfilesfolder)
    - [getOrCreateFolderByName(folderName)](#getorcreatefolderbynamefoldername)
4. [Template Placeholders](#template-placeholders)
5. [Example Template Document](#example-template-document)
6. [Notes](#notes)
7. [License](#license)
8. [Contact](#contact)

## Overview

The script performs the following tasks:
1. **Receive and Parse JSON Data**: Extracts data from a JSON object provided via an HTTP request.
2. **Generate Documents**: Replaces placeholders in Google Document templates with actual data.
3. **Save Documents to Google Drive**: Saves the generated documents as PDF files in a structured folder hierarchy.
4. **Send Documents via Email**: Sends the generated documents to the candidate's email.

## Setup

1. **Create Google Document Templates**:
   - Design your templates in Google Docs.
   - Use placeholders as described below.

2. **Deploy the Google Apps Script**:
   - Create a new Google Apps Script project.
   - Copy and paste the provided script into the project.
   - Set up a web app deployment to receive HTTP requests.

## Script Functions

### `doGet(e)`

Handles incoming HTTP GET requests. Parses JSON data, extracts relevant information, and calls the `paymentSlip` function.

**Parameters**:
- `e` - HTTP request object containing `jsonData`.

**Returns**:
- A JSON response indicating the status of document generation.

### `generateSalaryMonths(salaryFrom, salaryTo)`

Generates a list of formatted month-year strings between `salaryFrom` and `salaryTo`.

**Parameters**:
- `salaryFrom` - Start date of the salary period.
- `salaryTo` - End date of the salary period.

**Returns**:
- An array of month-year strings.

### `paymentSlip(template)`

Generates documents by replacing placeholders in the template documents and saves them as PDFs in Google Drive.

**Parameters**:
- `template` - An object containing candidate and salary details.

**Returns**:
- An array of objects representing the generated documents.

### `sendEmail(template, attachmentBlobs)`

Sends an email with the generated documents as attachments.

**Parameters**:
- `template` - An object containing candidate details.
- `attachmentBlobs` - An array of Blob objects representing the attachments.

### `createCompanyFolder(parentFolderId, companyName)`

Creates or retrieves a folder for the company within a specified parent folder.

**Parameters**:
- `parentFolderId` - ID of the parent folder.
- `companyName` - Name of the company.

**Returns**:
- The folder object for the company.

### `createCandidateFolder(parentFolder, candidateName)`

Creates or retrieves a folder for the candidate within a specified company folder.

**Parameters**:
- `parentFolder` - The parent folder for the company.
- `candidateName` - The name of the candidate.

**Returns**:
- The folder object for the candidate.

### `deleteTempFiles(folder)`

Deletes all files within a specified folder.

**Parameters**:
- `folder` - The folder to clean.

### `getOrCreateFolderByName(folderName)`

Retrieves an existing folder by name or creates a new one if it doesn't exist.

**Parameters**:
- `folderName` - The name of the folder.

**Returns**:
- The folder object.

## Template Placeholders

The following placeholders should be included in your Google Docs template:

- **`{Name}`**: Candidate's full name.
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
- **`{BankName}`**: Name of the bank.
- **`{IfscCode}`**: IFSC code of the bank.
- **`{AccountNo}`**: Account number.
- **`{AccountHolderName}`**: Account holder's name.
- **`{UanNumber}`**: UAN number.
- **`{EsiNumber}`**: ESI number.
- **`{AadarNumber}`**: Aadhar number.
- **`{PanNumber}`**: PAN (Permanent Account Number).

## Example Template Document

Here’s an example of how your template document might look:


## Notes

- Ensure that the placeholders in the template exactly match those specified above.
- The script requires access to Google Drive and Google Docs to create and manage files.
- The script uses Google Apps Script's `MailApp` to send emails.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or support, contact [Your Name](mailto:your.email@example.com).
"""

# Write the content to a README.md file
with open("/mnt/data/README.md", "w") as file:
    file.write(readme_content)

"/mnt/data/README.md"
