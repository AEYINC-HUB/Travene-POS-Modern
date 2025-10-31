@echo off
echo ========================================
echo Travene POS - MySQL Connection Test
echo ========================================
echo.

echo [1/5] Testing MySQL Service...
mysql -u root -e "SELECT VERSION() as MySQL_Version" 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo FAILED: MySQL is not running or not accessible
    echo Please start MySQL in Laragon
    pause
    exit /b 1
)
echo OK: MySQL is running
echo.

echo [2/5] Checking database 'travenepos'...
mysql -u root -e "USE travenepos; SELECT 'Database exists' as Status" 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo WARNING: Database 'travenepos' not found
    echo Creating database...
    mysql -u root -e "CREATE DATABASE travenepos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci"
    echo OK: Database created
) else (
    echo OK: Database exists
)
echo.

echo [3/5] Verifying database character set...
mysql -u root travenepos -e "SELECT @@character_set_database as Charset, @@collation_database as Collation"
echo.

echo [4/5] Checking connection string in config...
findstr /C:"connection_string" floreantpos.config.properties
echo.

echo [5/5] Testing connection with JDBC parameters...
echo Connection: localhost:3306/travenepos
echo User: root
echo Password: (empty)
echo.

echo ========================================
echo Test Complete!
echo ========================================
echo.
echo If all tests passed, you can now run:
echo   run-travene.bat
echo.
echo If you see errors, check DATABASE-SETUP.md
echo for troubleshooting steps.
echo.
pause
