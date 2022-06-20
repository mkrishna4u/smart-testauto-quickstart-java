@echo off
cls
call set-env.cmd
set envName=%1
if "%envName%"=="" ( mvn clean verify -Dcucumber.filter.tags="@RegressionTest" -Dparallel.threads=1 ) else ( mvn clean verify -Dcucumber.filter.tags="@RegressionTest" -Dapps.active.environment=github-app:%envName% -Dparallel.threads=1)