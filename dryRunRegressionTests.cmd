cls
call set-env.cmd
mvn clean test -Dcucumber.filter.tags="@RegressionTest" -Dcucumber.execution.dry-run=true