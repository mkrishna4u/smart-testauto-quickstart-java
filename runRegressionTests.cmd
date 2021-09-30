cls
call set-env.cmd
mvn clean verify -Dcucumber.filter.tags="@RegressionTest"