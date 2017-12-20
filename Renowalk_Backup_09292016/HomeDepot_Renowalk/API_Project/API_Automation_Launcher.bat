@echo off
cd C:\Program Files\SmartBear\SoapUI-5.2.0\bin
start /min testrunner.bat "C:\Users\sarshad\workspace\HomeDepot_Renowalk\API_Project\RenoWalk_API_Automation.xml" -sRenoWalk_API_TestDriver_TS ^& exit

exit /b 0

