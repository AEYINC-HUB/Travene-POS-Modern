# Travene POS - Database Setup Guide

## Current Configuration

Your system is configured to use **MySQL** database:
- **Host:** localhost
- **Port:** 3306
- **Database:** travenepos
- **Username:** root
- **Password:** (empty)

Configuration file: [floreantpos.config.properties](floreantpos.config.properties)

## Quick Fix - Connection Issues

### Issue: Application fails to connect to MySQL

**Solution 1: Updated Connection String** ✅
I've already updated your connection string with these parameters:
```
useSSL=false
allowPublicKeyRetrieval=true
serverTimezone=UTC
characterEncoding=UTF-8
```

**Solution 2: Verify MySQL is Running**
```batch
mysql -u root -e "SELECT VERSION()"
```

**Solution 3: Check if Database Exists**
```batch
mysql -u root -e "SHOW DATABASES LIKE 'travenepos'"
```

## First Run Setup

### Method 1: Let the Application Create Tables (Recommended)

1. Make sure MySQL is running in Laragon
2. Run the application: `run-travene.bat`
3. When you see the login screen:
   - Click "Database Configuration" (if available)
   - OR the application will try to auto-create tables
4. If prompted, click "Create Database Schema"

### Method 2: Manual SQL Import (If automatic creation fails)

Check if there's a SQL file in the database folder:

```batch
cd "c:\laragon\www\Travene pos\database"
dir *.sql
```

If you find SQL files, import them:
```batch
mysql -u root travenepos < schema.sql
mysql -u root travenepos < initial-data.sql
```

## Troubleshooting

### Error: "Connection refused" or "Unknown database"

**Check 1: MySQL Service Running**
- Open Laragon
- Make sure MySQL service is started (green light)
- Or click "Start All"

**Check 2: Database Exists**
```batch
mysql -u root -e "CREATE DATABASE IF NOT EXISTS travenepos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci"
```

**Check 3: User Permissions**
```batch
mysql -u root -e "GRANT ALL PRIVILEGES ON travenepos.* TO 'root'@'localhost'"
mysql -u root -e "FLUSH PRIVILEGES"
```

### Error: "Public Key Retrieval is not allowed"

This is already fixed in the updated connection string. If you still see it:
1. Check [floreantpos.config.properties](floreantpos.config.properties)
2. Make sure connection_string includes: `allowPublicKeyRetrieval=true`

### Error: "Communications link failure"

**Option A: Check MySQL Port**
```batch
netstat -an | findstr "3306"
```
Should show: `0.0.0.0:3306` or `127.0.0.1:3306`

**Option B: Test Connection Manually**
```batch
mysql -u root -h localhost -P 3306 travenepos
```

### Error: "Access denied for user 'root'"

If you have a MySQL password:
1. Edit [floreantpos.config.properties](floreantpos.config.properties)
2. Update line 17:
```properties
database_pass = YourPasswordHere
```

## Switching Between Databases

### Option 1: Use Derby (Embedded - No MySQL needed)

Edit [floreantpos.config.properties](floreantpos.config.properties):
```properties
database_provider_name = Derby Embedded
connection_string = jdbc:derby:database/derby-server/posdb;create=true
```

Then restart the application.

### Option 2: Use PostgreSQL

1. Install PostgreSQL
2. Create database:
```sql
CREATE DATABASE travenepos WITH ENCODING 'UTF8';
```

3. Edit [floreantpos.config.properties](floreantpos.config.properties):
```properties
database_provider_name = PostgreSQL
connection_string = jdbc:postgresql://localhost:5432/travenepos
database_url = localhost
database_port = 5432
database_name = travenepos
database_user = postgres
database_pass = YourPostgresPassword
```

## Common Connection Strings

### MySQL (Current - Updated)
```
jdbc:mysql://localhost:3306/travenepos?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8
```

### MySQL (Alternative - with password)
```
jdbc:mysql://localhost:3306/travenepos?user=root&password=YourPass&useSSL=false&serverTimezone=UTC
```

### Derby Embedded (Default)
```
jdbc:derby:database/derby-server/posdb;create=true
```

### PostgreSQL
```
jdbc:postgresql://localhost:5432/travenepos
```

## Testing Your Connection

### Test 1: MySQL Command Line
```batch
mysql -u root travenepos -e "SELECT NOW() as CurrentTime, DATABASE() as CurrentDB"
```

Expected output:
```
+---------------------+-------------+
| CurrentTime         | CurrentDB   |
+---------------------+-------------+
| 2025-10-30 16:00:00 | travenepos  |
+---------------------+-------------+
```

### Test 2: Check MySQL Version
```batch
mysql -u root -e "SELECT VERSION()"
```

### Test 3: Verify Database Exists and is Empty
```batch
mysql -u root -e "USE travenepos; SHOW TABLES"
```

If empty, that's OK - application will create tables on first run.

## What Happens on First Run?

When you start the application for the first time:

1. **Application connects to MySQL** using settings from config file
2. **Hibernate ORM** detects that tables don't exist
3. **Tables are auto-created** based on Java entity classes
4. **Initial data is inserted** (default admin user, etc.)
5. **Login screen appears** - you can now log in

## Database Schema

The application will create approximately 70+ tables including:
- Users and permissions
- Menu items, categories, groups
- Orders and tickets
- Payments and transactions
- Inventory
- Reports and analytics
- Configuration tables

## Need to Reset?

### Complete Database Reset
```batch
mysql -u root -e "DROP DATABASE IF EXISTS travenepos"
mysql -u root -e "CREATE DATABASE travenepos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci"
```

Then restart the application to recreate all tables fresh.

## Still Having Issues?

1. **Check Laragon MySQL logs:**
   - `C:\laragon\data\mysql\<hostname>.err`

2. **Check application logs:**
   - Look in the Travene POS directory for `.log` files

3. **Try Derby instead:**
   - Edit config to use Derby Embedded (see above)
   - Much simpler for single-terminal setups

4. **MySQL Version Issues:**
   - Travene POS works best with MySQL 5.5 - 8.0
   - Check version: `mysql -V`

---

## Quick Command Reference

```batch
# Start MySQL in Laragon
# (Just click "Start All" in Laragon UI)

# Create database
mysql -u root -e "CREATE DATABASE IF NOT EXISTS travenepos"

# Test connection
mysql -u root travenepos -e "SELECT 1"

# View configuration
type "floreantpos.config.properties"

# Run application
run-travene.bat
```

---

**Current Status:**
- ✅ Database 'travenepos' exists
- ✅ MySQL is accessible
- ✅ Connection string updated with compatibility parameters
- ⏳ Ready to run application

Try running `run-travene.bat` now!
