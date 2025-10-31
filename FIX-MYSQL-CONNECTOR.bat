@echo off
echo ========================================
echo FIX MySQL: Download MySQL Connector 8.x
echo ========================================
echo.
echo Your system has MySQL 8.0.30
echo But the app has old MySQL Connector 5.1.30
echo.
echo This script will:
echo 1. Download MySQL Connector 8.0.33
echo 2. Replace the old connector in lib folder
echo 3. Update configuration
echo.
pause

cd "c:\laragon\www\Travene pos\lib"

echo.
echo [1/4] Backing up old MySQL connector...
if exist mysql-connector-java-5.1.30.jar (
    ren mysql-connector-java-5.1.30.jar mysql-connector-java-5.1.30.jar.old
    echo OK: Backup created
)

echo.
echo [2/4] Downloading MySQL Connector 8.0.33...
curl -L "https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar" -o mysql-connector-j-8.0.33.jar
if %ERRORLEVEL% NEQ 0 (
    echo FAILED: Could not download
    echo.
    echo Manual download:
    echo https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar
    echo Save to: c:\laragon\www\Travene pos\lib\
    pause
    exit /b 1
)
echo OK: Downloaded

echo.
echo [3/4] Updating config file...
cd "c:\laragon\www\Travene pos"
(
echo # written by PropertiesConfiguration
echo # Fixed for MySQL 8.0
echo.
echo regular_mode = false
echo kitchen_mode = true
echo wwidth = 1920
echo wheight = 1080
echo wlocx = 0
echo wlocy = 0
echo extendedstate = 0
echo database_provider_name = MySQL
echo connection_string = jdbc:mysql://localhost:3306/travenepos?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
echo database_url = localhost
echo database_port = 3306
echo database_name = travenepos
echo database_user = root
echo database_pass =
) > floreantpos.config.properties
echo OK: Config updated

echo.
echo [4/4] Verifying MySQL connection...
mysql -u root travenepos -e "SELECT 'Connection OK' as Status"
if %ERRORLEVEL% NEQ 0 (
    echo WARNING: Could not connect to MySQL
    echo Make sure MySQL is running in Laragon
)

echo.
echo ========================================
echo MySQL Connector Updated!
echo ========================================
echo.
echo Old: mysql-connector-java-5.1.30.jar
echo New: mysql-connector-j-8.0.33.jar
echo.
echo Now run: run-travene.bat
echo.
pause
