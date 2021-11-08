# How to run tests

## Pre-requisites
1. Make sure `mvn` is installed on your computer.

## Integration Tests

1. Create a `ibmanalyticsengine-service.env` file in the `ibm-iae-java-sdk` directory using `ibmanalyticsengine-service.env.hide` as an example.
1. Update `ibmanalyticsengine-service.env` file with your own **APIKEY**.
1. export your instance guid as `IBM_ANALYTICS_ENGINE_INSTANCE_GUID` environment variable.

1. export your instance guid  for updating instance home as `IBM_ANALYTICS_ENGINE_INSTANCE_HOME_GUID` environment variable.
1. export your HMAC Access Key as `IBM_ANALYTICS_ENGINE_HMAC_ID` environment variable.
1. export your HMAC Secret Key as `IBM_ANALYTICS_ENGINE_HMAC_KEY` environment variable.

1. Go to Project's root directory `ibm-iae-java-sdk/` directory.
1. Run `mvn test -DfailIfNoTests=false -Dtest=IbmAnalyticsEngineApiIT`

## Unit Tests

1. Go to Project's root directory `ibm-iae-java-sdk/` directory.
1. Run `mvn test`.