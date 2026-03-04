@echo off
echo ======================================
echo Building Jarvis AI Assistant
echo ======================================

where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo Maven not found. Please install Maven first.
    pause
    exit
)

mvn clean package

if not exist dist mkdir dist

copy target\jarvis-assistant-1.0.jar dist\JarvisAssistant.jar

echo.
echo Build finished!
echo File created: dist\JarvisAssistant.jar
pause
