@echo off
docker info >nul 2>&1
if errorlevel 1 (
    echo Docker chua duoc chay. Vui long khoi dong Docker Desktop va thu lai.
    timeout /t 15 /nobreak
    exit /b 1
)

echo Dang khoi chay cac container theo docker-compose...
docker-compose up -d

if errorlevel 1 (
    echo Da xay ra loi khi khoi chay cac container.
    timeout /t 15 /nobreak
    exit /b 1
) else (
    powershell -Command "Write-Host '=====================================================' -ForegroundColor Blue"
    powershell -Command "Write-Host '========== DA KHOI CHAY DICH VU THANH CONG ==========' -ForegroundColor Blue"
    powershell -Command "Write-Host '=====================================================' -ForegroundColor Blue"
)

start http://localhost:8080/swagger-ui/index.html

timeout /t 5 /nobreak

exit /b 0
