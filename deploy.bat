@echo off
REM Compile toutes les servlets et copie les pages HTML (et WEB-INF/web.xml) dans Tomcat.
REM A placer dans C:\Users\MSI\Desktop\lab1 puis double-cliquer (ou lancer depuis cmd).

set TOMCAT=C:\Users\MSI\Downloads\apache-tomcat-11.0.26-windows-x64\apache-tomcat-11.0.26
set APP=%TOMCAT%\webapps\lab1

cd /d "%~dp0"

REM Nettoyage de l'ancien deploiement (pages et classes supprimees du projet).
REM WEB-INF\web.xml est garde pour que Tomcat recharge l'appli au lieu de la retirer.
if exist "%APP%" (
    for /d %%D in ("%APP%\*") do if /i not "%%~nxD"=="WEB-INF" rmdir /s /q "%%D"
    del /q "%APP%\*.*" 2> nul
    if exist "%APP%\WEB-INF\classes" rmdir /s /q "%APP%\WEB-INF\classes"
)

if not exist "%APP%\WEB-INF\classes" mkdir "%APP%\WEB-INF\classes"

REM Liste de tous les .java du projet
dir /s /b *.java > "%TEMP%\lab1-sources.txt"

echo Compilation...
javac -encoding UTF-8 -cp "%TOMCAT%\lib\servlet-api.jar" -d "%APP%\WEB-INF\classes" @"%TEMP%\lab1-sources.txt"
if errorlevel 1 (
    echo.
    echo *** ERREUR DE COMPILATION ***
    pause
    exit /b 1
)

echo Copie des pages web...
xcopy /e /y /i /q web "%APP%" > nul

REM Met a jour la date de web.xml : Tomcat le surveille et recharge l'appli tout seul
REM (necessaire pour qu'une servlet ajoutee dans web.xml soit prise en compte)
copy /b "%APP%\WEB-INF\web.xml" +,, "%APP%\WEB-INF\web.xml" > nul

echo.
echo OK. Tomcat recharge l'application dans ~10 secondes,
echo puis ouvre http://localhost:8080/lab1/
pause
