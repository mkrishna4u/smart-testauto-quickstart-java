cls
call set-env.cmd
mvn clean verify -Dcucumber.filter.tags="@RegressionTest" -Dmaven.surefire.debug=true