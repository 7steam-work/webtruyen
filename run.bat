@echo off
color 0A

echo Bat dau thiet lap dich vu BE

REM Check and start Docker if not running
echo Kiem tra trang thai Docker...
docker info >nul 2>nul
if %errorlevel% neq 0 (
   echo Docker khong hoat dong, khoi dong Docker Desktop truoc!
   pause
   exit /b
)

REM Clean and stop existing containers
echo Don dep cac Container chua hien co...
docker-compose down >nul 2>nul

REM Start database and phpmyadmin first
echo Dang khoi dong moi truong CSDL...
docker-compose up -d db phpmyadmin
if %errorlevel% neq 0 (
   echo Khong khoi dong duoc moi truong co so du lieu! Vui long kiem tra cac loi o tren.
   pause
   exit /b
)

REM Wait for database to be ready
echo Dang cho co so du lieu san sang...
timeout /t 20 /nobreak

REM Now build and run the Java application
echo Xay dung Maven project...
call mvn clean package -P dev
if %errorlevel% neq 0 (
   echo Dung Maven khong thanh cong! Vui long kiem tra cac loi o tren.
   pause
   exit /b
)

REM Start API service
echo Dang khoi dong API service...
docker-compose up -d api-service

echo.
echo ===============================
echo    HOAN TAT CAI DAT!
echo ===============================
echo.
echo Co so du lieu co san tai localhost:3306
echo PHPMyAdmin tai http://localhost:8000
echo Swagger UI tai http://localhost:8080/swagger-ui/index.html
echo.

REM Open browser
start http://localhost:8000
start http://localhost:8080/swagger-ui/index.html

echo Cua so se tu dong dong sau:
for /l %%i in (3,-1,1) do (
   echo %%i giay...
   timeout /t 1 /nobreak >nul
)
exit
