@echo off
cls
call set-env.cmd
set envName=%1
if "%envName%"=="" ( mvn clean verify -Dcucumber.filter.tags="@RegressionTest" ) else ( mvn clean verify -Dcucumber.filter.tags="@RegressionTest" -Dapps.active.environment=github-app:%envName% )