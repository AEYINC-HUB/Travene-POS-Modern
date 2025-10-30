# Travene POS - Setup Complete!

## Successfully Built & Ready to Run

Your Travene POS system has been successfully built and is ready to use!

## Quick Start

### Running the Application

**Option 1: Use the custom launch script (Recommended)**
```batch
cd "c:\laragon\www\Travene pos"
run-travene.bat
```

**Option 2: Use the original script**
```batch
cd "c:\laragon\www\Travene pos\etc"
tavernerpos.bat
```

## What Was Done

### 1. Maven Installation
- Downloaded Apache Maven 3.9.6
- Installed to: `C:\laragon\tools\apache-maven-3.9.6`

### 2. Build Fixes Applied
- Fixed Java version compatibility (Java 6 → Java 8 bytecode)
- Added JAXB dependencies for Java 8+ compatibility
- Fixed BASE64 encoding (sun.misc → java.util.Base64)
- Disabled problematic buildnumber plugin

### 3. Project Built Successfully
- Compiled 665 Java source files
- Generated JAR: `tavernerPOS.jar` (2.6MB)
- All dependencies copied to `lib/` directory

### 4. Java 17 Compatibility
- Created `run-travene.bat` with proper JVM arguments
- Added module access flags for reflection

## System Information

**Current Setup:**
- Java Version: 17.0.12
- Maven Version: 3.9.6
- Database: Apache Derby (embedded) - Already configured
- Build Tool: Maven

**Project Details:**
- Version: 1.4-TavernerPOS
- Main Class: `com.floreantpos.main.Main`
- Database: Derby embedded database in `target/posdb`

## First Run Setup

When you first run the application:

1. **Database Configuration**
   - The application uses Derby database by default
   - Database files are in `target/posdb`
   - No additional setup needed for Derby

2. **Initial Login**
   - Check the documentation for default credentials
   - You'll be prompted to configure:
     - Terminal settings
     - Printers
     - Menu items
     - Users and permissions

## Database Options

### Option 1: Derby (Default - Embedded)
- Already configured
- No additional setup needed
- Good for single-terminal setups

### Option 2: MySQL (For multi-terminal)
1. Install MySQL server
2. Create a database: `CREATE DATABASE travenepos;`
3. Run the application
4. Go to Login Screen → Database Configuration
5. Select MySQL and enter connection details
6. Click "Create Database Schema"

### Option 3: PostgreSQL (For multi-terminal)
1. Install PostgreSQL server
2. Create a database: `CREATE DATABASE travenepos;`
3. Run the application
4. Go to Login Screen → Database Configuration
5. Select PostgreSQL and enter connection details
6. Click "Create Database Schema"

## Configuration Files

**Important Files:**
- [config/printers.xml](config/printers.xml) - Printer configuration
- [config/logo.png](config/logo.png) - Application logo
- [config/receipt-logo.jpg](config/receipt-logo.jpg) - Receipt logo
- [i18n/messages*.properties](i18n/) - Language files

## Troubleshooting

### Application Won't Start
- Make sure Java 17 is installed
- Use `run-travene.bat` (has proper Java flags)
- Check that `lib/` directory exists and contains JARs

### Database Connection Errors
- For Derby: Check that `target/posdb` directory exists
- For MySQL/PostgreSQL: Verify server is running and credentials are correct

### Printer Issues
- Edit [config/printers.xml](config/printers.xml)
- Set printer names to match your Windows printer names
- You can find printer names in Windows Settings → Printers

## Features

- **Order Management**: Dine-in, takeout, and bar sales
- **Kitchen Printing**: Automatic printing to kitchen printers
- **Payment Processing**: Cash, card, and multiple payment types
- **Inventory**: Basic inventory tracking
- **Reporting**: Sales, tips, journals, and analytics
- **Multi-user**: User management with permissions
- **Table Management**: For restaurant setups
- **Tax Calculation**: Including VAT support
- **Receipt Printing**: Customizable receipts

## Support & Documentation

- Original Project: FloreantPOS (forked from)
- License: Moonrank Public License (see [config/licence.html](config/licence.html))
- Version: TavernerPOS 1.4

## Development

### To Rebuild the Project:
```batch
cd "c:\laragon\www\Travene pos"
set PATH=C:\laragon\tools\apache-maven-3.9.6\bin;%PATH%
mvn clean package -DskipTests
copy target\tavernerPOS.jar .
```

### Project Structure:
- `src/` - Java source code
- `config/` - Configuration files
- `i18n/` - Internationalization files
- `database/` - Database scripts
- `lib/` - Runtime dependencies
- `target/` - Build output

## Notes

- The default admin password should be changed after first login
- Regular backups of the database are recommended
- For production use, consider MySQL or PostgreSQL
- The embedded Derby database is best for single-terminal setups

---

**Status:** Ready to Run!

Run `run-travene.bat` to start your Point of Sale system.
