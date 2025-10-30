@echo off
echo ========================================
echo QUICK FIX: Switching to Derby Database
echo ========================================
echo.
echo This will switch from MySQL to Derby (embedded database)
echo Derby doesn't need MySQL server - it works standalone!
echo.
pause

cd "c:\laragon\www\Travene pos"

echo Creating backup of config...
copy floreantpos.config.properties floreantpos.config.properties.bak >nul 2>&1

echo.
echo Writing new configuration...
(
echo # written by PropertiesConfiguration
echo # Fixed for Derby Database
echo.
echo regular_mode = false
echo kitchen_mode = true
echo wwidth = 1920
echo wheight = 1080
echo wlocx = 0
echo wlocy = 0
echo extendedstate = 0
echo database_provider_name = Derby Embedded
echo connection_string = jdbc:derby:target/posdb;create=true
echo database_url = localhost
echo database_port = 1527
echo database_name = posdb
echo database_user =
echo database_pass =
) > floreantpos.config.properties

echo.
echo ========================================
echo Configuration Updated!
echo ========================================
echo.
echo Database changed to: Derby Embedded
echo Connection: jdbc:derby:target/posdb;create=true
echo.
echo Now run: run-travene.bat
echo.
echo (Backup saved as: floreantpos.config.properties.bak)
echo.
pause
